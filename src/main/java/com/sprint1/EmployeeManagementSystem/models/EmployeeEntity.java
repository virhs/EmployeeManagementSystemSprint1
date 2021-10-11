package com.sprint1.EmployeeManagementSystem.models;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employees")
public class EmployeeEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	    @Column(name="user_id")
	    private Integer userId;
	    
	    @Column(name = "first_name")
	    private String firstName;
	    
	    @Column(name = "last_name")
	    private String lastName;
	    
	    @Column(name = "dob")
	    private String dob;
	     
	     @Column(name = "email_id")
		    private String email_id;
	    

	     @OneToOne
	     @JoinColumn(name = "dept_id")
	     @JsonIgnore
	     private DepartmentEntity departmentEntity;
	     
	     public EmployeeEntity() {
	    	 
	     }
	     

		public EmployeeEntity(Integer userId, String firstName, String lastName, String dob, String email_id) {
			super();
			this.userId = userId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.dob = dob;
			this.email_id = email_id;
		}

		public DepartmentEntity getDepartmentEntity() {
			return departmentEntity;
		}


		public void setDepartmentEntity(DepartmentEntity departmentEntity) {
			this.departmentEntity = departmentEntity;
		}


		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getDob() {
			return dob;
		}

		public void setDob(String dob) {
			this.dob = dob;
		}

		public String getEmail_id() {
			return email_id;
		}

		public void setEmail_id(String email_id) {
			this.email_id = email_id;
		}


		@Override
		public String toString() {
			return "EmployeeEntity [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob="
					+ dob + ", email_id=" + email_id + "]";
		}
	     
	     

		
	 
	   
	}
