package com.eiu.vcarpool.dao; 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.eiu.vcarpool.model.CarPool;
import com.eiu.vcarpool.model.Employee;

@Component
public class CarPoolDao implements ICarPoolDao {

	@Autowired
	private HibernateTemplate hibernateTemplate; 
	@Override
	public void insert(CarPool carPool) {

		hibernateTemplate.saveOrUpdate(carPool);

	}

	@Override
	public final List<com.eiu.vcarpool.dto.CarPool> getSearchDetails(
			CarPool carPool) {
		// TODO Auto-generated method stub

		Object[] sqlParams = { carPool.getSource() + "%",
				carPool.getDestination() + "%" };
		// Object[] values = {"a%","v%"};
		String queryName = "from CarPool where (source like ? and destination like ?)";
		@SuppressWarnings("unchecked")
		List<CarPool> carpoolList = hibernateTemplate
				.find(queryName, sqlParams);

		List<com.eiu.vcarpool.dto.CarPool> listOfCarPools = new ArrayList<com.eiu.vcarpool.dto.CarPool>();

		Iterator<CarPool> iterator = carpoolList.iterator();

		while (iterator.hasNext()) {
			com.eiu.vcarpool.dto.CarPool carpool2 = new com.eiu.vcarpool.dto.CarPool();
			CarPool cPool = new CarPool();
			cPool = iterator.next();
			carpool2.setCarPoolId(cPool.getCarPoolId());
			carpool2.setCarModel(cPool.getCarModel());
			carpool2.setSource(cPool.getSource());
			carpool2.setRoute(cPool.getRoute());
			carpool2.setDestination(cPool.getDestination());
			carpool2.setStartTime(cPool.getStartTime());
			carpool2.setReturnTime(cPool.getReturnTime());
			carpool2.setSeatsAvailable(cPool.getSeatsAvailable());
			listOfCarPools.add(carpool2);

		}

		System.out.println(listOfCarPools.size() + "...."
				+ listOfCarPools.get(0).getCarPoolId());
		return listOfCarPools;
		// String query = "from user u where u.name like :name";
		// getHibernateTemplate().findByNamedParam(query, "name", '%' + str +
		// '%');
	}

	public com.eiu.vcarpool.dto.CarPool retrieveCarpool(int carPoolId) {
		CarPool carPool = new CarPool();
		com.eiu.vcarpool.dto.CarPool carPool1 = new com.eiu.vcarpool.dto.CarPool();
		carPool = hibernateTemplate.get(CarPool.class, carPoolId);

		carPool1.setCarPoolId(carPool.getCarPoolId());
		carPool1.setCarModel(carPool.getCarModel());
		carPool1.setDestination(carPool.getDestination());
		carPool1.setGenderPreference(carPool.getGenderPreference());
		carPool1.setProviderName(carPool.getProviderName());
		carPool1.setStartTime(carPool.getStartTime());
		carPool1.setReturnTime(carPool.getReturnTime());
		carPool1.setSource(carPool.getSource());
		carPool1.setSeatsAvailable(carPool.getSeatsAvailable());
		carPool1.setRoute(carPool.getRoute());

		return carPool1;

	}

	@Override public List<com.eiu.vcarpool.dto.Employee> retrieveRiders(
			Employee employee) {

		Employee provider = hibernateTemplate.get(Employee.class,
				employee.getUserName());

		List<Employee> listOfRiders = provider.getCarPool().getSetOfRiders();

		List<com.eiu.vcarpool.dto.Employee> ridersList = new ArrayList<com.eiu.vcarpool.dto.Employee>();

		Iterator<Employee> iterator = listOfRiders.iterator();

		while (iterator.hasNext()) {
			com.eiu.vcarpool.dto.Employee employee1 = new com.eiu.vcarpool.dto.Employee();
			Employee employee2 = iterator.next();
			employee1.setAge(employee2.getAge());
			employee1.setEmailId(employee2.getEmailId());
			employee1.setEmployeeName(employee2.getEmployeeName());
			employee1.setEmpStatus(employee2.getEmpStatus());
			employee1.setPassword(employee2.getPassword());
			employee1.setPhoneNumber(employee2.getPhoneNumber());
			employee1.setUserName(employee2.getUserName());
			ridersList.add(employee1);
		}

		return ridersList;
	}

	@Override
	public void deleteRider(Employee employee, String riderName) {
		Employee provider = hibernateTemplate.get(Employee.class,
				employee.getUserName());
		Employee rider = hibernateTemplate.get(Employee.class, riderName);

		// provider.getCarPool().getSetOfRiders().remove(rider);

		CarPool carpool = provider.getCarPool();
		// carpool.getSetOfRiders().remove(rider);
		List<Employee> listOfRiders = provider.getCarPool().getSetOfRiders();

		List<Employee> ridersList = new ArrayList<Employee>();

		Iterator<Employee> iterator = listOfRiders.iterator();

		while (iterator.hasNext()) {
			Employee employee2 = iterator.next();

			if (!employee2.getUserName().equals(riderName)) {
				ridersList.add(employee2);
			}

		}
		carpool.setSeatsAvailable(carpool.getSeatsAvailable() + 1);
		carpool.setSetOfRiders(ridersList);
		hibernateTemplate.saveOrUpdate(carpool);

	}

}
