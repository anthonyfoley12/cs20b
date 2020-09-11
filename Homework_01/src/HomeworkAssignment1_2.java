

import java.util.Stack;

public class HomeworkAssignment1_2 {

	public static void main(String[] args) {
		TestMin();
	}

	public static void TestMin() {
		MinStack myStack = new MinStack();
		int min;
		int top;
		int popped;
		int[] intArray = { 0, -2, -5, -3, -5, -1, -8, -6, -4 };
		for (int i = 0; i < intArray.length; i++) {
			myStack.push(intArray[i]);
			min = myStack.getMin();
			top = myStack.top();
			System.out.println("Top value: " + top + " | Max value: " + min);
		}
		for (int i = 0; i < intArray.length; i++) {
			popped = myStack.top();
			myStack.pop();
			min = myStack.getMin();
			top = myStack.top();
			System.out.println("Top value: " + top + " | Max value: " + min + " Popped value: " + popped);
		}
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