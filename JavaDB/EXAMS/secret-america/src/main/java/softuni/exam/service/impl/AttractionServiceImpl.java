package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.repository.AttractionRepository;
import softuni.exam.service.AttractionService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service

public class AttractionServiceImpl implements AttractionService {

    private static final String ATTRACTIONS_PATH = "src/main/resources/files/json/attractions.json";
    private final AttractionRepository attractionRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public AttractionServiceImpl(AttractionRepository attractionRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.attractionRepository = attractionRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
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
    public String importAttractions() {
        StringBuilder sb = new StringBuilder();

        gson.fromJson()

        return sb.toString().trim();
    }

    @Override
    public String exportAttractions() {
        return null;
    }
}
