package com.eiu.vcarpool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiu.vcarpool.dao.IEmployeeDao;
import com.eiu.vcarpool.dto.Employee;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeDao iEiuEmployeeDao;

	@Override
	public void insert(Employee eiuEmployees) {

		com.eiu.vcarpool.model.Employee eiuEmployeesModel = new com.eiu.vcarpool.model.Employee();

		eiuEmployeesModel.setUserName(eiuEmployees.getUserName());
		eiuEmployeesModel.setAge(eiuEmployees.getAge());
		eiuEmployeesModel.setEmailId(eiuEmployees.getEmailId());
		eiuEmployeesModel.setEmployeeName(eiuEmployees
				.getEmployeeName());
		eiuEmployeesModel.setEmpStatus(eiuEmployees.getEmpStatus());
		eiuEmployeesModel.setPhoneNumber(eiuEmployees.getPhoneNumber());
		eiuEmployeesModel.setGender(eiuEmployees.getGender());
		eiuEmployeesModel.setPassword(eiuEmployees.getPassword());

		iEiuEmployeeDao.insert(eiuEmployeesModel);

	}

	/*
	 * 
	 * validate the userName and password
	 */

	@Override
	public List<com.eiu.vcarpool.dto.Employee> loginValidate(
			Employee loginDetails) {
		List<com.eiu.vcarpool.dto.Employee> eiuEmployeesList = null;

		com.eiu.vcarpool.model.Employee eiuEmployeesModel = new com.eiu.vcarpool.model.Employee();

		eiuEmployeesModel.setUserName(loginDetails.getUserName());
		eiuEmployeesModel.setPassword(loginDetails.getPassword());

		eiuEmployeesList = iEiuEmployeeDao
				.loginValidate(eiuEmployeesModel);

		// returns a list
		return eiuEmployeesList;
	}

	/*
	 * validation for changing the password
	 */

	@Override
	public String resetPassword(Employee validDetails) {
		com.eiu.vcarpool.model.Employee validEmployeeModel = new com.eiu.vcarpool.model.Employee();
		validEmployeeModel.setUserName(validDetails.getUserName());
		validEmployeeModel.setEmployeeName(validDetails.getEmployeeName());
		validEmployeeModel.setPassword(validDetails.getPassword());
		String status = "failure";

		int i = iEiuEmployeeDao.restPassword(validEmployeeModel);
		if (i == 1) {

			status = "loginform";
		} else {
			status = "failure";
		}

		return status;

	}

	@Override
	public Employee getEmployee(String employeeName) {
		Employee eiuEmployees = new Employee();
		System.out.println(employeeName+"service");
		eiuEmployees = iEiuEmployeeDao.retrieveEmployee(employeeName);
		return eiuEmployees;
	}

}
