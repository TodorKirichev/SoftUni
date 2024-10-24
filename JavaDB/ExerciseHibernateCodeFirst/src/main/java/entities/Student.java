package entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity

public class Student extends User{

    private Float averageGrade;

    private Integer attendance;

    private Set<Course> courses;

    @ManyToMany(mappedBy = "students")
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Column(name = "average_grade")
    public Float getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(Float grade) {
        this.averageGrade = grade;
    }

    @Column
    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }

    public Student() {
        this.courses = new HashSet<>();
    }
}
