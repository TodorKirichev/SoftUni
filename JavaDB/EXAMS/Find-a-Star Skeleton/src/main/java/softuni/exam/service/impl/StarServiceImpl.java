package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.StarImportDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class StarServiceImpl implements StarService {

    public static final String STARS_PATH = "src/main/resources/files/json/stars.json";
    private final StarRepository starRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final ConstellationService constellationService;

    public StarServiceImpl(StarRepository starRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson, ConstellationService constellationService) {
        this.starRepository = starRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.constellationService = constellationService;
    }

    @Override
    public boolean areImported() {
        return starRepository.count() > 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        return Files.readString(Path.of(STARS_PATH));
    }

    @Override
    public String importStars() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readStarsFileContent(), StarImportDto[].class))
                .filter(starImportDto -> {
                    boolean isValid = validationUtil.isValid(starImportDto);

                    Star star = starRepository.findByName(starImportDto.getName());

                    if (star != null) {
                        isValid = false;
                    }

                    if (isValid) {
                        sb.append(String.format("Successfully imported star %s - %.2f light years",
                                starImportDto.getName(),
                                starImportDto.getLightYears()));
                    } else {
                        sb.append("Invalid star");
                    }
                    sb.append(System.lineSeparator());

                    return isValid;
                }).map(starImportDto -> {
                    Star star = modelMapper.map(starImportDto, Star.class);

                    Constellation constellation = constellationService.findConstellationById(starImportDto.getConstellation());

                    constellation.getStars().add(star);

                    constellationService.save(constellation);

                    star.setConstellation(constellation);

                    return star;
                }).forEach(starRepository::save);

        return sb.toString().trim();
    }

    @Override
    public String exportStars() {
        return "";
    }

    @Override
    public Star findStarById(Long observingStarId) {
        return starRepository.findById(observingStarId).orElse(null);
    }

    @Override
    public void save(Star star) {
        starRepository.save(star);
    }
}
