package com.eiu.vcarpool.dto;

public class Inbox {

	/**
	 * The auto-generated id for Inbox Table.
	 */
	private int inboxId;

	/**
	 * Sender of the message.
	 */
	private String senderName;

	/**
	 * Receiver of the message.
	 */
	private String receiverName;

	/**
	 * Status of the message in the Inbox. It can be either pending or accepted
	 * or declined.
	 */
	private String status;

	public int getInboxId() {
		return inboxId;
	}

	public void setInboxId(int inboxId) {
		this.inboxId = inboxId;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
