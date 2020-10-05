import java.util.Stack;

// Author: Anthony Foley
// Class: CS 20B
// Assignment: Homework 4 Problem 1
// Date: 02 October 2020

public class HomeworkAssignment4_1 {

	public static void main(String[] args) {
		// just like any problems, whatever you need here, etc. For example:
		Solution sol = new Solution();
		System.out.println(sol.postfix("4 55 + 62 23 - *"));

	}
}

/*
 * The Solution class implements the following: 
 * postfix(equation) -- returns postfix evaluation of passed equation
 * 
 * Operands are pushed onto local stack. When 
 */

class Solution {
	public int postfix(String equation) { 
		String delims = "[ ]+";
		String[] items = equation.split(delims);
		Stack <Integer> operands = new Stack<Integer>();
		int operand1;
		int operand2;
		
		for (String item : items) {
			if (item.matches("[+-/%\\*]")) {
				operand2 = operands.pop();
				operand1 = operands.pop();
				switch (item) { 
					case "+":
						operands.push( operand1 + operand2 );
						break;
					case "-":
						operands.push( operand1 - operand2 );
						break;
					case "*":
						operands.push( operand1 * operand2 );
						break;
					case "/":
						operands.push( operand1 / operand2 );
						break;
					case "%":
						operands.push( operand1 % operand2 );
						break;
					default:
						break;
				}
			}
			else operands.push(Integer.valueOf(item));
		}
		return operands.pop();
	}
}
