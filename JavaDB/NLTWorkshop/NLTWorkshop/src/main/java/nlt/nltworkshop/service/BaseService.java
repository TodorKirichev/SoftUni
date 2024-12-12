package nlt.nltworkshop.service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface BaseService {

    boolean isImported();

    void seedData() throws JAXBException, FileNotFoundException;

    String readFile() throws IOException;
}
