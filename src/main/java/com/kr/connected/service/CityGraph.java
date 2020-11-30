package com.kr.connected.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

import org.springframework.stereotype.Component;

import com.kr.connected.model.CityEdge;

/**
 * Directed Graph in the form of Adjacency List of the connections of the cities.
 */
@Component
public class CityGraph {
	// store the vertices in a map for improved load and processing time.
	private final Map<String, Integer> vertices;
	final ArrayList<ArrayList<String>> adjList;
	private Integer index;
	public CityGraph() {
		this.vertices = new LinkedHashMap<>();
		this.index =0;
		this.adjList = new ArrayList<>();
	}
	/*
	 * Creating vertex of unique value/index
	 * create a list of blank edges/connection
	 */
	public void addVertex(String info) {
		vertices.putIfAbsent(info,index++);
		adjList.add(new ArrayList<>());
	}
	/**
	 * Add Edges to directed graph in the form of adjacency List .
	 * @param from
	 * @param to
	 */
	public void addEdge(String origin,String dest) {
		CityEdge edge = new CityEdge(origin,dest);
		if(vertices.get(edge.getOriginCity()) != null) {
			int a = vertices.get(edge.getOriginCity());
			adjList.get(a).add(edge.getDestCity());
		}
	}
	/**
	 * Traverse the graph to find the vertex.
	 * Set the 
	 * @param edge
	 * @return
	 */
	public  String traverseNode(final CityEdge edge) {
		Stack<String> destination = new Stack<>();
		destination.add(edge.getOriginCity());
		String isFindConneton = "no" ;
		while(!destination.isEmpty()) {
			int  index = 0;
			String element = destination.pop();
			if(vertices.get(element) != null) {
				index = vertices.get(element);
			}else {
				destination.clear();
				continue;
			}
			for(String searchNode : adjList.get(index)) {
				destination.add(searchNode);
				if(edge.getDestCity().equalsIgnoreCase(searchNode)) {
					isFindConneton = "yes"; 
					destination.clear();
					break;
				}
			}

		}
		return isFindConneton;
	}

}
