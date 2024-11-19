package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.imports.CarSeedDto;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    public static final String CARS_PATH = "src/main/resources/files/json/cars.json";
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files.readString(Path.of(CARS_PATH));
    }

    @Override
    public String importCars() throws IOException {
        StringBuilder sb = new StringBuilder();
        CarSeedDto[] carSeedDtos = gson.fromJson(readCarsFileContent(), CarSeedDto[].class);

        Arrays.stream(carSeedDtos).filter(carSeedDto -> {
            boolean isValid = validationUtil.isValid(carSeedDto);

            if (isValid) {
                sb.append(String.format("Successfully imported car - %s - %s", carSeedDto.getMake(), carSeedDto.getModel()))
                        .append(System.lineSeparator());
            } else {
                sb.append("Invalid car").append(System.lineSeparator());
            }

            return isValid;
        }).map(carSeedDto -> modelMapper.map(carSeedDto, Car.class))
                .forEach(carRepository::save);

        return sb.toString();
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        StringBuilder sb = new StringBuilder();
        List<Car> carsOrderByPictures = carRepository.findAllCarsOrderByPictures();

        carsOrderByPictures.forEach(car -> {
            sb.append(String.format("Car make - %s, model - %s\n" +
                            "\tKilometers - %d\n" +
                            "\tRegistered on - %s\n" +
                            "\tNumber of pictures - %d",
                    car.getMake(), car.getModel(), car.getKilometers(), car.getRegisteredOn(),car.getPictures().size()))
                    .append(System.lineSeparator());
        });

        return sb.toString();
    }

    @Override
    public Car findId(Long car) {
        return carRepository.findById(car).get();
    }
}
