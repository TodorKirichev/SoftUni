package JavaAdvanced.DefiningClassesExercises._2_CompanyRoster;

import java.util.List;

public class Department {
    String name;
    List<Double> depSalaries;

    public Department(String name, List<Double> depSalaries) {
        this.name = name;
        this.depSalaries = depSalaries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getDepSalaries() {
        return depSalaries;
    }

    public void setDepSalaries(List<Double> depSalaries) {
        this.depSalaries = depSalaries;
    }
    public void addSalary(double salary) {
        depSalaries.add(salary);
    }
    public double getAverageSalary () {
        return depSalaries.stream().mapToDouble(d -> Double.parseDouble(String.valueOf(d))).average().orElse(0);
    }
}

