package com.eiu.vcarpool.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.eiu.vcarpool.model.Employee;
import com.eiu.vcarpool.model.Inbox;

@Component
public class InboxDao implements IInboxDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public final void setSessionFactory(final SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
		this.sessionFactory = sessionFactory;
	}

	/**
	 * A reference of HibernateTemplate
	 */

	/**
	 * @param sessionFactory
	 *            SessionFactory
	 */

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public void sendRequest(com.eiu.vcarpool.dto.Employee provider,
			com.eiu.vcarpool.dto.Employee rider) {
		Employee provider1 = new Employee();
		Employee rider1 = new Employee();
		provider1 = hibernateTemplate.get(Employee.class,
				provider.getUserName());
		rider1 = hibernateTemplate.get(Employee.class, rider.getUserName());

		List<com.eiu.vcarpool.dto.Inbox> listOfMessagesProvider = provider
				.getEmployeeInbox();
		List<Inbox> messagesListProvider = new ArrayList<Inbox>();

		Iterator<com.eiu.vcarpool.dto.Inbox> iterator = listOfMessagesProvider
				.iterator();
		while (iterator.hasNext()) {
			com.eiu.vcarpool.dto.Inbox inbox = (com.eiu.vcarpool.dto.Inbox) iterator
					.next();
			Inbox inbox1 = new Inbox();
			inbox1.setInboxId(inbox.getInboxId());
			inbox1.setReceiverName(inbox.getReceiverName());
			inbox1.setSenderName(inbox.getSenderName());
			inbox1.setStatus(inbox.getStatus());
			messagesListProvider.add(inbox1);
		}

		System.out.println("provider1.getEmployeeInbox()"
				+ provider.getEmployeeInbox());
		provider1.setEmployeeInbox(messagesListProvider);

		List<com.eiu.vcarpool.dto.Inbox> listOfMessagesRider = rider
				.getEmployeeInbox();
		List<Inbox> messagesListRider = new ArrayList<Inbox>();

		Iterator<com.eiu.vcarpool.dto.Inbox> iterator1 = listOfMessagesRider
				.iterator();
		while (iterator1.hasNext()) {
			com.eiu.vcarpool.dto.Inbox inbox = (com.eiu.vcarpool.dto.Inbox) iterator1
					.next();
			Inbox inbox1 = new Inbox();
			inbox1.setInboxId(inbox.getInboxId());
			inbox1.setReceiverName(inbox.getReceiverName());
			inbox1.setSenderName(inbox.getSenderName());
			inbox1.setStatus(inbox.getStatus());
			messagesListRider.add(inbox1);
		}

		rider1.setEmployeeInbox(messagesListRider);
		hibernateTemplate.saveOrUpdate(provider1);
		hibernateTemplate.saveOrUpdate(rider1);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.eiu.vcarpool.dto.Inbox> retrieveEmployeeInbox(
			String userName) {

		Object[] sqlParams = { userName };
		String queryName = "from Inbox where (receiverName=?)";
		List<Inbox> listOfMessages = hibernateTemplate.find(queryName,
				sqlParams);
		List<com.eiu.vcarpool.dto.Inbox> messagesList = new ArrayList<>();
		Iterator<Inbox> iterator = listOfMessages.iterator();
		while (iterator.hasNext()) {
			Inbox inbox = (Inbox) iterator.next();
			com.eiu.vcarpool.dto.Inbox inbox1 = new com.eiu.vcarpool.dto.Inbox();
			inbox1.setInboxId(inbox.getInboxId());
			inbox1.setReceiverName(inbox.getReceiverName());
			inbox1.setSenderName(inbox.getSenderName());
			inbox1.setStatus(inbox.getStatus());
			messagesList.add(inbox1);
		}

		return messagesList;
	}

	@Override
	public void addRider(com.eiu.vcarpool.dto.Employee provider,
			com.eiu.vcarpool.dto.Employee rider) {

		Employee provider1 = hibernateTemplate.get(Employee.class,
				provider.getUserName());
		Employee rider1 = hibernateTemplate.get(Employee.class,
				rider.getUserName());

		if (provider1.getCarPool().getSeatsAvailable() > 0) {
			provider1.getCarPool().setSeatsAvailable(
					provider1.getCarPool().getSeatsAvailable() - 1);

			provider1.getCarPool().getSetOfRiders().add(rider1);

			List<Inbox> listOfMessages = provider1.getEmployeeInbox();

			Iterator<Inbox> iterator = listOfMessages.iterator();
			while (iterator.hasNext()) {
				Inbox inbox = (Inbox) iterator.next();
				if (inbox.getReceiverName().equals(provider1.getUserName())
						&& inbox.getSenderName().equals(rider.getUserName())) {
					inbox.setStatus("accepted");
				}

			}
			List<Inbox> listOfMessages1 = rider1.getEmployeeInbox();

			Iterator<Inbox> iterator1 = listOfMessages1.iterator();
			while (iterator1.hasNext()) {
				Inbox inbox = (Inbox) iterator1.next();
				if (inbox.getReceiverName().equals(rider1.getUserName())
						&& inbox.getSenderName()
								.equals(provider1.getUserName())) {
					inbox.setStatus("accepted");
				}

			}
			hibernateTemplate.saveOrUpdate(rider1);

			hibernateTemplate.saveOrUpdate(provider1);
		}

	}

	@Override
	public void declineRequest(com.eiu.vcarpool.dto.Employee provider,
			com.eiu.vcarpool.dto.Employee rider) {

		Employee provider1 = hibernateTemplate.get(Employee.class,
				provider.getUserName());
		Employee rider1 = hibernateTemplate.get(Employee.class,
				rider.getUserName());

		List<Inbox> listOfMessages = provider1.getEmployeeInbox();

		Iterator<Inbox> iterator = listOfMessages.iterator();
		while (iterator.hasNext()) {
			Inbox inbox = (Inbox) iterator.next();
			if (inbox.getReceiverName().equals(provider1.getUserName())
					&& inbox.getSenderName().equals(rider.getUserName())) {
				inbox.setStatus("rejected");
			}

		}
		List<Inbox> listOfMessages1 = rider1.getEmployeeInbox();

		Iterator<Inbox> iterator1 = listOfMessages1.iterator();
		while (iterator1.hasNext()) {
			Inbox inbox = (Inbox) iterator1.next();
			if (inbox.getReceiverName().equals(rider1.getUserName())
					&& inbox.getSenderName().equals(provider1.getUserName())) {
				inbox.setStatus("rejected");
			}

		}
		hibernateTemplate.saveOrUpdate(rider1);
		hibernateTemplate.saveOrUpdate(provider1);

	}

}
