package com.eiu.vcarpool.dao;

import java.util.List;

import com.eiu.vcarpool.dto.Employee;

public interface IInboxDao {

	void sendRequest(com.eiu.vcarpool.dto.Employee provider,
			com.eiu.vcarpool.dto.Employee rider);

	List<com.eiu.vcarpool.dto.Inbox> retrieveEmployeeInbox(String userName);

	void addRider(com.eiu.vcarpool.dto.Employee provider,
			com.eiu.vcarpool.dto.Employee rider);

	void declineRequest(Employee provider, Employee rider);
}
