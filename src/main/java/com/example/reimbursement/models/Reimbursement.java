package com.example.reimbursement.models;

import javax.persistence.*;

/**
 * Model for reimbursement
 */

@Entity
@Table
public class Reimbursement {
	
	@Id //to treat this state as the primary key
	@GeneratedValue(strategy = GenerationType.AUTO) //primary key value will be auto generated!
	private int id;

	@Column
	private double amount;
	
	@Column
	private String description;

	@Column
	private String status;

	@Column(name = "submitted_date")
	private String submittedDate;

	@Column(name = "employee_id")
	private int employeeId;

//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name="employee_id", updatable = false, insertable = false)
//	private Employee employee;
	
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int id, double amount, String description, String status, String submittedDate, int employeeId) {
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.status = status;
		this.submittedDate = submittedDate;
		this.employeeId = employeeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	@Override
	public String toString() {
		return "Reimbursement{" +
				"id=" + id +
				", amount=" + amount +
				", description='" + description + '\'' +
				", status='" + status + '\'' +
				", submittedDate='" + submittedDate + '\'' +
				", employeeId=" + employeeId +
				'}';
	}



//	public Reimbursement(int id, double amount, String description, String status, String submittedDate, Employee employee) {
//		this.id = id;
//		this.amount = amount;
//		this.description = description;
//		this.status = status;
//		this.submittedDate = submittedDate;
//		this.employee = employee;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public double getAmount() {
//		return amount;
//	}
//
//	public void setAmount(double amount) {
//		this.amount = amount;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public String getSubmittedDate() {
//		return submittedDate;
//	}
//
//	public void setSubmittedDate(String submittedDate) {
//		this.submittedDate = submittedDate;
//	}
//
//	public Employee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
//
//	@Override
//	public String toString() {
//		return "Reimbursement{" +
//				"id=" + id +
//				", amount=" + amount +
//				", description='" + description + '\'' +
//				", status='" + status + '\'' +
//				", submittedDate='" + submittedDate + '\'' +
//				", employee=" + employee +
//				'}';
//	}
}
