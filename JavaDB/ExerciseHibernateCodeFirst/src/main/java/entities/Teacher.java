package entities;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity

public class Teacher extends User {

    private String email;

    private Float salaryPerHour;

    private Set<Course> courses;

    @OneToMany(mappedBy = "teacher")
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Column
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "salary_per_hour")
    public Float getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(Float salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public Teacher() {
        this.courses = new HashSet<>();
    }
}
