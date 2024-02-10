package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRetakeExam18August2021.Cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addEmployee(Employee employee) {
        if (employees.size() < getCapacity()) {
            employees.add(employee);
        }
    }
    public boolean removeEmployee(String name) {
        return employees.removeIf(e -> e.getName().equals(name));
    }
    public Employee getOldestEmployee() {
        return employees.stream().max(Comparator.comparing(Employee::getAge)).orElse(null);
    }
    public Employee getEmployee(String name) {
        return employees.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }
    public int getCount() {
        return employees.size();
    }
    public String report() {
        StringBuilder sb = new StringBuilder();
        employees.forEach(e -> sb.append(e).append("\n"));
        return String.format("Employees working at Cafe %s:\n%s",getName(),sb.toString().trim());
    }
}
