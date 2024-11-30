package softuni.exam.service.impl;

import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.VisitorRootImportDto;
import softuni.exam.models.entity.Attraction;
import softuni.exam.models.entity.Country;
import softuni.exam.models.entity.PersonalData;
import softuni.exam.models.entity.Visitor;
import softuni.exam.repository.VisitorRepository;
import softuni.exam.service.AttractionService;
import softuni.exam.service.CountryService;
import softuni.exam.service.PersonalDataService;
import softuni.exam.service.VisitorService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class VisitorServiceImpl implements VisitorService {

    private static final String VISITORS_PATH = "src/main/resources/files/xml/visitors.xml";
    private final VisitorRepository visitorRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final PersonalDataService personalDataService;
    private final AttractionService attractionService;
    private final CountryService countryService;

    public VisitorServiceImpl(VisitorRepository visitorRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, PersonalDataService personalDataService, AttractionService attractionService, CountryService countryService) {
        this.visitorRepository = visitorRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.personalDataService = personalDataService;
        this.attractionService = attractionService;
        this.countryService = countryService;
    }

    @Override
    public boolean areImported() {
        return visitorRepository.count() > 0;
    }

    @Override
    public String readVisitorsFileContent() throws IOException {
        return Files.readString(Path.of(VISITORS_PATH));
    }

    @Override
    public String importVisitors() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(VISITORS_PATH, VisitorRootImportDto.class)
                .getVisitorImportDtos()
                .stream().filter(visitorImportDto -> {
                    boolean isValid = validationUtil.isValid(visitorImportDto);

                    Visitor visitor = visitorRepository
                            .findByFirstNameAndLastName(visitorImportDto.getFirstName(), visitorImportDto.getLastName());

                    if (visitor != null) {
                        isValid = false;
                    }

                    visitor = visitorRepository.findByPersonalData_Id(visitorImportDto.getPersonalDataId());

                    if (visitor != null) {
                        isValid = false;
                    }

                    if (isValid) {
                        sb.append(String.format("Successfully imported visitor %s %s",
                                visitorImportDto.getFirstName(),
                                visitorImportDto.getLastName()));
                    } else {
                        sb.append("Invalid visitor");
                    }
                    sb.append(System.lineSeparator());

                    return isValid;
                }).map(visitorImportDto -> {
                    Visitor visitor = modelMapper.map(visitorImportDto, Visitor.class);

                    Attraction attraction = attractionService.findAttractionById(visitorImportDto.getAttractionId());
                    Country country = countryService.findCountryById(visitorImportDto.getCountryId());
                    PersonalData personalData = personalDataService.findPersonalDataById(visitorImportDto.getPersonalDataId());

                    visitor.setAttraction(attraction);
                    visitor.setCountry(country);
                    visitor.setPersonalData(personalData);

                    return visitor;
                }).forEach(visitorRepository::save);

        return sb.toString().trim();
    }
}
