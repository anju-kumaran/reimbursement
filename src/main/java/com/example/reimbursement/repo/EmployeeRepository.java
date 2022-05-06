package com.example.reimbursement.repo;

import com.example.reimbursement.models.Employee;
import com.example.reimbursement.models.Reimbursement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Employee findById(int id);

}
