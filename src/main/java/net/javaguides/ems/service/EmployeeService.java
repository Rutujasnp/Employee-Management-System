package net.javaguides.ems.service;

import java.util.List;

import net.javaguides.ems.Model.Employee;

public interface EmployeeService {

	public List<Employee> GetEmployeeList();
	public Employee saveEmployee(Employee employee);
	public Employee getEmployeeById(int id);
	public Employee editEmployee(Employee employee);
	public void deleteEmployeeById(int id);

}
