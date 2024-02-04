package JavaAdvanced.OOP.WorkingWithAbstractionLab._3_StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public void parseCommand(String[] input) {
        String command = input[0];
        String name = input[1];
        if (command.equals("Create")) {
            int age = Integer.parseInt(input[2]);
            double grade = Double.parseDouble(input[3]);
            repo.putIfAbsent(name,new Student(name,age,grade));

        } else if (command.equals("Show")) {
            if (repo.containsKey(name)) {
                Student student = repo.get(name);
                StringBuilder sb = new StringBuilder(String.format("%s is %s years old.", student.getName(), student.getAge()));
                if (student.getGrade() >= 5.00) {
                    sb.append(" Excellent student.");
                } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                    sb.append(" Average student.");
                } else {
                    sb.append(" Very nice person.");
                }
                System.out.println(sb.toString());
            }
        }
    }
}
