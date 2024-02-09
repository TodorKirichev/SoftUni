package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }
    public int getStudentCount() {
        return students.size();
    }
    public String registerStudent(Student student) {
        if (students.size() < capacity) {
            if (students.contains(student)) {
                return "Student is already in the university";
            } else {
                students.add(student);
                return String.format("Added student %s %s",student.getFirstName(),student.getLastName());
            }
        } else {
            return "No seats in the university";
        }
    }
    public String dismissStudent(Student student) {
        if (!students.contains(student)) {
            return "Student not found";
        } else {
            String msg = String.format("Removed student %s %s",student.getFirstName(),student.getLastName());
            students.remove(student);
            return msg;
        }
    }
    public Student getStudent(String firstName,String lastName) {
        return students.stream()
                .filter(s -> s.getFirstName().equals(firstName) && s.getLastName().equals(lastName))
                .findFirst().orElse(null);
    }
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        students.forEach(s -> sb.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s",
                s.getFirstName(),s.getLastName(),s.getBestSubject())).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
