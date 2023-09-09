package net.javaguides.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.ems.Model.Employee;
import net.javaguides.ems.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> GetEmployeeList() {
		
		return employeeRepository.findAll();
	}
	
	
	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}
	
	
	
	@SuppressWarnings("deprecation")
	@Override
	public Employee getEmployeeById(int id) {
		
		return employeeRepository.getById(id);
	}
	
	
	@Override
	public Employee editEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}


	@Override
	public void deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);;
	}

}
