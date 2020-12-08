import java.util.*;

//Author: Anthony Foley
//Class: CS 20B
//Assignment: Homework 11 Problem 2
//Date: 2 December 2020

public class HomeworkAssignment11_2 {

	public static void main(String[] args) {
//		Solution sol = new Solution();
//		ArrayList<List<String>> routes = new ArrayList<List<String>>();
//		System.out.println(sol.getDestination(routes));
//		
//		routes.clear();
//		routes.add(Arrays.asList("A"));
//		System.out.println(sol.getDestination(routes)); //=="A");
//		
//		routes.clear();		
//		routes.add(Arrays.asList("A", "B"));
//		routes.add(Arrays.asList("B", "C"));
//		routes.add(Arrays.asList("C", "D"));
//		System.out.println(sol.getDestination(routes)); // D
//		
//		routes.clear();
//		routes.add(Arrays.asList("C", "D"));
//		routes.add(Arrays.asList("D", "A"));
//		routes.add(Arrays.asList("A", "B"));
//		System.out.println(sol.getDestination(routes)); // B
	}

}

/*
 * The Solution class implements the following
 * getDestination(routes) - returns the sink node of a singly
 * 							directed graph.
 */
class Solution {
	// GLOBALS
	private boolean matrix[][];
	private int nodes;
	
	public String getDestination(List<List<String>> routes) {
		nodes = get_nodes(routes);
		if (!is_empty(routes)) {
			if (nodes == 1) {
				return routes.get(0).get(0);
			}
			init_matrix(nodes);
			set_matrix(routes);
			String sink = get_sink();
			return sink;
		}
		return null;		
	}
	
	//Helper methods
	private String get_sink() {
		int candidate = 0;
		for (int i = 0; i < nodes; i++) {
			if (matrix[candidate][i]) {
				candidate = i;
			}
		}
		String sink = Character.toString((char)(candidate + 65));
		return sink;
	}	
	
	private void add_edge(List<String> pair) {
		int row = get_index(get_char(pair.get(0)));
		int column = get_index(get_char(pair.get(1)));
		matrix[row][column] = true;
	}
	private char get_char(String s) {
		return s.charAt(0);
	}
	private int get_index(int idx) {
		return idx - 65; // 'A' = 65
	}
	private void init_matrix(int nodes) {
		matrix = new boolean[nodes][nodes];
	}
	private void set_matrix(List<List<String>> routes) {
		for (List<String> pair : routes) {
			add_edge(pair);
		}
	}
	private boolean is_empty(List<List<String>> routes) {
		return routes.size() == 0;
	}
	private int get_nodes(List<List<String>> routes) {
		if (is_one_node(routes)) {
			return 1;
		}
		return routes.size() + 1;
	}
	private boolean is_one_node(List<List<String>> routes) {
		if (routes.size() == 1) {
			return routes.get(0).size() == 1;
		}
		return false;
	}
}