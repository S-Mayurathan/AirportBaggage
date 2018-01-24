/**
* Dev space by Mayu... 
**/
package com.business;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.entity.DirectedEdge;
import com.entity.Node;

public class SortestPathImpl implements SortestPath {

	private final static String SINGLE_WHITE_SPACE = " ";

	Map<String, SortestPathGraphMap> visitedMap = new ConcurrentHashMap<>();

	@Override
	public String findShortestPath(String entry, String dest, List<DirectedEdge> graphEdges) {
		SortestPathGraphMap dijkstraGraphMap;
		if (visitedMap.containsKey(entry)) {
			dijkstraGraphMap = visitedMap.get(entry);
		} else {
			dijkstraGraphMap = new SortestPathGraphMap(graphEdges);
			dijkstraGraphMap.dijkstra(entry);
			visitedMap.put(entry, dijkstraGraphMap);
		}
		List<Node> shortestPath = dijkstraGraphMap.getShortestPath(dest);
		return generatePathLine(shortestPath);
	}

	private String generatePathLine(List<Node> path) {
		StringBuffer line = new StringBuffer();

		for (Node vertex : path) {
			line.append(vertex.getName()).append(SINGLE_WHITE_SPACE);
		}
		line.append(": ").append(path.get(path.size() - 1).getTime());
		return line.toString();
	}
}
