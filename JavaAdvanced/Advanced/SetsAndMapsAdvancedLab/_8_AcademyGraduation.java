package JavaAdvanced.SetsAndMapsAdvancedLab;

import java.text.DecimalFormat;
import java.util.*;

public class _8_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, double[]> studentGrades = new TreeMap<>();
        
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String student = scan.nextLine();
            double[] grades = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            studentGrades.put(student,grades);
        }
        print(studentGrades);
    }

    private static void print(Map<String, double[]> studentGrades) {
        studentGrades.forEach((key, value) -> {
            double sumGrades = 0;
            for (double v : value) {
                sumGrades += v;
            }
            double average = sumGrades / value.length;
            DecimalFormat format = new DecimalFormat("#.############");
            format.format(average);

            System.out.printf("%s is graduated with %s\n",key,average);
        });
    }
}
