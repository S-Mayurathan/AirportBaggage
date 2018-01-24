/**
* Dev space by Mayu... 
**/
package com.entity;

public class DirectedEdge {

	private Node source;
	private Node destination;
	private int time;
	

	
	/**
	 * @param source
	 * @param destination
	 * @param time
	 */
	public DirectedEdge(Node source, Node destination, Integer time) {
		super();
		this.source = source;
		this.destination = destination;
		this.time = time;
	}
	/**
	 * 
	 * @param sourceName
	 * @param destinationName
	 * @param time
	 */
	public DirectedEdge(String sourceName, String destinationName, Integer time) {
        this.source = new Node(sourceName);
        this.destination = new Node(destinationName);
        this.time = time;
    }
	/**
	 * @return the time
	 */
	public int getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(int time) {
		this.time = time;
	}
	/**
	 * @return the source
	 */
	public Node getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(Node source) {
		this.source = source;
	}
	/**
	 * @return the destination
	 */
	public Node getDestination() {
		return destination;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(Node destination) {
		this.destination = destination;
	}


}
