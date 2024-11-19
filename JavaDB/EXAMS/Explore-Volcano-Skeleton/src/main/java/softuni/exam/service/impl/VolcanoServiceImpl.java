package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.VolcanoImportDto;
import softuni.exam.models.entity.Country;
import softuni.exam.models.entity.Volcano;
import softuni.exam.repository.VolcanoRepository;
import softuni.exam.service.CountryService;
import softuni.exam.service.VolcanoService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Set;

import static softuni.exam.messages.Message.INVALID_VOLCANO;
import static softuni.exam.messages.Message.SUCCESSFULLY_IMPORTED_VOLCANO;

@Service
public class VolcanoServiceImpl implements VolcanoService {

    public static final String VOLCANOES_FILE_PATH = "src/main/resources/files/json/volcanoes.json";
    public static final int MIN_ELEVATION = 3000;
    private final VolcanoRepository volcanoRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final CountryService countryService;

    public VolcanoServiceImpl(VolcanoRepository volcanoRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson, CountryService countryService) {
        this.volcanoRepository = volcanoRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.countryService = countryService;
    }

    @Override
    public boolean areImported() {
        return volcanoRepository.count() > 0;
    }

    @Override
    public String readVolcanoesFileContent() throws IOException {
        return Files.readString(Path.of(VOLCANOES_FILE_PATH));
    }

    @Override
    public String importVolcanoes() throws IOException {
        StringBuilder sb = new StringBuilder();

        VolcanoImportDto[] volcanoImportDtos = gson.fromJson(readVolcanoesFileContent(), VolcanoImportDto[].class);

        Arrays.stream(volcanoImportDtos).filter(volcanoImportDto -> {
            boolean isValid = validationUtil.isValid(volcanoImportDto);

            Volcano volcano = volcanoRepository.findByName(volcanoImportDto.getName());

            if (volcano != null) {
                isValid = false;
            }

            if (isValid) {
                sb.append(String.format(SUCCESSFULLY_IMPORTED_VOLCANO,
                        volcanoImportDto.getName(),
                        volcanoImportDto.getVolcanoType()));
            } else {
                sb.append(INVALID_VOLCANO);
            }
            sb.append(System.lineSeparator());

            return isValid;
        }).map(volcanoImportDto -> {
            Volcano volcano = modelMapper.map(volcanoImportDto, Volcano.class);

            Country country = countryService.findCountryById(volcanoImportDto.getCountry());
            country.getVolcanoes().add(volcano);
            countryService.saveCountry(country);

            volcano.setCountry(country);

            return volcano;
        }).forEach(volcanoRepository::save);

        return sb.toString().trim();
    }

    @Override
    public String exportVolcanoes() throws IOException {
        StringBuilder sb = new StringBuilder();

        Set<Volcano> volcanoes = volcanoRepository
                .findByIsActiveTrueAndElevationIsGreaterThanAndLastEruptionIsNotNullOrderByElevationDesc(MIN_ELEVATION);
        volcanoes.forEach(volcano -> {
            sb.append(String.format("Volcano: %s\n" +
                    "   *Located in: %s\n" +
                    "   **Elevation: %d\n" +
                    "   ***Last eruption on: %s\n",
                    volcano.getName(),
                    volcano.getCountry().getName(),
                    volcano.getElevation(),
                    volcano.getLastEruption()));
        });

        return sb.toString().trim();
    }

    @Override
    public Volcano findVolcanoById(Long volcanoId) {
        return volcanoRepository.findById(volcanoId).orElse(null);
    }

}