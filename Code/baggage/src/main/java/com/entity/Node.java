/**
* Dev space by Mayu... 
**/
package com.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node implements Comparable<Node> {

	private String name;
	private int time = Integer.MAX_VALUE;
	private Node prevVertext = null;
	private final Map<Node, Integer> neighbours = new HashMap<>();

	
	
	/**
	 * @param name
	 */
	public Node(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the time
	 */
	public int getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * @return the prevVertext
	 */
	public Node getPrevVertext() {
		return prevVertext;
	}

	/**
	 * @param prevVertext
	 *            the prevVertext to set
	 */
	public void setPrevVertext(Node prevVertext) {
		this.prevVertext = prevVertext;
	}

	/**
	 * @return the neighbours
	 */
	public Map<Node, Integer> getNeighbours() {
		return neighbours;
	}

	public int compareTo(Node o) {
		if (time == o.time)
			return name.compareTo(o.name);
		return Integer.compare(time, o.time);
	}

	 public List<Node> getShortestPathTo()
	    {
	        List<Node> path = new ArrayList();
	        path.add(this);
	        Node vertex=this.getPrevVertext();
	        while (vertex!=null && !path.contains(vertex)) {
	            path.add(vertex);
	            vertex=vertex.getPrevVertext();
	        }

	        Collections.reverse(path);
	        return path;
	    }
	 
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return  name + ":" + time;
	}

	
	
}
