// Author: Anthony Foley
// Class: CS 20B
// Assignment: Homework 2 Problem 1
// Date: 12 September 2020

import java.util.Stack;

public class HomeworkAssignment2_1 {

	public static void main(String[] args) {
		int[] inputs = {5, 1, 2, 3, 4};
		int[] outputs = {2, 1, 3, 5, 4};
		Solution sol = new Solution();
		System.out.println(sol.isSameEventSequence(inputs,  outputs));
	}

}

/*
* The Solution class implements the following features:
* isSameEventSequence(int[] events_pushed, int[] events_popped)
*     compare two event sequences (events_pushed, events_popped),
*     return boolean of sequence validity.
*/
class Solution {
	// Tracking Input Stack
	private Stack<Integer> temp;
	
	public Solution() {
		this.temp = new Stack<Integer>();
	}
	
	public boolean isSameEventSequence(int[] events_pushed, int[] events_popped) {
		int popped_index = 0;
		for(int i = 0; i < events_pushed.length; i++) {
			temp.push(events_pushed[i]);
			
			while(!temp.empty() && temp.peek() == events_popped[popped_index]) {
				temp.pop();
				popped_index++;
			}
		}
		return temp.empty();
	}
}