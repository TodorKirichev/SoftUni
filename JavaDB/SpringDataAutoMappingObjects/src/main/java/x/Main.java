package x;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import x.dto.EmployeeDto;
import x.dto.ManagerDto;
import x.services.EmployeeService;

@Component
public class Main implements CommandLineRunner {

    private final EmployeeService employeeService;

    public Main(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {

        ManagerDto dto = this.employeeService.findOne(1);
        System.out.println(dto.getFirstName() + " " + dto.getLastName());
        dto.getEmployees().forEach(d -> {
            System.out.println(d.getFirstName() + " " + d.getLastName() + " " + d.getSalary());
        });



    }
}
