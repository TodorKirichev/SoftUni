package Advanced.EXAMS.JavaAdvancedRetakeExam14December2022.SoftUniStudents;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }
    public int getCount() {
        return data.size();
    }
    public String insert(Student student) {
        String message;
        if (data.size() == capacity) {
            message = "The hall is full.";
        } else {
            if (data.contains(student)) {
                message = "Student is already in the hall.";
            } else {
                data.add(student);
                message = String.format("Added student %s %s.",student.getFirstName(),student.getLastName());
            }
        }
        return message;
    }
    public String remove(Student student) {
        String message;
        if (data.contains(student)) {
            int index = data.indexOf(student);
            Student student1 = data.remove(index);
            message = String.format("Removed student %s %s.",student1.getFirstName(),student1.getLastName());
        } else {
            message = "Student not found.";
        }
        return message;
    }
    public Student getStudent(String firstName,String lastName) {
        return data.stream().filter(s -> s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)).findFirst().get();
    }
    public String getStatistics() {
        StringBuilder sb = new StringBuilder(String.format("Hall size: %d\n",data.size()));
        data.forEach(s -> sb.append(String.format("Student: %s %s, Best Course = %s\n",s.getFirstName(),s.getLastName(),s.getBestCourse())));
        return sb.toString().trim();
    }
}
