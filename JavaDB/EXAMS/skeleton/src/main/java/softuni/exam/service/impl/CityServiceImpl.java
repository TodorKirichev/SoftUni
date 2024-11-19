package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CityImportDto;
import softuni.exam.models.entity.City;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

import static softuni.exam.messages.Message.INVALID_CITY;
import static softuni.exam.messages.Message.SUCCESSFULLY_IMPORTED_CITY;

@Service
public class CityServiceImpl implements CityService {

    public static final String CITIES_PATH = "src/main/resources/files/json/cities.json";
    private final CityRepository cityRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    public final CountryRepository countryRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.countryRepository = countryRepository;
    }

    @Override
    public boolean areImported() {
        return cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(Path.of(CITIES_PATH));
    }

    @Override
    public String importCities() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readCitiesFileContent(), CityImportDto[].class))
                .filter(cityImportDto -> {
                    boolean isValid = validationUtil.isValid(cityImportDto);

                    Optional<City> cityByName = cityRepository.findByCityName(cityImportDto.getCityName());

                    if (cityByName.isPresent()) {
                        isValid = false;
                    }

                    if (isValid) {
                        sb.append(String.format(SUCCESSFULLY_IMPORTED_CITY, cityImportDto.getCityName(), cityImportDto.getPopulation()));

                    } else {
                        sb.append(INVALID_CITY);
                    }
                    sb.append(System.lineSeparator());

                    return isValid;
                }).map(cityImportDto -> {
                    City city = modelMapper.map(cityImportDto, City.class);
                    city.setCountry(countryRepository.findCountryById(cityImportDto.getCountry()));
                    return city;
                })
                .forEach(cityRepository::save);

        return sb.toString();
    }

    @Override
    public City findCityById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

}
