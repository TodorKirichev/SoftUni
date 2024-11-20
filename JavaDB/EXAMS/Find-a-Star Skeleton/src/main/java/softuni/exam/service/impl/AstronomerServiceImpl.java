package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AstronomerRootImportDto;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class AstronomerServiceImpl implements AstronomerService {

    public static final String ASTRONOMERS_PATH = "src/main/resources/files/xml/astronomers.xml";
    private final AstronomerRepository astronomerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final StarService starService;

    public AstronomerServiceImpl(AstronomerRepository astronomerRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, StarService starService) {
        this.astronomerRepository = astronomerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.starService = starService;
    }

    @Override
    public boolean areImported() {
        return astronomerRepository.count() > 0;
    }

    @Override
    public String readAstronomersFromFile() throws IOException {
        return Files.readString(Path.of(ASTRONOMERS_PATH));
    }

    @Override
    public String importAstronomers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        AstronomerRootImportDto astronomerRootImportDto = xmlParser.fromFile(ASTRONOMERS_PATH, AstronomerRootImportDto.class);
        astronomerRootImportDto.getAstronomers().stream()
                .filter(astronomerImportDto -> {
                    boolean isValid = validationUtil.isValid(astronomerImportDto);

                    Astronomer astronomer = astronomerRepository
                            .findByFirstNameAndLastName(astronomerImportDto.getFirstName(), astronomerImportDto.getLastName());

                    Star star = starService.findStarById(astronomerImportDto.getObservingStar());

                    if (star == null) {
                        isValid = false;
                    }

                    if (astronomer != null) {
                        isValid = false;

                    }

                    if (isValid) {
                        sb.append(String.format("Successfully imported astronomer %s %s - %.2f",
                                astronomerImportDto.getFirstName(),
                                astronomerImportDto.getLastName(),
                                astronomerImportDto.getAverageObservationHours()));
                    } else {
                        sb.append("Invalid astronomer");
                    }
                    sb.append(System.lineSeparator());

                    return isValid;
                }).map(astronomerImportDto -> {
                    Astronomer astronomer = modelMapper.map(astronomerImportDto, Astronomer.class);

                    Star star = starService.findStarById(astronomerImportDto.getObservingStar());


                    star.getObservers().add(astronomer);
                    starService.save(star);

                    astronomer.setObservingStar(star);

                    return astronomer;
                }).forEach(astronomerRepository::save);

        return sb.toString().trim();
    }
}
