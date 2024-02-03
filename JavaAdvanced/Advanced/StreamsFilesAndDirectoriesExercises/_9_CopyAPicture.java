package JavaAdvanced.StreamsFilesAndDirectoriesExercises;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _9_CopyAPicture {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/picture.jpg");
        FileOutputStream fos = new FileOutputStream("src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/picture-copy.jpg");

        byte[] buffer = new byte[100];

        while (fis.read(buffer) >= 0) {
            fos.write(buffer);
        }
        fis.close();
        fos.close();
    }
}
