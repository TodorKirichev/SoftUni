package x.dto;

import java.math.BigDecimal;

public class EmployeeDto extends BaseEmployeeDto{

    private BigDecimal salary;

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
