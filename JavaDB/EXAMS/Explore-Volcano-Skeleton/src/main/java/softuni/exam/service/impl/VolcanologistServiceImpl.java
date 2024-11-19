package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.messages.Message;
import softuni.exam.models.dto.VolcanologistRootImportDto;
import softuni.exam.models.entity.Volcano;
import softuni.exam.models.entity.Volcanologist;
import softuni.exam.repository.VolcanologistRepository;
import softuni.exam.service.VolcanoService;
import softuni.exam.service.VolcanologistService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.messages.Message.INVALID_VOLCANOLOGIST;
import static softuni.exam.messages.Message.SUCCESSFULLY_IMPORTED_VOLCANOLOGIST;

@Service
public class VolcanologistServiceImpl implements VolcanologistService {

    public static final String VOLCANOLOGISTS_FILE_PATH = "src/main/resources/files/xml/volcanologists.xml";
    private final VolcanologistRepository volcanologistRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final VolcanoService volcanoService;

    public VolcanologistServiceImpl(VolcanologistRepository volcanologistRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, VolcanoService volcanoService) {
        this.volcanologistRepository = volcanologistRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.volcanoService = volcanoService;
    }

    @Override
    public boolean areImported() {
        return volcanologistRepository.count() > 0;
    }

    @Override
    public String readVolcanologistsFromFile() throws IOException {
        return Files.readString(Path.of(VOLCANOLOGISTS_FILE_PATH));
    }

    @Override
    public String importVolcanologists() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        VolcanologistRootImportDto volcanologistRootImportDto = xmlParser.fromFile(VOLCANOLOGISTS_FILE_PATH, VolcanologistRootImportDto.class);

        volcanologistRootImportDto.getVolcanologists().stream()
                .filter(volcanologistImportDto -> {
                    boolean isValid = validationUtil.isValid(volcanologistImportDto);

                    Volcanologist volcanologist = volcanologistRepository
                            .findByFirstNameAndLastName(volcanologistImportDto.getFirstName(), volcanologistImportDto.getLastName());

                    if (volcanologist != null) {
                        isValid = false;
                    }

                    Volcano volcano = volcanoService.findVolcanoById(volcanologistImportDto.getExploringVolcanoId());

                    if (volcano == null) {
                        isValid = false;
                    }

                    if (isValid) {
                        sb.append(String.format(SUCCESSFULLY_IMPORTED_VOLCANOLOGIST,
                                volcanologistImportDto.getFirstName(),
                                volcanologistImportDto.getLastName()));
                    } else {
                        sb.append(INVALID_VOLCANOLOGIST);
                    }
                    sb.append(System.lineSeparator());

                    return isValid;
                }).map(volcanologistImportDto -> {
                    Volcanologist volcanologist = modelMapper.map(volcanologistImportDto, Volcanologist.class);

                    volcanologist.setVolcano(volcanoService.findVolcanoById(volcanologistImportDto.getExploringVolcanoId()));

                    return volcanologist;
                }).forEach(volcanologistRepository::save);

        return sb.toString().trim();
    }
}