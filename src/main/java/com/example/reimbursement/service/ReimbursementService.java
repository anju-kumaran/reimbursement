package com.example.reimbursement.service;

import java.util.List;
import java.util.Optional;

import com.example.reimbursement.models.Reimbursement;
import com.example.reimbursement.repo.ReimbursementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Service for Reimbursement
 */
@Slf4j
@Service
public class ReimbursementService {

	private ReimbursementRepository reimbursementRepo;

	public ReimbursementService(ReimbursementRepository reimbursementRepo) {
		super();
		this.reimbursementRepo = reimbursementRepo;
	}

	/**
	 * This is to create a new reimbursement request
	 * @param reimbursement
	 * @return
	 */
	public boolean saveReimbursement(Reimbursement reimbursement) {
		reimbursementRepo.save(reimbursement);
		return true;
	}

	/**
	 * This method is used to get the reimbursement requests of an employee
	 * @param empId
	 * @return
	 */
	public List<Reimbursement> getReimbursementById(int empId) {
		//Optional<Reimbursement> myReimbursement = reimbursementRepo.findById(empId);
		//return myReimbursement;
		//return reimbursementRepo.findById(empId);
		//return reimbursementRepo.findByEmployeeId(empId);
		log.info("Before findByEmployeeId call");
		List<Reimbursement> myReimbursement = reimbursementRepo.findByEmployeeId(empId);
		return myReimbursement;
	}

//	public Reimbursement getReimbursementById(int empId) {
//		//Optional<Reimbursement> myReimbursement = reimbursementRepo.findById(empId);
//		//return myReimbursement;
//		//return reimbursementRepo.findById(empId);
//		return reimbursementRepo.findByEmployeeId(empId);
//
//	}

//	public Reimbursement getReimbursementByName(String s) {
//
//		if(s.equalsIgnoreCase("pluto")) {
//			return new Reimbursement(-1, "no planet of that name exists!",-10);
//		}else {
//			Reimbursement newReimbursement = reimbursementRepo.findByName(s);
//
//			if(newReimbursement == null) {
//				return new Reimbursement(-1, "no planet of this name exists!",-10);
//			}else {
//				return newReimbursement;
//			}
//		}
//
//	}

	/**
	 * This is to update a reimbursement request to approve/deny/reassign
	 * @param id
	 * @param reimbursement
	 * @return
	 */
	public boolean updateReimbursement(int id, Reimbursement reimbursement) {
		Reimbursement reimbursementData = reimbursementRepo.findById(id);

		//Optional<Reimbursement> reimbursementData = reimbursementRepo.findById(id);
		//if (reimbursementData.) {
		log.debug("reimbursementData = "+reimbursementData);
		reimbursementData.setAmount(reimbursement.getAmount());
		reimbursementData.setDescription(reimbursement.getDescription());
		reimbursementData.setStatus(reimbursement.getStatus());
		reimbursementData.setSubmittedDate(reimbursement.getSubmittedDate());
		reimbursementData.setEmployeeId(reimbursement.getEmployeeId());
		reimbursementRepo.save(reimbursementData);
		return true;
			//Reimbursement data = reimbursementData.;
//			data.setTitle(reimbursement.getTitle());
//			data.setDescription(reimbursement.getDescription());
//			data.setPublished(reimbursement.isPublished());
//			return new ResponseEntity<>(reimbursementRepo.save(data), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		//}

	}

	/**
	 * To get all the reimbursement requests
	 * @return
	 */
	public List<Reimbursement> getAllReimbursements(){
		log.info("Before Calling findAll in getAllReimbursements");
		return reimbursementRepo.findAll();
	}


}
