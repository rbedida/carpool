package com.eiu.vcarpool.service;

import java.util.List;

import com.eiu.vcarpool.dto.CarPool;
import com.eiu.vcarpool.dto.Employee;

public interface ICarPoolService {

	void insert(String employeeName, CarPool carPool);

	List<CarPool> get(com.eiu.vcarpool.dto.CarPool carPool);

	CarPool getCarpool(int carPoolId);

	/*
	 * List<Employee> retrieveRiders(Employee employee); void
	 * deleteRider(Employee employee, String riderName);
	 */
	List<Employee> retrieveRiders(Employee employee);

	void deleteRider(Employee employee, String riderName);
}
