package com.eiu.vcarpool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiu.vcarpool.dao.ICarPoolDao;
import com.eiu.vcarpool.dao.IEmployeeDao;
import com.eiu.vcarpool.dto.CarPool;
import com.eiu.vcarpool.dto.Employee;

@Service
public class CarPoolService implements ICarPoolService {

	@Autowired
	private ICarPoolDao iCarPoolDao;

	@Autowired
	private IEmployeeDao iEiuEmployeeDao;

	/*
	 * 
	 * To insert the details into the carpool table
	 */

	@Override
	public void insert(String employeeName, CarPool carPool) {
		com.eiu.vcarpool.model.CarPool carPoolModel = new com.eiu.vcarpool.model.CarPool();

		carPoolModel.setCarPoolId(carPool.getCarPoolId());
		carPoolModel.setCarModel(carPool.getCarModel());
		carPoolModel.setStartTime(carPool.getStartTime());
		carPoolModel.setReturnTime(carPool.getReturnTime());
		carPoolModel.setSource(carPool.getSource());
		carPoolModel.setRoute(carPool.getRoute());
		carPoolModel.setDestination(carPool.getDestination());
		carPoolModel.setSeatsAvailable(carPool.getSeatsAvailable());
		carPoolModel.setProviderName(carPool.getProviderName());

		Employee employee = iEiuEmployeeDao.retrieveEmployee(employeeName);
		System.out.println("employee............" + employee.getAge() + "44444"
				+ employee.getGender() + "888888" + employee.getPassword());

		com.eiu.vcarpool.model.Employee employee2 = new com.eiu.vcarpool.model.Employee();
		employee2.setCarPool(carPoolModel);
		employee2.setEmpStatus(employee.getEmpStatus());
		employee2.setEmailId(employee.getEmailId());
		employee2.setEmployeeName(employee.getEmployeeName());
		employee2.setGender(employee.getGender());
		employee2.setPhoneNumber(employee.getPhoneNumber());
		employee2.setUserName(employee.getUserName());
		employee2.setPassword(employee.getPassword());
		employee2.setAge(employee.getAge());
		employee2.setEmpStatus("provider");
		carPoolModel.setProviderName(employee2.getUserName());
		iCarPoolDao.insert(carPoolModel);

		iEiuEmployeeDao.insert(employee2);

	}

	/*
	 * To search the details of carpool
	 */

	@Override
    public List<CarPool> get(CarPool carPool) {
        // TODO Auto-generated method stub
       
        com.eiu.vcarpool.model.CarPool searchCarPool=new com.eiu.vcarpool.model.CarPool();
       
        searchCarPool.setSource(carPool.getSource());
        searchCarPool.setDestination(carPool.getDestination());
        
        
        List<CarPool> searchResults=iCarPoolDao.getSearchDetails(searchCarPool);
       
   
        System.out.println("searchResults.get(0).getCarpoolId()"+searchResults.get(0).getCarPoolId());
        return (List<CarPool>) searchResults;
    }


	@Override
	public CarPool getCarpool(int carPoolId) {

		CarPool carPool = iCarPoolDao.retrieveCarpool(carPoolId);
		return carPool;

	}

	@Override
	public List<Employee> retrieveRiders(Employee employee) {
		com.eiu.vcarpool.model.Employee eiuEmployeesModel = new com.eiu.vcarpool.model.Employee();
		eiuEmployeesModel.setUserName(employee.getUserName());
		eiuEmployeesModel.setAge(employee.getAge());
		eiuEmployeesModel.setEmailId(employee.getEmailId());
		eiuEmployeesModel.setEmployeeName(employee.getEmployeeName());
		eiuEmployeesModel.setEmpStatus(employee.getEmpStatus());
		eiuEmployeesModel.setPhoneNumber(employee.getPhoneNumber());
		eiuEmployeesModel.setGender(employee.getGender());
		eiuEmployeesModel.setPassword(employee.getPassword());
		List<Employee> listOfEmployees = iCarPoolDao
				.retrieveRiders(eiuEmployeesModel);
		return listOfEmployees;
	}

	@Override
	public void deleteRider(Employee employee, String riderName) {
		com.eiu.vcarpool.model.Employee eiuEmployeesModel = new com.eiu.vcarpool.model.Employee();
		eiuEmployeesModel.setUserName(employee.getUserName());
		eiuEmployeesModel.setAge(employee.getAge());
		eiuEmployeesModel.setEmailId(employee.getEmailId());
		eiuEmployeesModel.setEmployeeName(employee.getEmployeeName());
		eiuEmployeesModel.setEmpStatus(employee.getEmpStatus());
		eiuEmployeesModel.setPhoneNumber(employee.getPhoneNumber());
		eiuEmployeesModel.setGender(employee.getGender());
		eiuEmployeesModel.setPassword(employee.getPassword());
		iCarPoolDao.deleteRider(eiuEmployeesModel, riderName);
	}

}
