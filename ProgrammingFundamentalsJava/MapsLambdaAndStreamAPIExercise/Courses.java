package MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> courses = new LinkedHashMap<>();

        String input = scan.nextLine();

        while (!input.equals("end")) {

            String courseName = input.split(" : ")[0];
            String studentName = input.split(" : ")[1];

            if (!courses.containsKey(courseName)) {
                courses.put(courseName,new ArrayList<>());
                courses.get(courseName).add(studentName);
            } else {
                courses.get(courseName).add(studentName);
            }
            input = scan.nextLine();
        }
//        for (Map.Entry<String,List<String>> entry : courses.entrySet()) {
//            System.out.printf("%s: %d\n",entry.getKey(),entry.getValue().size());
//            for (String e : entry.getValue()) {
//                System.out.printf("-- %s\n",e);
//            }
//        }

//        courses.entrySet().forEach(course -> {
//            System.out.printf("%s: %d\n",course.getKey(),course.getValue().size());
//            course.getValue().forEach(studentName -> System.out.printf("-- %s\n",studentName));
//        });
        courses.forEach((key, value) -> {
            System.out.printf("%s: %d\n", key, value.size());
            value.forEach(studentName -> System.out.printf("-- %s\n", studentName));
        });
    }
}
