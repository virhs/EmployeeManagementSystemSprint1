package com.pixeltrice.springbootRestfulAPIhibernatepostgresql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sprint1.EmployeeManagementSystem.models.EmployeeEntity;
import com.sprint1.EmployeeManagementSystem.repositories.EmployeeRepository;
import com.sprint1.EmployeeManagementSystem.controllers.EmployeeController;



@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {

	@SuppressWarnings("unused")
	@Autowired
	private EmployeeEntity employeeEntity;

	@MockBean
	private EmployeeRepository employeeRepository;
	

	@Test
	public void insertEmployeeTest() {
		EmployeeEntity ad = new EmployeeEntity(1,"Derek","Joel","23/03/1999","dgdgd@gmail.com");
		Mockito.when(employeeRepository.save(ad)).thenReturn(ad);
		List<EmployeeEntity> employeeList = employeeRepository.findAll();
		for(int i=0; i<employeeList.size(); i++) {
			if(employeeList.get(i).getUserId() == ad.getUserId()) {
				assertEquals(ad, employeeList.get(i));
			}
		}
		
	}

	  
	 
	 @Test 
	 public void deleteEmployeeTest() { 
		 EmployeeEntity admin = new EmployeeEntity(1,"Derek","Joel","23/03/1999","dgdgd@gmail.com");
		 long id = 1;
		 employeeRepository.save(admin);
		 List<EmployeeEntity> allEmployee = employeeRepository.findAll();
		 for(int i=0; i<allEmployee.size(); i++) {
			 if(allEmployee.get(i).getUserId() == id) {
				 employeeRepository.delete(allEmployee.get(i));
				 assertEquals(allEmployee.get(i), null);
			 }
		 }
		 
	 }
	 
  @Test 
  public void updateEmployeeTest() { 
	 
	  EmployeeEntity employee = new EmployeeEntity(1,"Derek","Joel","23/03/1999","dgdgd@gmail.com");
	  EmployeeEntity employee1 = new EmployeeEntity(2,"Virmani","Solanki","23/03/1999","dgdgd@gmail.com");
	  employeeRepository.save(employee);
	  List<EmployeeEntity> allEmployee = employeeRepository.findAll();
	  for(int i=0; i<allEmployee.size(); i++) {
		  if(allEmployee.get(i).getUserId() == employee1.getUserId()) {
			  
			  allEmployee.get(i).setEmail_id(employee1.getEmail_id());
			  allEmployee.get(i).setFirstName(employee1.getFirstName());
			  allEmployee.get(i).setLastName(employee1.getLastName());
			  allEmployee.get(i).setDob(employee1.getDob());
			  employeeRepository.save(allEmployee.get(i));
			  
			  assertEquals(allEmployee.get(i).getUserId(),employee1.getUserId());
			  assertEquals(allEmployee.get(i).getFirstName(),employee1.getFirstName());
			  assertEquals(allEmployee.get(i).getLastName(),employee1.getLastName());
			  assertEquals(allEmployee.get(i).getEmail_id(),employee.getEmail_id());
			  assertEquals(allEmployee.get(i).getDob(),employee.getDob());
		  }
	  }
	
  }
  
	/*
	 * @Test public void getAllTripsTest() { }
	 * 
	 * @Test public void getTripsCabwiseTest() { }
	 * 
	 * @Test public void getTripsCustomerwiseTest() { }
	 * 
	 * @Test public void getTripsDatewiseTest() { }
	 */
 
}