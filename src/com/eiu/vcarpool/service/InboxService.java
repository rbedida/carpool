package com.eiu.vcarpool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiu.vcarpool.dao.IInboxDao;
import com.eiu.vcarpool.dto.Employee;
import com.eiu.vcarpool.dto.Inbox;

@Service
public class InboxService implements IInboxService {

	@Autowired
	private IInboxDao iInboxDao;

	@Override
	public void sendRequest(Employee provider, Employee rider) {

		final Inbox inbox = new Inbox();
		final Inbox inbox1 = new Inbox();

		inbox.setStatus("pending");
		inbox.setSenderName(provider.getUserName());
		inbox.setReceiverName(rider.getUserName());

		inbox1.setStatus("pending");
		inbox1.setSenderName(rider.getUserName());
		inbox1.setReceiverName(provider.getUserName());

		List<Inbox> listOfMessagesProvider = iInboxDao
				.retrieveEmployeeInbox(provider.getUserName());
		List<Inbox> listOfMessagesRider = iInboxDao.retrieveEmployeeInbox(rider
				.getUserName());
		listOfMessagesProvider.add(inbox1);
		listOfMessagesRider.add(inbox);
		provider.setEmployeeInbox(listOfMessagesProvider);
		rider.setEmployeeInbox(listOfMessagesRider);
		iInboxDao.sendRequest(provider, rider);

	}

	@Override
	public List<Inbox> retrieveListOfMessages(Employee employees) {

		List<Inbox> listOfMessages = iInboxDao.retrieveEmployeeInbox(employees
				.getUserName());
		return listOfMessages;

	}

	@Override
	public void addRider(Employee provider, Employee rider) {
		iInboxDao.addRider(provider, rider);
	}

	@Override
	public void declineRequest(Employee provider, Employee rider) {
		iInboxDao.declineRequest(provider, rider);
	}

}
