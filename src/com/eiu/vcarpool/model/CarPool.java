package com.eiu.vcarpool.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "VC_CARPOOL")
public class CarPool {
    
 
    /** 
     * The auto-generated id for CARPOOL table. 
     */ 
    private int carPoolId; 
 
    /** 
     * The name of the provider of a pool. 
     */ 
    private String providerName; 
 
    /** 
     * The route for a pool. It contains various hops between the source and 
     * destination. 
     */ 
    private String route; 
 
    /** 
     * The start time for any CarPool. 
     */ 
    private String startTime; 
 
    /** 
     * The return time for any CarPool. 
     */ 
    private String returnTime; 
 
    /** 
     * Number of seats available in a Car(used for pooling). 
     */ 
    private int seatsAvailable; 
 
    /** 
     * The allowed gender specified by the provider in his car(used for 
     * pooling). It can be either Male,Female or both 
     */ 
    private String genderPreference; 
 
    /** 
     * The status of a provider's pool. It can be active or inactive. 
     */ 
    private String poolStatus; 
 
    /** 
     * The start point for a car(used for pooling). 
     */ 
    private String source; 
 
    /** 
     * The destination point for the car(used for pooling). 
     */ 
    private String destination; 
 
    /** 
     * The Model and Make of the car.Example: WagonR LXI. 
     */ 
    private String carModel; 
 
    /** 
     * The set of riders enrolled for a particular pool. 
     */ 
    private List<Employee> setOfRiders = new ArrayList<Employee>(); 
 
    /** 
     * @return the carPoolId 
     */ 
    @Id 
    @GeneratedValue 
    @Column(name = "CARPOOL_ID") 
    public final int getCarPoolId() { 
        return carPoolId; 
    } 
 
    /** 
     * @param pCarPoolId 
     *            the carPoolId to set 
     */ 
    public final void setCarPoolId(final int pCarPoolId) { 
        this.carPoolId = pCarPoolId; 
    } 
 
    /** 
     * @return the providerName 
     */ 
    @Column(name = "CARPOOL_PROVIDERNAME") 
    public final String getProviderName() { 
        return providerName; 
    } 
 
    /** 
     * @param pProviderName 
     *            the providerName to set 
     */ 
    public final void setProviderName(final String pProviderName) { 
        this.providerName = pProviderName; 
    } 
 
    /** 
     * @return the route 
     */ 
    @Column(name = "POOL_ROUTE") 
    public final String getRoute() { 
        return route; 
    } 
 
    /** 
     * @param pRoute 
     *            the route to set 
     */ 
    public final void setRoute(final String pRoute) { 
        this.route = pRoute; 
    } 
 
    /** 
     * @return startTime 
     */ 
    @Column(name = "START_TIME") 
    public final String getStartTime() { 
        return startTime; 
    } 
 
    /** 
     * @param pStartTime 
     *            the startTime to set 
     */ 
    public final void setStartTime(final String pStartTime) { 
        this.startTime = pStartTime; 
    } 
 
    /** 
     * @return returnTime 
     */ 
    @Column(name = "RETURN_TIME") 
    public final String getReturnTime() { 
        return returnTime; 
    } 
 
    /** 
     * @param pReturnTime 
     *            the returnTime to set 
     */ 
    public final void setReturnTime(final String pReturnTime) { 
        this.returnTime = pReturnTime; 
    } 
 
    /** 
     * @return seatsAvailable 
     */ 
    @Column(name = "SEATS_AVAILABLE") 
    public final int getSeatsAvailable() { 
        return seatsAvailable; 
    } 
 
    /** 
     * @param pSeatsAvailable 
     *            the seatsAvailable to set 
     */ 
    public final void setSeatsAvailable(final int pSeatsAvailable) { 
        this.seatsAvailable = pSeatsAvailable; 
    } 
 
    /** 
     * @return genderPreference 
     */ 
    @Column(name = "GENDER_PREFERENCE") 
    public final String getGenderPreference() { 
        return genderPreference; 
    } 
 
    /** 
     * @param pGenderPreference 
     *            the genderPreference to set 
     */ 
    public final void setGenderPreference(final String pGenderPreference) { 
        this.genderPreference = pGenderPreference; 
    } 
 
    /** 
     * @return poolStatus 
     */ 
    @Column(name = "POOL_STATUS") 
    public final String getPoolStatus() { 
        return poolStatus; 
    } 
 
    /** 
     * @param pPoolStatus 
     *            the poolStatus to set 
     */ 
    public final void setPoolStatus(final String pPoolStatus) { 
        this.poolStatus = pPoolStatus; 
    } 
 
    /** 
     * @return the source 
     */ 
    @Column(name = "SOURCE") 
    public final String getSource() { 
        return source; 
    } 
 
    /** 
     * @param pSource 
     *            the source to set 
     */ 
    public final void setSource(final String pSource) { 
        this.source = pSource; 
    } 
 
    /** 
     * @return destination 
     */ 
    @Column(name = "DESTINATION") 
    public final String getDestination() { 
        return destination; 
    } 
 
    /** 
     * @param pDestination 
     *            the destination to set 
     */ 
    public final void setDestination(final String pDestination) { 
        this.destination = pDestination; 
    } 
 
    /** 
     * @return the carModel 
     */ 
    @Column(name = "CAR_MODEL") 
    public final String getCarModel() { 
        return carModel; 
    } 
 
    /** 
     * @param pCarModel 
     *            the carModel to set 
     */ 
    public final void setCarModel(final String pCarModel) { 
        this.carModel = pCarModel; 
    } 
 
    /** 
     * Shows the one-to-many mapping between a CarPool and a Rider. A CarPool 
     * can contain many riders. The one-to-many mapping between CarPool and 
     * Rider results in an intermediate table. This table depicts which rider 
     * belongs to which CarPool. 
     *  
     * @return the setOfRiders 
     */ 
    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "VC_CARPOOL_RIDER", joinColumns = { @JoinColumn(name = "CARPOOL_ID") }, inverseJoinColumns = { @JoinColumn(name = "USER_NAME") }) 
    public final List<Employee> getSetOfRiders() { 
        return setOfRiders; 
    } 
 
    /** 
     * @param pSetOfRiders 
     *            the setOfRiders to set 
     */ 
    public final void setSetOfRiders(final List<Employee> pSetOfRiders) { 
        this.setOfRiders = pSetOfRiders; 
    }  
}