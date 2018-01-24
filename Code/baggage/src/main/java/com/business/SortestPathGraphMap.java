/**
* Dev space by Mayu... 
**/
package com.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

import com.entity.DirectedEdge;
import com.entity.Node;
import com.exceptions.AppException;

/**
 * Implementing dijkstra algorithm for finding shortest path
 * 
 * @author mayu
 *
 */
public class SortestPathGraphMap {

	private Map<String, Node> graphMap;

	/**
	 * @param graphMap
	 */
	public SortestPathGraphMap(List<DirectedEdge> directedEdges) {
		graphMap = new HashMap<>();

		// Populated all the vertices from the edges
		for (DirectedEdge e : directedEdges) {
			if (!graphMap.containsKey(e.getSource().getName()))
				graphMap.put(e.getSource().getName(), new Node(e.getSource().getName()));
			if (!graphMap.containsKey(e.getDestination().getName()))
				graphMap.put(e.getDestination().getName(), new Node(e.getDestination().getName()));
		}

		// Set all the nearest
		for (DirectedEdge e : directedEdges) {
			graphMap.get(e.getSource().getName()).getNeighbours().put(graphMap.get(e.getDestination().getName()),
					e.getTime());
		}
	}

	/**
	 * Runs dijkstra algorithm using a specified source node. Every time when
	 * the starting Node get changed, this algorithm should get run.
	 * 
	 * @param startName
	 *            the starting or source Node for the path
	 */
	public void dijkstra(String startName) {
		if (!graphMap.containsKey(startName)) {
			throw new AppException("This SortestPathGraphMap does not contain the starting Node named:" + startName);
		}
		final Node source = graphMap.get(startName);
		NavigableSet<Node> queue = new TreeSet<>();

		// populate vertices to the queue
		for (Node v : graphMap.values()) {
			v.setPrevVertext(v == source ? source : null);
			v.setTime(v == source ? 0 : Integer.MAX_VALUE);
			queue.add(v);
		}

		dijkstra(queue);
	}

	/**
	 * This method implementation of dijkstra's algorithm using a binary heap.
	 * 
	 * @param que
	 */
	private void dijkstra(final NavigableSet<Node> que) {
		Node source, neighbour;
		while (!que.isEmpty()) {
			source = que.pollFirst();
			if (source.getTime() == Integer.MAX_VALUE)
				break;

			for (Map.Entry<Node, Integer> a : source.getNeighbours().entrySet()) {
				neighbour = a.getKey();

				final int alternateTime = source.getTime() + a.getValue();
				if (alternateTime < neighbour.getTime()) {
					que.remove(neighbour);
					neighbour.setTime(alternateTime);
					neighbour.setPrevVertext(source);
					que.add(neighbour);
				}
			}
		}
	}

	/**
	 * Get the shortest path as a list of Node for a specific destination
	 * Node with name as endName
	 * 
	 * @param endName
	 *            the destination Node name
	 * @return the shortest path as a List<Node>
	 */

	public List<Node> getShortestPath(String endName) {
		if (!graphMap.containsKey(endName)) {
			throw new AppException("Graph doesn't contain end vertex : " + endName);
		}

		return graphMap.get(endName).getShortestPathTo();
	}
}
