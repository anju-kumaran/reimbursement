package com.example.reimbursement.repo;

import com.example.reimbursement.models.Reimbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReimbursementRepository extends JpaRepository<Reimbursement, Integer>{

	//Reimbursement findByName(String name);
	Reimbursement findById(int id);

	//List<Reimbursement> findByEmployeeId(@Param("employeeId") int id);
	List<Reimbursement> findByEmployeeId(int id);
	
}
