package JavaAdvanced.StreamsFilesAndDirectoriesLab;

import java.io.*;

public class _9_SerializeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cube cube = new Cube("red",1,2,3);

        String path = "C:\\Users\\User\\IdeaProjects\\SoftUni\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\writeCube.ser";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));

        oos.writeObject(cube);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        Cube cube1 = (Cube) ois.readObject();
        ois.close();
    }
}
