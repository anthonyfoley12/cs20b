
//Author: Anthony Foley
//Class: CS 20B
//Assignment: Homework 11 Problem 1
//Date: 2 December 2020

public class HomeworkAssignment11_1 {

	public static void main(String[] args) {
//		Solution sol = new Solution();
//		
//		Node empty = null;
//		System.out.println(sol.hasCycle(empty));
//		
//		Node single = new Node("single");
//		System.out.println(sol.hasCycle(single));
//		
//		Node a = new Node("a");
//		Node b = new Node("b");
//		Node c = new Node("c"); 
//		// let's create a cycle with c -> b
//		a.next = b;
//		a.next.next = c;
//		c.next = b;
//		System.out.println(sol.hasCycle(a)); // true
//		
//		Node d = new Node("a");
//		Node e = new Node("b");
//		Node f = new Node("c"); 
//		// d -> e -> f -> null
//		d.next = e;
//		e.next = f;
//		System.out.println(sol.hasCycle(d)); // false

	}

}

class Node {
	String label;
	Node next;
	public Node(String label) {
		this.label = label;
	}
	public String toString() {return label;}
}

/*
 * The solution class implements the following:
 * hasCycle(Node) - detects if a cycle exists in a linked
 *                  list and returns boolean of the result.
 */
class Solution {
	public boolean hasCycle(Node head) {
		// YOUR CODE HERE 
		Node slow = head;
		Node fast = head;
		while (slow != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
		
	}
}