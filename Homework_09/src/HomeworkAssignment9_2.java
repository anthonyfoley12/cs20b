
//Author: Anthony Foley
//Class: CS 20B
//Assignment: Homework 9 Problem 1
//Date: 16 November 2020

import java.util.*;

public class HomeworkAssignment9_2 {

	public static void main(String[] args) {
//		Solution2 sol = new Solution2();
//		sol.put("app", 100); 
//		System.out.println(sol.getSum("ap"));	// returns 100 as "ap" is a prefix  to "app"
//		sol.put("ap", 1);
//		System.out.println(sol.getSum("a"));	// returns 101 as "a" is a prefix to both keys in map
//		System.out.println(sol.getSum("xyz"));	// returns 0 as "xyz" is not a prefix to any keys in map 
//		sol.put("app", 8);	// replaces the value of the existing key "app" from 100 to 8
//		System.out.println(sol.getSum("ap"));	// returns 9 as "ap" is a prefix to both keys in map 
	}

}

class Solution {
	// Add any global variables you need here
	private TreeMap<String, Integer> map;
	
	public Solution() { 
		this.map = new TreeMap<String, Integer>();
	} 
	// put(key, value - Add Key, Value pair to 
	public void put(String key, int value) { 
		map.put(key, value);
	} 
	// YOUR API DOCUMENTATION HERE
	public int getSum(String key) { 
		int total = 0;
		SortedMap<String, Integer> temp = map.subMap(key, key + Character.MAX_VALUE);
		for (Integer val : temp.values()) {
			total += val;
		}
		return total;
	} 
}