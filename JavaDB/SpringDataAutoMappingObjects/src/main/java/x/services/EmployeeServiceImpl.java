package x.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import x.dto.EmployeeDto;
import x.dto.ManagerDto;
import x.entities.Employee;
import x.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ManagerDto findOne(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();

        ModelMapper modelMapper = new ModelMapper();


//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setFirstName(employee.getFirstName());
//        employeeDto.setLastName(employee.getLastName());
//        employeeDto.setSalary(employee.getSalary());

        return modelMapper.map(employee,ManagerDto.class);
    }
}
