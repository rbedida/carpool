package com.eiu.vcarpool.dto;

import java.util.ArrayList;
import java.util.List;

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

	public int getCarPoolId() {
		return carPoolId;
	}

	public void setCarPoolId(int carPoolId) {
		this.carPoolId = carPoolId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public String getGenderPreference() {
		return genderPreference;
	}

	public void setGenderPreference(String genderPreference) {
		this.genderPreference = genderPreference;
	}

	public String getPoolStatus() {
		return poolStatus;
	}

	public void setPoolStatus(String poolStatus) {
		this.poolStatus = poolStatus;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public List<Employee> getSetOfRiders() {
		return setOfRiders;
	}

	public void setSetOfRiders(List<Employee> setOfRiders) {
		this.setOfRiders = setOfRiders;
	}

}
