package nlt.nltworkshop.service.impl;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import nlt.nltworkshop.data.repository.CompanyRepository;
import nlt.nltworkshop.data.repository.ProjectRepository;
import nlt.nltworkshop.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ProjectServiceImpl implements ProjectService {

    private static final String FILE_PATH = "src/main/resources/files/xmls/projects.xml";
    private final ProjectRepository projectRepository;
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean isImported() {
        return projectRepository.count() > 0;
    }

    @Override
    public void seedData() throws JAXBException, FileNotFoundException {
        XmlMapper xmlMapper = new XmlMapper();
    }

    @Override
    public String readFile() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }
}
