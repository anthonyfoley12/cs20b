
//Author: Anthony Foley
//Class: CS 20B
//Assignment: Homework 9 Problem 1
//Date: 16 November 2020

public class HomeworkAssignment9_1 {

	public static void main(String[] args) {
//		Solution sol = new Solution();
//		sol.put(1, 1); 
//		sol.put(2, 3); 
//		System.out.println(sol.get(1)); // returns 1 
//		System.out.println(sol.get(30));// returns -1 (not found) 
//		sol.put(1, 100);  // update the existing value 
//		System.out.println(sol.get(1)); // returns 100 
//		sol.remove(2); // removes the mapping for 2
//		sol.remove(1); // removes the mapping for 1 
//		System.out.println(sol.get(2)); // returns -1 (not found)
//		System.out.println(sol.get(1)); // returns -1 (not found)
	}

}

class Solution {
	// Add any global variables you need here 
	private Integer[] table;
	
	public Solution() { 
		this.table = new Integer[10000];
	} 
	// put(key) - set t
	public void put(int key, int value) { 
		table[key] = value;
	} 
	// YOUR API DOCUMENTATION HERE
	public int get(int key) { 
		return (is_null(key) ? -1 : table[key]);
	} 
	// YOUR API DOCUMENTATION HERE
	public void remove(int key) { 
		table[key] = null;
	}
	
	private boolean is_null(int key) {
		return table[key] == null;
	}
}