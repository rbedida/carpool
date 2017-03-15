package com.eiu.vcarpool.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eiu.vcarpool.dto.CarPool;
import com.eiu.vcarpool.dto.Employee;
import com.eiu.vcarpool.service.ICarPoolService;

/**
 * 
 * @author EIU\Ram
 * 
 */
@Controller
public class CarpoolController {

	@Autowired
	private ICarPoolService iCarPoolService;

	@RequestMapping(value = "/addCarPool")
	public ModelAndView carpoolForm() {
		return new ModelAndView("addCarpool", "carpool", new CarPool());
	}

	/*
	 * creating a session for userName and inserting a carpool details. Returns
	 * to success page.
	 */

	@RequestMapping(value = "/insertCarPool")
	public String insertCarPool(
			@ModelAttribute(value = "carpool") CarPool carPool,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		Employee eiuEmployee = (Employee) session.getAttribute("userName");
		String empName = eiuEmployee.getUserName();
		System.out.println("empName" + empName);
		iCarPoolService.insert(empName, carPool);
		return "success";
	}

	/*
	 * Displaying the About us page
	 */

	@RequestMapping(value = "/aboutUs")
	public String about() {
		return "aboutUs";
	}

	/*
	 * a page with source and destination fields
	 */

	@RequestMapping(value = "/findCarpool")
	public ModelAndView getSearchDetails(
			@ModelAttribute(value = "search") CarPool carPool) {
		return new ModelAndView("findCarpool", "search", new CarPool());
	}

	/*
	 * Displays the search details.
	 */

	@RequestMapping(value = "/searchroute")
	public ModelAndView searchroute(
			@ModelAttribute(value = "search") CarPool carPool) {
		List<com.eiu.vcarpool.dto.CarPool> searchDetails = iCarPoolService
				.get(carPool);
		System.out.println("searchDetails.get(0).getCarpoolId()"
				+ searchDetails.get(0).getCarPoolId());
		return new ModelAndView("searchresults", "searchDetails", searchDetails);

	}

	@RequestMapping(value = "/retrieveRiders")
	public ModelAndView retrieveRiders(HttpServletRequest request) {
		System.out.println("asfauihggsanhho");
		Employee employee = (Employee) request.getSession().getAttribute(
				"userName");
		List<Employee> listOfRiders = iCarPoolService.retrieveRiders(employee);
		return new ModelAndView("manageCarpool", "listOfRiders", listOfRiders);

	}
	

	/*
	 * creating a session for userName and inserting a carpool details. Returns
	 * to success page.
	 */

	@RequestMapping(value = "/deleteRider")
	public ModelAndView deleteRider(HttpServletRequest request) {
		Employee employee = (Employee) request.getSession().getAttribute(
				"userName");
		String riderName = request.getParameter("id");
		System.out.println("...riderName" + riderName);
		iCarPoolService.deleteRider(employee, riderName);
		List<Employee> listOfRiders = iCarPoolService.retrieveRiders(employee);
		return new ModelAndView("manageCarpool", "listOfRiders", listOfRiders);

	}
}