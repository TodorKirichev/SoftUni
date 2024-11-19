package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.messages.Message;
import softuni.exam.models.dto.ForecastRootImportDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.DayOfWeek;
import softuni.exam.models.entity.Forecast;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.CityService;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;

import static softuni.exam.messages.Message.INVALID_FORECAST;
import static softuni.exam.messages.Message.SUCCESSFULLY_IMPORTED_FORECAST;

@Service
public class ForecastServiceImpl implements ForecastService {

    public static final String FORECASTS_PATH = "src/main/resources/files/xml/forecasts.xml";
    private final ForecastRepository forecastRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final CityService cityService;

    @Autowired
    public ForecastServiceImpl(ForecastRepository forecastRepository, ValidationUtil validationUtil, ModelMapper modelMapper, XmlParser xmlParser, CityService cityService) {
        this.forecastRepository = forecastRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.cityService = cityService;
    }

    @Override
    public boolean areImported() {
        return forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(Path.of(FORECASTS_PATH));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(FORECASTS_PATH, ForecastRootImportDto.class).getForecastImportDtos()
                .stream()
                .filter(forecastImportDto -> {
                    boolean isValid = validationUtil.isValid(forecastImportDto);

                    City city = cityService.findCityById(forecastImportDto.getCity());
                    if (city == null) {
                        isValid = false;
                    }

                    Forecast forecast = forecastRepository.findAllByCityAndDayOfWeek(city, forecastImportDto.getDayOfWeek());
                    if (forecast != null) {
                        isValid = false;
                    }


                    if (isValid) {
                        sb.append(String.format(SUCCESSFULLY_IMPORTED_FORECAST, forecastImportDto.getDayOfWeek(), forecastImportDto.getMaxTemperature()));
                    } else {
                        sb.append(INVALID_FORECAST);
                    }
                    sb.append(System.lineSeparator());

                    return isValid;
                }).map(forecastImportDto -> {
                    Forecast forecast = modelMapper.map(forecastImportDto, Forecast.class);

                    City city = cityService.findCityById(forecastImportDto.getCity());

                    forecast.setCity(city);

                    return forecast;
                }).forEach(forecastRepository::save);

        return sb.toString();
    }

    @Override
    public String exportForecasts() {
        StringBuilder sb = new StringBuilder();
        Set<Forecast> forecasts = forecastRepository.findAllBySundayAndCityPopulationUnder150000();

        forecasts.forEach(forecast -> {
            sb.append(String.format("City: %s:\n" +
                    "-min temperature: %s\n" +
                    "--max temperature: %s\n" +
                    "---sunrise: %s\n" +
                    "----sunset: %s\n",
                    forecast.getCity().getCityName(),
                    forecast.getMinTemperature(),
                    forecast.getMaxTemperature(),
                    forecast.getSunrise(),
                    forecast.getSunset()));
        });

        return sb.toString();
    }
}
