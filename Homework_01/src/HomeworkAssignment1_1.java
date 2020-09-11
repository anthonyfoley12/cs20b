

import java.util.Stack;

public class HomeworkAssignment1_1 {

	public static void main(String[] args) {
	
	}
}

/*
* The MaxStack program implements a Stack class with the following features:
* push(x) -- push element x onto stack
* pop() -- remove the element on top of the stack
* top() -- get the top element.
* getMax() -- retrieve the max element in the stack in constant time (i.e., O(1))
*/
class MaxStack {
	// Stacks to hold Max Values and all values
	private Stack<Integer> maxStack;
	private Stack<Integer> mainStack;
	
	public MaxStack() {
		this.maxStack = new Stack<Integer>();
		this.mainStack = new Stack<Integer>();
	}

	public void push(int data) {
		mainStack.push(data);
		// Push to max stack if values is >= current max value
		if(maxStack.empty() || data >= maxStack.peek()) {
			maxStack.push(data);
		}
	}
	public void pop() {
		if(!mainStack.empty()) {
			if(mainStack.peek() == maxStack.peek()) {
				maxStack.pop();
			}
			mainStack.pop();
		}
	}
	public int top() {
		return mainStack.peek();
	}
	public int getMax() {
		return maxStack.peek();
	}
}