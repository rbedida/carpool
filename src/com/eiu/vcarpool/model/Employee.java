
 package com.eiu.vcarpool.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;



@Entity
@Table(name = "VC_EMPLOYEE")
public class Employee {

	/** 
     * The name of the Employee. The name should contain 25 characters. 
     */ 
    @Column(name = "EMPLOYEE_NAME") 
     
    private String employeeName; 
 
    /** 
     * The user name of the Employee. The userName should be of minimum 1 
     * character and maximum 10 characters. 
     */ 
    private String userName; 
 
    /** 
     * Password for an Employee VCarpooling account. Password should contain at 
     * least one digit, an alphabet and length 4-8 characters. 
     */ 
    @Column(name = "PASSWORD") 
     
    private String password; 
 
    
    /** 
     * The gender of an Employee. 
     */ 
    @Column(name = "GENDER") 
     
    private String gender; 
 
    /** 
     * Age of an Employee. It cannot be null. 
     */ 
    @Column(name = "AGE") 
     
    private String age; 
 
    /** 
     * PhoneNumber of an Employee. 
     */ 
    @Column(name = "PHONE_NUMBER") 
     
    private String phoneNumber; 
 
    /** 
     * Email-Id of an Employee. 
     */ 
    @Column(name = "EMAIL_ID") 
     
    private String emailId; 
 
    /** 
     * Member of type CarPool. An Employee is part of CarPool. 
     */ 
    private CarPool carPool; 
 
    /** 
     * Status of an Employee - Activate(A), Deactivate(D). 
     */ 
    @Column(name = "EMP_STATUS") 
 
    private String empStatus; 
 
    /** 
     * The inbox of an Employee contains a list of messages. 
     */ 
    private List<Inbox> employeeInbox = new ArrayList<Inbox>(); 
 
    /** 
     * @return employeeName 
     */ 
    public final String getEmployeeName() { 
        return employeeName; 
    } 
 
    /** 
     * @param pEmployeeName 
     *            the employeeName to set 
     */ 
    public final void setEmployeeName(final String pEmployeeName) { 
        this.employeeName = pEmployeeName; 
    } 
 
    /** 
     * @return userName 
     */ 
    @Id 
    @Column(name = "USER_NAME") 
     
    public final String getUserName() { 
        return userName; 
    } 
 
    /** 
     * @param pUserName 
     *            the userName to set 
     */ 
    public final void setUserName(final String pUserName) { 
        this.userName = pUserName; 
    } 
 
    /** 
     * @return password 
     */ 
    public final String getPassword() { 
        return password; 
    } 
 
    /** 
     * @param pPassword 
     *            the password to set 
     */ 
    public final void setPassword(final String pPassword) { 
        this.password = pPassword; 
    } 
 
    /** 
     * @return gender 
     */ 
    public final String getGender() { 
        return gender; 
    } 
 
    /** 
     * @param pGender 
     *            the gender to set 
     */ 
    public final void setGender(final String pGender) { 
        this.gender = pGender; 
    } 
 
    /** 
     * @return age 
     */ 
    public final String getAge() { 
        return age; 
    } 
 
    /** 
     * @param pAge 
     *            the age to set 
     */ 
    public final void setAge(final String pAge) { 
        this.age = pAge; 
    } 
 
    /** 
     * @return phoneNumber 
     */ 
    public final String getPhoneNumber() { 
        return phoneNumber; 
    } 
 
    /** 
     * @param pPhoneNumber 
     *            the phoneNumber to set 
     */ 
    public final void setPhoneNumber(final String pPhoneNumber) { 
        this.phoneNumber = pPhoneNumber; 
    } 
 
    /** 
     * @return emailId 
     */ 
    public final String getEmailId() { 
        return emailId; 
    } 
 
    /** 
     * @param pEmailId 
     *            the emailId to set 
     */ 
    public final void setEmailId(final String pEmailId) { 
        this.emailId = pEmailId; 
    } 
 
    /** 
     * @return carPool 
     */ 
    @OneToOne(cascade = CascadeType.ALL) 
    public final CarPool getCarPool() { 
        return carPool; 
    } 
 
    /** 
     * @param pCarPool 
     *            the carPool to set 
     */ 
    public final void setCarPool(final CarPool pCarPool) { 
        this.carPool = pCarPool; 
    } 
 
    /** 
     * @return empStatus 
     */ 
    public final String getEmpStatus() { 
        return empStatus; 
    } 
 
    /** 
     * @param pEmpStatus 
     *            the empStatus to set 
     */ 
    public final void setEmpStatus(final String pEmpStatus) { 
        this.empStatus = pEmpStatus; 
    } 
 
    /** 
     * Shows one-to-many mapping between an Employee and an Inbox. An Employee 
     * can have multiple messages in the inbox. The one-to-many mapping results 
     * in an intermediate table called Employee_Inbox. It depicts which message 
     * has been sent by which employee. 
     *  
     * @return employeeInbox 
     */ 
    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "VC_EMPLOYEE_INBOX", joinColumns = { @JoinColumn(name = "userName") }, inverseJoinColumns = { @JoinColumn(name = "inboxId") }) 
    public final List<Inbox> getEmployeeInbox() { 
        return employeeInbox; 
    } 
 
    /** 
     * @param pEmployeeInbox 
     *            the employeeInbox to set 
     */ 
    public final void setEmployeeInbox(final List<Inbox> pEmployeeInbox) { 
        this.employeeInbox = pEmployeeInbox; 
    }  

}
