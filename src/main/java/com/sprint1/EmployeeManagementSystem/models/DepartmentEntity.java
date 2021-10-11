package com.sprint1.EmployeeManagementSystem.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "departments")
public class DepartmentEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	    @Column(name="department_id")
	    private Integer department_id;
	    
	    @Column(name = "department_name", nullable = false)
	    private String department_name;
	    
	    @OneToMany(mappedBy="departmentEntity")
	    private List<EmployeeEntity> employeeEntity;
	    
	   
		public DepartmentEntity() {
	  	  
	    }
		
		 public List<EmployeeEntity> getEmployeeEntity() {
				return employeeEntity;
			}

			public void setEmployeeEntity(List<EmployeeEntity> employeeEntity) {
				this.employeeEntity = employeeEntity;
			}

	 
	    public DepartmentEntity(String department_name) {
	         this.department_name = department_name;
	    }
	    public Integer getdepartment_id() {
	        return department_id;
	    }
	    public void setId(Integer department_id) {
	        this.department_id = department_id;
	    }
	 
	   	    public String getdepartment_name() {
	        return department_name;
	    }
	    public void setdepartment_name(String department_Name) {
	        this.department_name = department_Name;
	    }
	    
	    @Override
	    public String toString() {
	        return "Department[DepartmentId=" + department_id + ", name=" + department_name + "]";
	    }
	 
	    
	    
}
