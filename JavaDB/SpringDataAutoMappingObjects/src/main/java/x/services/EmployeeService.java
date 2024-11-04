package x.services;

import x.dto.EmployeeDto;
import x.dto.ManagerDto;

public interface EmployeeService {

    ManagerDto findOne(long id);
}
