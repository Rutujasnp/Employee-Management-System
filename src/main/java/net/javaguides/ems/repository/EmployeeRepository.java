package net.javaguides.ems.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.ems.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
