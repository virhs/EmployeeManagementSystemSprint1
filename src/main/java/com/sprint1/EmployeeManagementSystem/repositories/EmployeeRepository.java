package com.sprint1.EmployeeManagementSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint1.EmployeeManagementSystem.models.EmployeeEntity;

    @Repository
	public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{

	}



