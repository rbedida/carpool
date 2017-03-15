package com.eiu.vcarpool.dto;

import java.util.ArrayList;
import java.util.List;

public class Employee {

	/**
	 * The name of the Employee. The name should contain 25 characters.
	 */

	private String employeeName;

	/**
	 * The user name of the Employee. The userName should be of minimum 1
	 * character and maximum 10 characters.
	 */
	private String userName;

	/**
	 * Password for an Employee VCarpooling account. Password should contain at
	 * least one digit, an alphabet and length 4-8 characters.
	 */

	private String password;

	/**
	 * Another rePassword field for confirmation. Must be same as password
	 * field.
	 */

	private String rePassword;

	/**
	 * The gender of an Employee.
	 */

	private String gender;

	/**
	 * Age of an Employee. It cannot be null.
	 */

	private String age;

	/**
	 * PhoneNumber of an Employee.
	 */

	private String phoneNumber;

	/**
	 * Email-Id of an Employee.
	 */

	private String emailId;

	/**
	 * Member of type CarPool. An Employee is part of CarPool.
	 */
	private CarPool carPool;

	/**
	 * Status of an Employee - Activate(A), Deactivate(D).
	 */

	private String empStatus;

	/**
	 * The inbox of an Employee contains a list of messages.
	 */
	private List<Inbox> employeeInbox = new ArrayList<Inbox>();

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public CarPool getCarPool() {
		return carPool;
	}

	public void setCarPool(CarPool carPool) {
		this.carPool = carPool;
	}

	public String getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	public List<Inbox> getEmployeeInbox() {
		return employeeInbox;
	}

	public void setEmployeeInbox(List<Inbox> employeeInbox) {
		this.employeeInbox = employeeInbox;
	}

}
