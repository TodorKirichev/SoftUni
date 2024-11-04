package x.dto;

import java.util.List;

public class ManagerDto extends BaseEmployeeDto {

    private List<EmployeeDto> employees;

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }
}
