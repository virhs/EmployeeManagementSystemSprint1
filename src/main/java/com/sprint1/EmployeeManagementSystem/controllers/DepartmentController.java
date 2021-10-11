package com.sprint1.EmployeeManagementSystem.controllers;

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

import com.sprint1.EmployeeManagementSystem.models.DepartmentEntity;
import com.sprint1.EmployeeManagementSystem.repositories.DepartmentRepository;

@RestController
@RequestMapping("/api/department")

public class DepartmentController {
	@Autowired
	DepartmentRepository departmentRepository;
	
	@GetMapping("/get-all-departments")
	public List<DepartmentEntity> getAllDepartments(){
		List<DepartmentEntity> allDepartments = departmentRepository.findAll();
		return allDepartments;
		}
	@GetMapping("/get-department/{id}")
	public DepartmentEntity getDepartmentbyId(@PathVariable(value = "id") Integer departmentId)
      
	{
		DepartmentEntity departmentEntity = departmentRepository.findById(departmentId).get();
		
		return departmentEntity;	
	}
	
    @PostMapping("/add-department")
    public DepartmentEntity addDepartment(@RequestBody DepartmentEntity department) {
       
    	 DepartmentEntity newdepartment = departmentRepository.save(department);
    	 
    	 return newdepartment;
    }
    @DeleteMapping("/delete-department/{id}")
    public Map<String, Boolean> deleteDepartment(@PathVariable(value = "id") Integer departmentId)
    {
     DepartmentEntity department = departmentRepository.findById(departmentId).get();

        departmentRepository.delete(department);
        Map<String, Boolean> response = new HashMap<>();
        response.put("The Department has been deleted", Boolean.TRUE);
        return response;
    }
    
}
