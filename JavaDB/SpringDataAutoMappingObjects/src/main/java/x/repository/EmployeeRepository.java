package x.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import x.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
