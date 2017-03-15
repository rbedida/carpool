package com.eiu.vcarpool.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eiu.vcarpool.dto.CarPool;
import com.eiu.vcarpool.dto.Employee;
import com.eiu.vcarpool.service.ICarPoolService;
import com.eiu.vcarpool.service.IEmployeeService;

/**
 * 
 * @author EIU\Ram
 * 
 */
@Controller
public class EmployeeController {

	@Autowired
	private ICarPoolService iCarPoolService;

	@Autowired
	private IEmployeeService iEmployeeService;

	@RequestMapping(value = "/hello")
	public String hello() {
		return "hello";
	}

	/*
	 * add the details of employess Register page.
	 */

	@RequestMapping(value = "/addEiuEmployee")
	public ModelAndView employeeForm() {

		return new ModelAndView("addEiuEmployee", "eiuemployee",
				new Employee());
 }

	/*
	 * insert the details of employees and display the page.
	 */

	@RequestMapping(value = "/insertEiuEmployee")
	public String insertEmployee(
			@ModelAttribute(value = "eiuemployee") Employee eiuEmployees) {
		iEmployeeService.insert(eiuEmployees);
		System.out.println("ageeeeeee" + eiuEmployees.getGender());

		return "success";

	}

	/*
	 * Login form.
	 */

	@RequestMapping(value = "/loginform", method = RequestMethod.GET)
	public final ModelAndView login(final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		final ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("eiuEmployees", new Employee());
		return new ModelAndView("loginform", modelMap);
	}

	/*
	 * validation and returns to the userpage
	 */

	@RequestMapping(value = "/validate")
	public String validateUser(
			@ModelAttribute(value = "eiuEmployees") Employee userCredentials,
			HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		List<Employee> userDetails = iEmployeeService
				.loginValidate(userCredentials);
		/* System.out.println(userDetails.get(0)); */
		if (null != userDetails && userDetails.size() != 0) {
			session.setAttribute("userName", userDetails.get(0));
			/*
			 * System.out.println("sdadas"+session.getAttribute("userName"));
			 */return "userPage";
		} else
			return "failure";
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("userName");
		session.invalidate();
		return "logout";
	}

	@RequestMapping(value = "/employeedetails")
	public ModelAndView popupEmployee(HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println(request.getParameter("cId"));
		int carPoolId = Integer.parseInt(request.getParameter("cId"));
		System.out.println("hii" + carPoolId);

		CarPool carPool3 = iCarPoolService.getCarpool(carPoolId);
		com.eiu.vcarpool.dto.Employee employee = new Employee();
		employee = iEmployeeService.getEmployee(carPool3.getProviderName());

		System.out.println(carPool3.getProviderName());

		return new ModelAndView("popupdetails", "employee", employee);

	}

	/*
	 * Forwards to forgot password page.
	 */

	@RequestMapping(value = "/forgotpassword")
	public ModelAndView forgotpasswordPage() {
		return new ModelAndView("forgotpassword", "eiuemployee",
				new Employee());
	}

	@RequestMapping(value = "/resetpassword")
	public ModelAndView resetPassword(
			@ModelAttribute(value = "eiuemployee") Employee vUserCredentials,
			HttpServletRequest request) {

		String result = iEmployeeService.resetPassword(vUserCredentials);

		return new ModelAndView(result, "eiuEmployees", new Employee());
	}
}