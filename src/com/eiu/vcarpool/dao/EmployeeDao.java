package com.eiu.vcarpool.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.eiu.vcarpool.model.CarPool;
import com.eiu.vcarpool.model.Employee;

@Component
public class EmployeeDao implements IEmployeeDao {

	/**
	 * A reference of HibernateTemplate
	 */

	/**
	 * @param sessionFactory
	 *            SessionFactory
	 */
	public final void setSessionFactory(final SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public void insert(Employee eiuEmployees) {

		hibernateTemplate.saveOrUpdate(eiuEmployees);
	}

	@Override
	public com.eiu.vcarpool.dto.Employee retrieveEmployee(
			String employeeName) {
		System.out.println(employeeName+"daooo");
		Employee employee = hibernateTemplate.get(Employee.class, employeeName);
		CarPool carPool = employee.getCarPool();
		com.eiu.vcarpool.dto.CarPool carPool2 = new com.eiu.vcarpool.dto.CarPool();
		com.eiu.vcarpool.dto.Employee employee2 = new com.eiu.vcarpool.dto.Employee();
		if (null != carPool) {

			carPool2.setCarPoolId(carPool.getCarPoolId());
			carPool2.setCarModel(carPool.getCarModel());
			carPool2.setStartTime(carPool.getStartTime());
			carPool2.setReturnTime(carPool.getReturnTime());
			carPool2.setSource(carPool.getSource());
			carPool2.setRoute(carPool.getRoute());
			carPool2.setDestination(carPool.getDestination());
			carPool2.setSeatsAvailable(carPool.getSeatsAvailable());
			carPool2.setProviderName(carPool.getProviderName());
			employee2.setCarPool(carPool2);

			// employee2.setCarpool(carPool2);
		}

		employee2.setAge(employee.getAge());
		employee2.setEmailId(employee.getEmailId());
		employee2.setEmpStatus(employee.getEmpStatus());
		employee2.setEmployeeName(employee.getEmployeeName());
		employee2.setGender(employee.getGender());
		employee2.setPassword(employee.getPassword());

		employee2.setPhoneNumber(employee.getPhoneNumber());
		employee2.setUserName(employee.getUserName());

		return employee2;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.eiu.vcarpool.dto.Employee> loginValidate(
			Employee loginDetails) {

		List<com.eiu.vcarpool.dto.Employee> eiuEmployeesList = new ArrayList<com.eiu.vcarpool.dto.Employee>();
		List<Employee> listOfEmployees = new ArrayList<Employee>();
		Object[] userParameters = new Object[2];
		if (null != loginDetails) {
			userParameters[0] = loginDetails.getUserName();
			userParameters[1] = loginDetails.getPassword();

		}
		listOfEmployees = hibernateTemplate
				.find("from Employee where userName=? and password=?",
						userParameters);
		Iterator<Employee> iterator = listOfEmployees.iterator();

		while (iterator.hasNext()) {
			com.eiu.vcarpool.dto.Employee eiuEmployees = new com.eiu.vcarpool.dto.Employee();
			Employee eiuEmployees2 = (Employee) iterator.next();
			eiuEmployees.setEmpStatus(eiuEmployees2.getEmpStatus());
			eiuEmployees.setEmployeeName(eiuEmployees2
					.getEmployeeName());
			eiuEmployees.setEmailId(eiuEmployees2.getEmailId());
			eiuEmployees.setEmployeeName(eiuEmployees2
					.getEmployeeName());
			eiuEmployees.setGender(eiuEmployees2.getGender());
			eiuEmployees.setPhoneNumber(eiuEmployees2.getPhoneNumber());
			eiuEmployees.setUserName(eiuEmployees2.getUserName());
			eiuEmployees.setPassword(eiuEmployees2.getPassword());
			eiuEmployeesList.add(eiuEmployees);

		}

		// returns a list
		return eiuEmployeesList;
	}

	@Override
	public int restPassword(Employee validDetails) {

		Object[] validUserParameters = new Object[3];

		if (null != validDetails) {
			validUserParameters[2] = validDetails.getUserName();
			validUserParameters[1] = validDetails.getEmployeeName();

			validUserParameters[0] = validDetails.getPassword();
		}

		int i = hibernateTemplate.bulkUpdate("update Employee set password = ?"
				+ " where  userName = ?", validUserParameters);

		return i;

	}
}
