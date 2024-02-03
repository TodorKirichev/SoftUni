package JavaAdvanced.StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class _11_SerializeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Course course = new Course();
        course.name = "Programming";
        course.numOfStudents = 25;

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/course.ser"));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/course.ser"));

        oos.writeObject(course);

        Course sameCourse = (Course) ois.readObject();
        oos.close();
        ois.close();

        System.out.println(sameCourse.getName());
        System.out.println(sameCourse.getNumOfStudents());

    }
}
