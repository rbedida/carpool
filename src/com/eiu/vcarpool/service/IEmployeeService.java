package com.eiu.vcarpool.service;

import java.util.List;

import com.eiu.vcarpool.dto.Employee;

public interface IEmployeeService {

	void insert(Employee eiuEmployees);

	/*
	 * method to validate the userName and password
	 */
	List<Employee> loginValidate(Employee loginDetails);

	/*
	 * method to validate the changed password
	 */
	String resetPassword(Employee validDetails);

	Employee getEmployee(String employeeName);

}
