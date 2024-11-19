package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ConstellationImportDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class ConstellationServiceImpl implements ConstellationService {

    public static final String CONSTELLATIONS_PATH = "src/main/resources/files/json/constellations.json";
    private final ConstellationRepository constellationRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public ConstellationServiceImpl(ConstellationRepository constellationRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.constellationRepository = constellationRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return constellationRepository.count() > 0;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        return Files.readString(Path.of(CONSTELLATIONS_PATH));
    }

    @Override
    public String importConstellations() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readConstellationsFromFile(), ConstellationImportDto[].class))
                .filter(constellationImportDto -> {
                    boolean isValid = validationUtil.isValid(constellationImportDto);

                    Constellation constellation = constellationRepository.findByName(constellationImportDto.getName());

                    if (constellation != null) {
                        isValid = false;
                    }

                    if (isValid) {
                        sb.append(String.format("Successfully imported constellation %s - %s",
                                constellationImportDto.getName(),
                                constellationImportDto.getDescription()));
                    } else {
                        sb.append("Invalid constellation");
                    }
                    sb.append(System.lineSeparator());

                    return isValid;
                }).map(constellationImportDto -> modelMapper.map(constellationImportDto, Constellation.class))
                .forEach(constellationRepository::save);

        return sb.toString().trim();
    }

    @Override
    public Constellation findConstellationById(Long constellation) {
        return constellationRepository.findById(constellation).orElse(null);
    }

    @Override
    public void save(Constellation constellation) {
        constellationRepository.save(constellation);
    }
}
