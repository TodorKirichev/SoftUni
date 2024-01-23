package JavaAdvanced.DefiningClassesExercises._2_CompanyRoster;

import java.util.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int n = Integer.parseInt(scan.nextLine());
        List<Employee> employees = new ArrayList<>();
        Map<String,Department> departmentSalaries = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = scan.nextLine().split("\\s+");
            String name = line[0];
            double salary = Double.parseDouble(line[1]);
            String position = line[2];
            String department = line[3];

            Employee employee = null;
            switch (line.length) {
                case 4 :
                    employee = new Employee(name,salary,position,department);
                    break;
                case 5 :
                    if (line[4].contains("@")) {
                        String email = line[4];
                        employee = new Employee(name,salary,position,department,email);
                    } else {
                        int age = Integer.parseInt(line[4]);
                        employee = new Employee(name,salary,position,department,age);
                    }
                    break;
                case 6 :
                    String email = line[4];
                    int age = Integer.parseInt(line[5]);
                    employee = new Employee(name,salary,position,department,email,age);
                    break;
            }
            employees.add(employee);
            if (departmentSalaries.containsKey(employee.getDepartment())) {
                departmentSalaries.get(employee.getDepartment()).addSalary(salary);
            } else {
                departmentSalaries.put(employee.getDepartment(),new Department(employee.getDepartment(),new ArrayList<>()));
                departmentSalaries.get(employee.getDepartment()).addSalary(salary);
            }
        }
        String highestSalaryDep = null;
        double highestAverageSalary = Double.MIN_VALUE;
        for (Department value : departmentSalaries.values()) {
            if (value.getAverageSalary() > highestAverageSalary) {
                highestAverageSalary = value.getAverageSalary();
                highestSalaryDep = value.getName();
            }
        }
        System.out.printf("Highest Average Salary: %s\n",highestSalaryDep);
        String finalHighestSalaryDep = highestSalaryDep;

        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .filter(e -> e.getDepartment().equals(finalHighestSalaryDep))
                .forEach(System.out::println);
    }
}
