package com.eiu.vcarpool.service;

import java.util.List;

import com.eiu.vcarpool.dto.Employee;
import com.eiu.vcarpool.dto.Inbox;

public interface IInboxService {

	void sendRequest(Employee provider, Employee rider);

	List<Inbox> retrieveListOfMessages(Employee eiuEmployees);

	void addRider(Employee provider, Employee rider);

	void declineRequest(Employee provider, Employee rider);
}
