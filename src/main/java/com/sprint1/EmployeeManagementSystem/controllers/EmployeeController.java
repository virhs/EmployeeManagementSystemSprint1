package com.sprint1.EmployeeManagementSystem.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.EmployeeManagementSystem.exception.ResourceNotFoundException;
import com.sprint1.EmployeeManagementSystem.models.DepartmentEntity;
import com.sprint1.EmployeeManagementSystem.models.EmployeeEntity;
import com.sprint1.EmployeeManagementSystem.repositories.DepartmentRepository;
import com.sprint1.EmployeeManagementSystem.repositories.EmployeeRepository;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@GetMapping("/get-all-employees")
	public List<EmployeeEntity> getAllEmployee(){
		List<EmployeeEntity> allEmployeelist = employeeRepository.findAll();
		return allEmployeelist;
		
	}
	
	@GetMapping("/get-employee/{id}")
	public EmployeeEntity getEmployeebyId(@PathVariable(value = "id") Integer userId)
      
	{
		EmployeeEntity employeeEntity = employeeRepository.findById(userId).get();
		
		return employeeEntity;	
	}
	
    @PostMapping("/add-employee")
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee) {
       
    	 EmployeeEntity savedEmployee = employeeRepository.save(employee);
    	 
    	 return savedEmployee;
    }
    
    @PutMapping("/update-employee/{id}/department/{did}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable(value = "id") Integer userId, @PathVariable(value = "did") Integer deptId) {
        EmployeeEntity employee = employeeRepository.findById(userId).get();
        DepartmentEntity department = departmentRepository.findById(deptId).get();
        List<EmployeeEntity> list = department.getEmployeeEntity();
        if(list==null) {
        	list = new ArrayList<EmployeeEntity>();
        	list.add(employee);
        }
        else {
        list.add(employee);
        }
        department.setEmployeeEntity(list);
        this.departmentRepository.save(department);
        employee.setDepartmentEntity(department);
        this.employeeRepository.save(employee);
        return ResponseEntity.ok(employee);
    }
    
    @DeleteMapping("/delete-employee/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer userId)
    {
     EmployeeEntity employee = employeeRepository.findById(userId).get();

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("The records of this Employee have been deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/update-employee/{id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable(value = "id") Integer userId, @RequestBody EmployeeEntity employeeDetails) {
        EmployeeEntity employee = employeeRepository.findById(userId).get();
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setDob(employeeDetails.getDob());
        employee.setEmail_id(employeeDetails.getEmail_id());
        final EmployeeEntity updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }


}
