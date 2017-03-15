package com.eiu.vcarpool.dao;

import java.util.List;

import com.eiu.vcarpool.model.Employee;

public interface IEmployeeDao {

	void insert(Employee eiuEmployees);

	com.eiu.vcarpool.dto.Employee retrieveEmployee(String employeeName);

	List<com.eiu.vcarpool.dto.Employee> loginValidate(Employee loginDetails);

	int restPassword(Employee validDetails);

}
