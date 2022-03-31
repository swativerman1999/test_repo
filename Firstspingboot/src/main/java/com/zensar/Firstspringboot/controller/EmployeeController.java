package com.zensar.Firstspringboot.controller;
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
 
import com.zensar.Firstspringboot.model.Employee;
	
	@RestController
	public class EmployeeController {
	 
	    private List<Employee> employeesList = new ArrayList<Employee>();
	 
	    public EmployeeController() {
	        super();
	        Employee emp1 = new Employee(101, "ABC", 25000.00f);
	        Employee emp2 = new Employee(102, "XYZ", 15000.00f);
	        Employee emp3 = new Employee(103, "MNO", 32000.00f);
	        Employee emp4 = new Employee(104, "PQR", 45000.00f);
	        Employee emp5 = new Employee(105, "DEF", 65000.00f);
	        employeesList.add(emp1);
	        employeesList.add(emp2);
	        employeesList.add(emp3);
	        employeesList.add(emp4);
	        employeesList.add(emp5);
	    }
	 
	    @GetMapping("/employees/{id}")
	    public Employee getEmployee(@PathVariable int id) {
	        Employee e = null;
	        for (Employee emp : employeesList) {
	            if (emp.getId() == id)
	                e= emp;
	        }
	        return e;
	    }
	 
	    @GetMapping("/employees")
	    public List<Employee> getEmployees() {
	        return this.employeesList;
	    }
	 
	    @PostMapping("/employees")
	    public void addEmployee(@RequestBody Employee emp) {
	        employeesList.add(emp);
	    }


	    @DeleteMapping("/employees/{id}")
	    public void deleteEmployee(@PathVariable int id) {
	        for (Employee emp : employeesList) {
	            if (emp.getId() == id)
	                employeesList.remove(emp);
	        }
	    }

	    @PutMapping ("/employees/{id}")
	    public void updateEmployee(@PathVariable int id, @RequestBody Employee emp) {
	        this.deleteEmployee(id);
	        this.addEmployee(emp);
	    }
	
}
