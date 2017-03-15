package com.eiu.vcarpool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VC_INBOX")
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
 
    /** 
     * @return inboxId 
     */ 
    @Id 
    @GeneratedValue 
    @Column(name = "INBOX_ID") 
    public final int getInboxId() { 
        return inboxId; 
    } 
 
    /** 
     * @param pInboxId 
     *            the inboxId to set 
     */ 
    public final void setInboxId(final int pInboxId) { 
        this.inboxId = pInboxId; 
    } 
 
    /** 
     * @return senderName 
     */ 
    @Column(name = "SENDER_NAME", nullable = false) 
    public final String getSenderName() { 
        return senderName; 
    } 
 
    /** 
     * @param pSenderName 
     *            the senderName to set 
     */ 
    public final void setSenderName(final String pSenderName) { 
        this.senderName = pSenderName; 
    } 
 
    /** 
     * @return receiverName 
     */ 
    @Column(name = "RECEIVER_NAME", nullable = false) 
    public final String getReceiverName() { 
        return receiverName; 
    } 
 
    /** 
     * @param pReceiverName 
     *            the receiverName to set 
     */ 
    public final void setReceiverName(final String pReceiverName) { 
        this.receiverName = pReceiverName; 
    } 
 
    /** 
     * @return status 
     */ 
    @Column(name = "STATUS", nullable = false) 
    public final String getStatus() { 
        return status; 
    } 
 
    /** 
     * @param pStatus 
     *            the status to set 
     */ 
    public final void setStatus(final String pStatus) { 
        this.status = pStatus; 
    }  

}
