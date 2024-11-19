package exercisespringdataautomappingobjects.xmlexercise.util.impl;

import exercisespringdataautomappingobjects.xmlexercise.util.XmlParser;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Component
public class XmlParserImpl implements XmlParser {

    private JAXBContext jaxbContext;

    @SuppressWarnings("unchecked")
    @Override
    public <T> T fromFile(String filePath, Class<T> clazz) throws JAXBException, FileNotFoundException {
        jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (T) unmarshaller.unmarshal(new FileReader(filePath));
    }

    @Override
    public <T> void toFile(String filePath, T entity) throws JAXBException {
        jaxbContext = JAXBContext.newInstance(entity.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(entity, new File(filePath));
    }
}
