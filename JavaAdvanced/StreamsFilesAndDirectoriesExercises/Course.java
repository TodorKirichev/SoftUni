package JavaAdvanced.StreamsFilesAndDirectoriesExercises;

import java.io.Serializable;

public class Course implements Serializable {
    String name;
    int numOfStudents;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfStudents() {
        return numOfStudents;
    }

    public void setNumOfStudents(int numOfStudents) {
        this.numOfStudents = numOfStudents;
    }
}
