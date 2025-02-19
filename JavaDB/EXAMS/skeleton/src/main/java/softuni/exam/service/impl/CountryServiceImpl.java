package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountryImportDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

import static softuni.exam.messages.Message.INVALID_COUNTRY;
import static softuni.exam.messages.Message.SUCCESSFULLY_IMPORTED_COUNTRY;

@Service
public class CountryServiceImpl implements CountryService {

    public static final String COUNTRIES_PATH = "src/main/resources/files/json/countries.json";
    private final CountryRepository countryRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(Path.of(COUNTRIES_PATH));
    }

    @Override
    public String importCountries() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readCountriesFromFile(), CountryImportDto[].class))
                .filter(countryImportDto -> {
                    boolean isValid = validationUtil.isValid(countryImportDto);

                    Optional<Country> countryByName = countryRepository.findCountryByCountryName(countryImportDto.getCountryName());

                    if (countryByName.isPresent()) {
                        isValid = false;
                    }

                    if (isValid) {
                        sb.append(String.format(SUCCESSFULLY_IMPORTED_COUNTRY,countryImportDto.getCountryName(),countryImportDto.getCurrency()))
                                .append(System.lineSeparator());
                    } else {
                        sb.append(INVALID_COUNTRY)
                                .append(System.lineSeparator());
                    }
                    return isValid;
                }).map(countryImportDto -> modelMapper.map(countryImportDto, Country.class))
                .forEach(countryRepository::save);

        return sb.toString();
    }
}
