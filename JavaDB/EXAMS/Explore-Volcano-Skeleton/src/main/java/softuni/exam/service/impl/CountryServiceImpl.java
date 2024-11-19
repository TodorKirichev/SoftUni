package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.messages.Message;
import softuni.exam.models.dto.CountryImportDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.messages.Message.INVALID_COUNTRY;
import static softuni.exam.messages.Message.SUCCESSFULLY_IMPORTED_COUNTRY;

@Service
public class CountryServiceImpl implements CountryService {

    public static final String COUNTRIES_FILE_PATH = "src/main/resources/files/json/countries.json";
    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public CountryServiceImpl(CountryRepository countryRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(Path.of(COUNTRIES_FILE_PATH));
    }

    @Override
    public String importCountries() throws IOException {
        StringBuilder sb = new StringBuilder();

        CountryImportDto[] countryImportDtos = gson.fromJson(readCountriesFromFile(), CountryImportDto[].class);

        Arrays.stream(countryImportDtos).filter(countryImportDto -> {
            boolean isValid = validationUtil.isValid(countryImportDto);

            Country country = countryRepository.findByName(countryImportDto.getName());

            if (country != null) {
                isValid = false;
            }

            if (isValid) {
                sb.append(String.format(SUCCESSFULLY_IMPORTED_COUNTRY,
                        countryImportDto.getName(),
                        countryImportDto.getCapital()));
            } else {
                sb.append(INVALID_COUNTRY);
            }
            sb.append(System.lineSeparator());

            return isValid;
        }).map(countryImportDto -> modelMapper.map(countryImportDto, Country.class))
                .forEach(countryRepository::save);

        return sb.toString().trim();
    }

    @Override
    public Country findCountryById(Long country) {
        return countryRepository.findById(country).orElse(null);
    }

    @Override
    public void saveCountry(Country country) {
        countryRepository.save(country);
    }
}
