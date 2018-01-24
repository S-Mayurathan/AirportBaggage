/**
* Dev space by Mayu... 
**/
package com.business;

public class AlgorithmsFactory {

	public static SortestPath createDijkstraSortestPathAlgorithm(){
        return new SortestPathImpl();
    }
}
