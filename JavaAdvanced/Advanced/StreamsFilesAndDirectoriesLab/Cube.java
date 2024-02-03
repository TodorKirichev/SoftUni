package JavaAdvanced.StreamsFilesAndDirectoriesLab;

import java.io.Serializable;

public class Cube implements Serializable {
    private String color;
    private int width;
    private  int height;
    private int depth;

    public Cube(String color, int width, int height, int depth) {
        this.color = color;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
}
