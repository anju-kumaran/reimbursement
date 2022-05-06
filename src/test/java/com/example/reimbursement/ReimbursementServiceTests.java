package com.example.reimbursement;

import com.example.reimbursement.models.Reimbursement;
import com.example.reimbursement.service.ReimbursementService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Tests for ReimbursementServices
 */
@Slf4j
@SpringBootTest
class ReimbursementServiceTests {

	@Autowired
	ReimbursementService reimbursementService;


	/**
	 * Test should create new request
	 */
	@Test
	public void shouldSaveReimbursement()
	{
		Assertions.assertTrue(reimbursementService.saveReimbursement(new Reimbursement(9,100,"Food","New","2022-05-05",1)));
	}

	/**
	 * Test should update reimbursement to Approved/Denied/Reassigned
	 */
	@Test
	public void shouldUpdateReimbursement()
	{
		Assertions.assertTrue(reimbursementService.updateReimbursement(4,new Reimbursement(4,500,"Certification expense","Denied","2022-05-02",4)));
	}


	/**
	 * Test should return all requests
	 */
	@Test
	public void shouldReturnAllReimbursements(){
		List reimbursements = reimbursementService.getAllReimbursements();
		Assertions.assertNotNull(reimbursements);
	}

	/**
	 * should Return All Reimbursement By EmployeeID
	 */
	@Test
	public void shouldReturnAllReimbursementByEmployeeID(){
		List reimbursement = reimbursementService.getReimbursementById(4);
		Assertions.assertNotNull(reimbursement);
	}

	@Test
	void contextLoads() {
	}

}
