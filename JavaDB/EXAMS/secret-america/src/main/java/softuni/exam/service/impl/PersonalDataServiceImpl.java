package softuni.exam.service.impl;

import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PersonalDataRootImportDto;
import softuni.exam.models.entity.PersonalData;
import softuni.exam.repository.PersonalDataRepository;
import softuni.exam.service.PersonalDataService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

@Service
public class PersonalDataServiceImpl implements PersonalDataService {

    private static final String PERSONAL_DATA_PATH = "src/main/resources/files/xml/personal_data.xml";
    private final PersonalDataRepository personalDataRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    public PersonalDataServiceImpl(PersonalDataRepository personalDataRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.personalDataRepository = personalDataRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return personalDataRepository.count() > 0;
    }

    @Override
    public String readPersonalDataFileContent() throws IOException {
        return Files.readString(Path.of(PERSONAL_DATA_PATH));
    }

    @Override
    public String importPersonalData() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(PERSONAL_DATA_PATH, PersonalDataRootImportDto.class)
                .getPersonalDataImportDtos()
                .stream().filter(personalDataImportDto -> {
                    boolean isValid = validationUtil.isValid(personalDataImportDto);

                    PersonalData personalData = personalDataRepository.findByCardNumber(personalDataImportDto.getCardNumber());

                    if (personalData != null) {
                        isValid = false;
                    }

//                    LocalDate birthDate = LocalDate.parse(personalDataImportDto.getBirthDate());
//
//                    if (birthDate.isAfter(LocalDate.now())) {
//                        isValid = false;
//                    }

                    if (isValid) {
                        sb.append(String.format("Successfully imported personal data for visitor with card number %s",
                                personalDataImportDto.getCardNumber()));
                    } else {
                        sb.append("Invalid personal data");
                    }
                    sb.append(System.lineSeparator());

                    return isValid;
                }).map(personalDataImportDto -> modelMapper.map(personalDataImportDto, PersonalData.class))
                .forEach(personalDataRepository::save);
        System.out.println(personalDataRepository.count());

        return sb.toString().trim();
    }

    @Override
    public PersonalData findPersonalDataById(long id) {
        return personalDataRepository.findById(id);
    }
}
