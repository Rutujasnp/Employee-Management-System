package net.javaguides.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.ems.Model.Employee;
import net.javaguides.ems.service.EmployeeService;
import net.javaguides.ems.service.EmployeeServiceImpl;


/*
*
Developer name- Rutuja Pardeshi
*
*/
@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	@GetMapping("/employees")
	public String GetEmployeeList(Model model) {
		model.addAttribute("employees", employeeService.GetEmployeeList());
		 return "employees";
	}

	
	@GetMapping("/employees/new")
	public String createEmployeeForm(Model model) {
		Employee employee= new Employee();
		model.addAttribute("employee", employee);
		return "create_employee";
	}
	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee employee ) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
		
	}
	@GetMapping("/employees/edit/{id}")
	public String editEmployeeForm(@PathVariable int id, Model model) {
		Employee employee= new Employee();
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "edit_employee";
	}
	
	@PostMapping("/employees/{id}")
	public String editEmployee(@PathVariable int id, @ModelAttribute("employee") Employee employee, Model model) {
		Employee existingEmployee= employeeService.getEmployeeById(id);
		existingEmployee.setId(employee.getId());
		existingEmployee.setName(employee.getName());
		existingEmployee.setGmail(employee.getGmail());
		existingEmployee.setProfile(employee.getProfile());
		//existingEmployee.setCityCode(employee.getCityCode());
		employeeService.editEmployee(existingEmployee);
		return "redirect:/employees";
		
	}
	
	@GetMapping("/employees/delete/{id}")
	public String deleteEmployeeById(@PathVariable int id) {
		
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
		
	}
	
}
