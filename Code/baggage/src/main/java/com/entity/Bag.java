/**
* Dev space by Mayu... 
**/
package com.entity;

public class Bag {

	private String bagNumber;
	private String entryPoint;
	private String flightId;

	
	
	/**
	 * @param bagNumber
	 * @param entryPoint
	 * @param flightId
	 */
	public Bag(String bagNumber, String entryPoint, String flightId) {
		super();
		this.bagNumber = bagNumber;
		this.entryPoint = entryPoint;
		this.flightId = flightId;
	}

	/**
	 * @return the bagNumber
	 */
	public String getBagNumber() {
		return bagNumber;
	}

	/**
	 * @param bagNumber
	 *            the bagNumber to set
	 */
	public void setBagNumber(String bagNumber) {
		this.bagNumber = bagNumber;
	}

	/**
	 * @return the entryPoint
	 */
	public String getEntryPoint() {
		return entryPoint;
	}

	/**
	 * @param entryPoint
	 *            the entryPoint to set
	 */
	public void setEntryPoint(String entryPoint) {
		this.entryPoint = entryPoint;
	}

	/**
	 * @return the flightId
	 */
	public String getFlightId() {
		return flightId;
	}

	/**
	 * @param flightId
	 *            the flightId to set
	 */
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

}
