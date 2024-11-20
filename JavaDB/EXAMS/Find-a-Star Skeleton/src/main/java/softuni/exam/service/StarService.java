package softuni.exam.service;

import softuni.exam.models.entity.Star;
import softuni.exam.models.entity.StarType;

import java.io.IOException;
import java.util.List;

public interface StarService {

    boolean areImported();

    String readStarsFileContent() throws IOException;

    String importStars() throws IOException;

    String exportStars();

    Star findStarById(Long observingStarId);

    void save(Star star);

}
