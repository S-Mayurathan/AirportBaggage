/**
* Dev space by Mayu... 
**/
package com.business;

import java.util.List;

import com.entity.DirectedEdge;

public interface SortestPath {
	
	 public String findShortestPath(String entry,String dest, List<DirectedEdge> graphEdges);
}
