import java.util.Stack;

//Author: Anthony Foley
//Class: CS 20B
//Assignment: Homework 5 Problem 1
//Date: 07 October 2020

public class HomeworkAssignment5_1 {

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.add(1);
		sol.add(2);
		sol.add(3);
		System.out.println(sol.remove());
		System.out.println(sol.peek());
		sol.add(4);
		System.out.println(sol.popStack.empty());
		System.out.println(sol.pushStack.empty());
		System.out.println(sol.isEmpty());
	}

}

class Solution {

	// YOUR STACK TO USE FOR THIS PROBLEM
	Stack<Integer> pushStack = new Stack<Integer>();
	Stack<Integer> popStack = new Stack<Integer>();

	// =====================================
	// !!! DO NOT MODIFY ABOVE THIS LINE!!!
	// ====================================

	// add(x) -- adds value to end of queue
	public void add(int x) { 
		while (!popStack.empty()) {
			pushStack.push(popStack.pop());
		}
		pushStack.push(x);
	}
	
	// remove() -- removes and returns value from beginning of queue
	public int remove() { 
		while (!pushStack.empty()) {
			popStack.push(pushStack.pop());
		}
		return popStack.pop();
	}
	
	// peek() -- returns value at beginning of queue
	public int peek() { 
		while (!pushStack.empty()) {
			popStack.push(pushStack.pop());
		}
		return popStack.peek();
	}
	
	// isEmpty() -- tests if queue is empty; returns boolean
	public boolean isEmpty() { 
		return pushStack.empty() && popStack.empty();
	}
}