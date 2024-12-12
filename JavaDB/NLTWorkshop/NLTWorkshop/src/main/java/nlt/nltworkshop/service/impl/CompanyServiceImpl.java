package nlt.nltworkshop.service.impl;

import nlt.nltworkshop.data.entity.Company;
import nlt.nltworkshop.data.repository.CompanyRepository;
import nlt.nltworkshop.service.CompanyService;
import nlt.nltworkshop.service.models.imports.CompanyRootImportModel;
import nlt.nltworkshop.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CompanyServiceImpl implements CompanyService {

    private static final String FILE_PATH = "src/main/resources/files/xmls/companies.xml";
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, ModelMapper modelMapper, XmlParser xmlParser) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean isImported() {
        return companyRepository.count() > 0;
    }

    @Override
    public void seedData() throws JAXBException, FileNotFoundException {
        xmlParser.fromFile(FILE_PATH, CompanyRootImportModel.class)
                .getCompanies()
                .forEach(companyImportModel -> {
                    companyRepository.saveAndFlush(modelMapper.map(companyImportModel, Company.class));
                });
    }

    @Override
    public String readFile() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }
}
