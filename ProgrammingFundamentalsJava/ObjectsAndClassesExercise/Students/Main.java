package ObjectsAndClassesExercise.Students;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Students> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            double grade = Double.parseDouble(input[2]);

            Students student = new Students(firstName,lastName,grade);
            students.add(student);
        }
        Collections.sort(students, Comparator.comparingDouble(Students::getGrade).reversed());

        for (Students student : students) {
            System.out.printf("%s %s: %.2f%n",student.getFirstName(),student.getLastName(),student.getGrade());
        }
    }
}
