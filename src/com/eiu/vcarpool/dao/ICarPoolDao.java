package com.eiu.vcarpool.dao;

import java.util.List;

import com.eiu.vcarpool.model.CarPool;
import com.eiu.vcarpool.model.Employee;

public interface ICarPoolDao {

	void insert(CarPool carPool);

	List<com.eiu.vcarpool.dto.CarPool> getSearchDetails(CarPool carPool);

	com.eiu.vcarpool.dto.CarPool retrieveCarpool(int carPoolId);

	List<com.eiu.vcarpool.dto.Employee> retrieveRiders(Employee employee);

	void deleteRider(Employee employee, String riderName);

}
