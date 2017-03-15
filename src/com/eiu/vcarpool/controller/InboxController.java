package com.eiu.vcarpool.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eiu.vcarpool.dto.Employee;
import com.eiu.vcarpool.dto.Inbox;
import com.eiu.vcarpool.service.IEmployeeService;
import com.eiu.vcarpool.service.IInboxService;

/**
 * 
 * @author EIU\Ram
 * 
 */
@Controller
public class InboxController {

	@Autowired
	private IInboxService iInboxService;

	@Autowired
	private IEmployeeService iEmployeeService;

	@RequestMapping(value = "/showInterest")
	public String showInterest(HttpServletRequest request) {
		String employeeName = request.getParameter("id");
		// CarPool carpool=iCarPoolService.getCarpool(carpoolId);
		// System.out.println(carpool);
		Employee provider = iEmployeeService.getEmployee(employeeName);
		HttpSession session = request.getSession(true);
		Employee rider = (Employee) session.getAttribute("userName");
		System.out.println(provider.getCarPool() + "::::");
		/*
		 * Inbox inbox = new Inbox(); inbox.setSenderName(rider.getUserName());
		 * inbox.setReceiverName(provider.getUserName());
		 * inbox.setStatus("pending");
		 */
		iInboxService.sendRequest(provider, rider);
		return "searchresults";

	}

	@RequestMapping(value = "/inbox")
	public ModelAndView fetchInbox(HttpServletRequest request) {

		Employee eiuEmployee = (Employee) request.getSession()
				.getAttribute("userName");
		System.out.println("eiuEmployee"
				+ request.getSession().getAttribute("userName"));

		List<Inbox> listOfMessages = iInboxService
				.retrieveListOfMessages(eiuEmployee);
		System.out.println(listOfMessages);

		return new ModelAndView("inbox", "listOfMessages", listOfMessages);
	}

	@RequestMapping(value = "/accept")
	public ModelAndView accept(HttpServletRequest request) {

		Employee provider = (Employee) request.getSession().getAttribute(
				"userName");
		System.out.println("eiuEmployee"
				+ request.getSession().getAttribute("userName"));
		String riderName = request.getParameter("id");
		System.out.println(riderName);
		System.out.println("daad" + provider.getUserName());
		Employee rider = iEmployeeService.getEmployee(riderName);
		provider = iEmployeeService.getEmployee(provider.getUserName());
		iInboxService.addRider(provider, rider);

		return new ModelAndView("inbox");
	}

	@RequestMapping(value = "/decline")
	public ModelAndView decline(HttpServletRequest request) {

		Employee provider = (Employee) request.getSession().getAttribute(
				"userName");
		System.out.println("eiuEmployee"
				+ request.getSession().getAttribute("userName"));
		String riderName = request.getParameter("id");
		System.out.println(riderName);
		System.out.println("daad" + provider.getUserName());
		Employee rider = iEmployeeService.getEmployee(riderName);
		provider = iEmployeeService.getEmployee(provider.getUserName());
		iInboxService.declineRequest(provider, rider);

		return new ModelAndView("inbox");
	}

}