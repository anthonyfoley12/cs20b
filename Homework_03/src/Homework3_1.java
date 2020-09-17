// Author: Anthony Foley
// Class: CS 20B
// Assignment: Homework 3 Problem 1
// Date: 16 September 2020

public class Homework3_1 {

	public static void main(String[] args) {
		Node node = new Node(1);
		Node current = node;
		for(int i = 2; i < 21; i++) {
			current.next = new Node(i);
			current = current.next;
		}

		printList(node);
		Solution sol = new Solution();
		sol.mixList(node);
		printList(node);
	}
	
	public static void printList(Node head) {
		Node node = head;
		while (node.next != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.println(node.val + "->null");
	}

}

class Node {
	int val;
	Node next;
	Node(int x) { val = x; }
}
/*
 * The Solution class implements the following: 
 * mixList(head) -- homogenize singly linked list of head Node.
 * 
 * Un-Homogenized List: L1 -> L2 -> L3 -> ... -> L(n-2) -> L(n-1) -> L(n)
 * Homogenized List: L1 -> L(n) -> L2 -> L(n-1) -> L3 -> L(n-2) -> ...
 */

class Solution {
	public void mixList(Node head) { 
		while(head.next != null && head.next.next != null) {
			Node current = head;
			while(current.next.next != null) {
				current = current.next;
			}
			Node new_end = current;
			current.next.next = head.next;
			head.next = current.next;
			new_end.next = null;
			head = head.next.next;
		}
	}
}