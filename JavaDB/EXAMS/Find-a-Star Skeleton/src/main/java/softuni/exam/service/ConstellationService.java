package softuni.exam.service;

import softuni.exam.models.entity.Constellation;

import java.io.IOException;

public interface ConstellationService {

    boolean areImported();

    String readConstellationsFromFile() throws IOException;

	String importConstellations() throws IOException;

    Constellation findConstellationById(Long constellation);

    void save(Constellation constellation);
}
