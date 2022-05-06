package com.example.reimbursement;

import com.example.reimbursement.models.Employee;
import com.example.reimbursement.models.Reimbursement;
import com.example.reimbursement.service.EmployeeService;
import com.example.reimbursement.service.ReimbursementService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Tests for EmployeeService
 */
@SpringBootTest
class EmployeeServiceTests {

	@Autowired
	EmployeeService employeeService;

	/**
	 * Test should return employee
	 */

	@Test
	public void shouldGetEmployeeById(){
		Employee employee = employeeService.getEmployeeById(4);
		Assertions.assertNotNull(employee);
	}

}
