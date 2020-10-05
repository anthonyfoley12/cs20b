// Author: Anthony Foley
// Class: CS 20B
// Assignment: Homework 2 Problem 1
// Date: 12 September 2020

import java.util.Stack;

public class HomeworkAssignment2_1 {

	public static void main(String[] args) {
		int[] inputs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		int[] outputs = {3, 2, 1, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 14};
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
	public boolean isSameEventSequence(int[] events_pushed, int[] events_popped) {
		Stack<Integer> temp = new Stack<Integer>();
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