package JavaAdvanced.StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class _10_SerializeArrayList {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/list.ser"));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/list.ser"));

        List<Double> doubles = new ArrayList<>();
        doubles.add(5.5);
        doubles.add(5.6);

        oos.writeObject(doubles);
        oos.close();
        List<Double> read = (List<Double>) ois.readObject();
        System.out.println(read);
    }
}
