package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.imports.PictureSeedDto;
import softuni.exam.models.entity.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class PictureServiceImpl implements PictureService {

    public static final String PICTURES_PATH = "src/main/resources/files/json/pictures.json";
    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final CarService carService;

    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, CarService carService) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.carService = carService;
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return Files.readString(Path.of(PICTURES_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb = new StringBuilder();
        PictureSeedDto[] pictureSeedDtos = gson.fromJson(readPicturesFromFile(), PictureSeedDto[].class);

        Arrays.stream(pictureSeedDtos).filter(pictureSeedDto -> {
            boolean isValid = validationUtil.isValid(pictureSeedDto);

            if (isValid) {
                sb.append(String.format("Successfully import picture - %s", pictureSeedDto.getName())).append(System.lineSeparator());
            } else {
                sb.append("Invalid picture").append(System.lineSeparator());
            }

            return isValid;
        }).map(pictureSeedDto -> {
            Picture picture = modelMapper.map(pictureSeedDto, Picture.class);
            picture.setCar(carService.findId(pictureSeedDto.getCar()));
            return picture;
        }).forEach(pictureRepository::save);

        return sb.toString();
    }
}
