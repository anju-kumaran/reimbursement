package com.example.reimbursement.service;

import com.example.reimbursement.models.Employee;
import com.example.reimbursement.models.Reimbursement;
import com.example.reimbursement.repo.EmployeeRepository;
import com.example.reimbursement.repo.ReimbursementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for Employee entity
 */
@Slf4j
@Service
public class EmployeeService {

	private EmployeeRepository employeeRepo;

	public EmployeeService(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}


	/**
	 * This method is used to get the Employee details
	 * @param id
	 * @return employee
	 */
	public Employee getEmployeeById(int id) {
		log.info("Before employeeRepo findById call");
		Employee employee = employeeRepo.findById(id);
		return employee;
	}

}
