

import java.util.Stack;

public class HomeworkAssignment1_2 {

	public static void main(String[] args) {
		
	}
}

/*
* The MinStack program implements a Stack class with the following features:
* push(x) -- push element x onto stack
* pop() -- remove the element on top of the stack
* top() -- get the top element.
* getMin() -- retrieve the min element in the stack in constant time (i.e., O(1))
*/
class MinStack {
	// Stacks to hold Min Values and All values
	private Stack<Integer> minStack;
	private Stack<Integer> mainStack;
	
	public MinStack() {
		this.minStack = new Stack<Integer>();
		this.mainStack = new Stack<Integer>();
	}

	public void push(int data) {
		mainStack.push(data);
		// Push to max stack if values is >= current max value
		if(minStack.empty() || data <= minStack.peek()) {
			minStack.push(data);
		}
	}
	public void pop() {
		if(!mainStack.empty()) {
			if(mainStack.peek() == minStack.peek()) {
				minStack.pop();
			}
			mainStack.pop();
		}
	}
	public int top() {
		return mainStack.peek();		
	}
	public int getMin() {
		return minStack.peek();
	}
}