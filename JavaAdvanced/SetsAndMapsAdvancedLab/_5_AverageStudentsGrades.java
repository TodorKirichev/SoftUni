package JavaAdvanced.SetsAndMapsAdvancedLab;

import java.util.*;

public class _5_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Double>> studentsGrade = new TreeMap<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String student = input[0];
            double grade = Double.parseDouble(input[1]);

            if (!studentsGrade.containsKey(student)) {
                studentsGrade.put(student,new ArrayList<>());
                studentsGrade.get(student).add(grade);
            } else {
                studentsGrade.get(student).add(grade);
            }
        }
        print(studentsGrade);
    }

    private static void print(Map<String, List<Double>> studentsGrade) {
        studentsGrade.forEach((key, value) -> {
            double sum = 0;
            for (Double grade : value) {
                sum += grade;
            }
            double average = sum / value.size();
            System.out.printf("%s -> ",key);
            for (Double grade : value) {
                System.out.printf("%.2f ",grade);
            }
            System.out.printf("(avg: %.2f)",average);
            System.out.println();
        });
    }
}
