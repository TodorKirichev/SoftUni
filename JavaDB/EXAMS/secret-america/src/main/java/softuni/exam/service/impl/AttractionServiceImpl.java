package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AttractionImportDto;
import softuni.exam.models.entity.Attraction;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.AttractionRepository;
import softuni.exam.service.AttractionService;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Set;

@Service

public class AttractionServiceImpl implements AttractionService {

    private static final String ATTRACTIONS_PATH = "src/main/resources/files/json/attractions.json";
    private final AttractionRepository attractionRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final CountryService countryService;

    public AttractionServiceImpl(AttractionRepository attractionRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson, CountryService countryService) {
        this.attractionRepository = attractionRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.countryService = countryService;
    }

    @Override
    public boolean areImported() {
        return attractionRepository.count() > 0;
    }

    @Override
    public String readAttractionsFileContent() throws IOException {
        return Files.readString(Path.of(ATTRACTIONS_PATH));
    }

    @Override
    public String importAttractions() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readAttractionsFileContent(), AttractionImportDto[].class))
                .filter(attractionImportDto -> {
                    boolean isValid = validationUtil.isValid(attractionImportDto);

                    Attraction attraction = attractionRepository.findByName(attractionImportDto.getName());

                    if (attraction != null) {
                        isValid = false;
                    }

                    if (isValid) {
                        sb.append(String.format("Successfully imported attraction %s",
                                attractionImportDto.getName()));
                    } else {
                        sb.append("Invalid attraction");
                    }
                    sb.append(System.lineSeparator());

                    return isValid;
                }).map(attractionImportDto -> {
                    Attraction attraction = modelMapper.map(attractionImportDto, Attraction.class);

                    Country country = countryService.findCountryById(attractionImportDto.getCountry());

                    attraction.setCountry(country);

                    return attraction;
                }).forEach(attractionRepository::save);

        return sb.toString().trim();
    }

    @Override
    public String exportAttractions() {
        StringBuilder sb = new StringBuilder();

        Set<Attraction> attractions = attractionRepository
                .findAllAttractionsWithHistoricalOrArchaelogicalSiteWithElevationMoreOrEqualTo300("historical site", "archaeological site", 300);
        attractions.forEach(attraction -> {
            sb.append(String.format("Attraction with ID%d:\n" +
                    "***%s - %s at an altitude of %dm. somewhere in %s.",
                    attraction.getId(),
                    attraction.getName(),
                    attraction.getDescription(),
                    attraction.getElevation(),
                    attraction.getCountry().getName()))
                    .append(System.lineSeparator());
        });

        return sb.toString().trim();
    }

    @Override
    public Attraction findAttractionById(long id) {
        return attractionRepository.findById(id);
    }
}
