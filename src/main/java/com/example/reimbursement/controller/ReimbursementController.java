package com.example.reimbursement.controller;

import java.net.URI;
import java.util.List;

import com.example.reimbursement.models.Employee;
import com.example.reimbursement.models.Reimbursement;
import com.example.reimbursement.service.EmployeeService;
import com.example.reimbursement.service.ReimbursementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequestMapping("/api")
public class ReimbursementController {
	/**
	 * Mappings to Create, Read, Update and Delete reimbursements
	 */
	
	@Autowired
	ReimbursementService reimbursementService;

	@Autowired
	EmployeeService employeeService;


	/**
	 * To submit a reimbursement request
	 * @param newReimbursement
	 */
	@PostMapping("/reimbursement")
	public String createReimbursement(@RequestBody Reimbursement newReimbursement) {

		log.info("Starting to add a new reimbursement request");
		boolean success = reimbursementService.saveReimbursement(newReimbursement);
		log.info("Successfully added a new reimbursement request");
		if(success == false) {
			//throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT,"Error adding new reimbursement request!");
			return "Error adding new reimbursement request!";
		} else {
			return "Successfully submitted a new reimbursement request.";
		}

	}


	/**
	 * To view all reimbursements of an employee
	 * @param employeeId
	 * @return
	 */
	@GetMapping("/reimbursement/{employeeId}")
	public List<Reimbursement> viewReimbursementByEmployeeId(@PathVariable int employeeId) {
		log.info("Reimbursement employeeId = "+employeeId);
		List<Reimbursement> myReimbursement = reimbursementService.getReimbursementById(employeeId);
		log.info("myReimbursement : "+myReimbursement);
		return myReimbursement;
	}


	/**
	 *To view all reimbursements
	 * @return
	 */
	@GetMapping("/reimbursements")
	public List<Reimbursement> viewAllReimbursements() {

		log.info("Start view all Reimbursements");

		return reimbursementService.getAllReimbursements();
	}


	/**
	 * To Approve/Deny/Reassign reimbursements
	 * @param id
	 * @param reimbursement
	 * @return
	 */
	@PutMapping("/reimbursement/{id}")
	public ResponseEntity<Reimbursement> updateReimbursement(@PathVariable int id, @RequestBody Reimbursement reimbursement) {
		log.info("Reimbursement update id = "+id);
		//int empId = reimbursement.getEmployeeId();
		boolean success = reimbursementService.updateReimbursement(id, reimbursement);
		log.info("Reimbursement request updated successfully");
		if(success) {
			Employee employee = employeeService.getEmployeeById(reimbursement.getEmployeeId());
			String email = employee.getEmail();
			log.info("Employee email: "+email);
			RestTemplate rest = new RestTemplate();
			//String resourceUrl = "http://localhost:8080/sendEmail";
			String resourceUrl = "http://34.130.241.186:8080/sendEmail";
			ResponseEntity<String> response = rest.getForEntity(resourceUrl + "/"+email, String.class);

			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}



//	@GetMapping("/reimbursement/{id}")
//	public Reimbursement viewReimbursementByEmployeeId(@PathVariable int id) {
//		System.out.println("Reimbursement id = "+id);
//		Reimbursement myReimbursement = reimbursementService.getReimbursementById(id);
//		System.out.println(myReimbursement);
//		return myReimbursement;
//	}

//
//	@DeleteMapping("/reimbursement")
//	public void deleteReimbursement() {
//
//	}


}
