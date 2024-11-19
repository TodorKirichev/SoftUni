package exercisespringdataautomappingobjects.xmlexercise.util;

import jakarta.xml.bind.JAXBException;

import java.io.FileNotFoundException;

public interface XmlParser {

    <T> T fromFile(String filePath, Class<T> clazz) throws JAXBException, FileNotFoundException;

    <T> void toFile(String filePath, T entity) throws JAXBException, FileNotFoundException;
}
