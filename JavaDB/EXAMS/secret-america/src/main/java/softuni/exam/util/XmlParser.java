package softuni.exam.util;

import jakarta.xml.bind.JAXBException;

import java.io.FileNotFoundException;

public interface XmlParser {

    <T> T fromFile(String fileName, Class<T> clazz) throws JAXBException, FileNotFoundException;
}