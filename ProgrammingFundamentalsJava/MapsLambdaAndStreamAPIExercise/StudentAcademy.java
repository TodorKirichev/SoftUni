package MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Double>> studentsGrade = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            String name = scan.nextLine();
            double grade = Double.parseDouble(scan.nextLine());

            if (!studentsGrade.containsKey(name)) {
                studentsGrade.put(name,new ArrayList<>());
                studentsGrade.get(name).add(grade);
            } else {
                studentsGrade.get(name).add(grade);
            }
        }
        studentsGrade.forEach((key,value) -> {
            double average = value.stream().mapToDouble(a -> a).average().orElse(0.0);
            if (average >= 4.5) {
                System.out.printf("%s -> %.2f\n",key,average);
            }
        });
    }
}
