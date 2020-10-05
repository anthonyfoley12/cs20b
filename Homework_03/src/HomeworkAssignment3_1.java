// Author: Anthony Foley
// Class: CS 20B
// Assignment: Homework 3 Problem 1
// Date: 16 September 2020

public class HomeworkAssignment3_1 {

	public static void main(String[] args) {
		Node node = new Node(1);
		Node current = node;
		for(int i = 2; i < 21; i++) {
			current.next = new Node(i);
			current = current.next;
		}
		
		Node node2 = new Node(20);
		Node current2 = node2;
		for(int i = 19; i > 0; i--) {
			current2.next = new Node(i);
			current2 = current2.next;
		}

		
		Solution sol = new Solution();
		printList(node);
		sol.mixList(node);
		printList(node);
		
		printList(node2);
		sol.mixList(node2);
		printList(node2);
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
 * mixList(head) -- homogenize singly linked list of Node head.
 * 
 * Un-Homogenized List: L1 -> L2 -> L3 -> ... -> L(n-2) -> L(n-1) -> L(n)
 * Homogenized List: L1 -> L(n) -> L2 -> L(n-1) -> L3 -> L(n-2) -> ...
 */

class Solution {
	public void mixList(Node head) { 
		while(head.next != null && head.next.next != null) {
			Node current = head;
			// Go to second last node
			while(current.next.next != null) {
				current = current.next;
			}
			Node new_end = current;
			current.next.next = head.next; // point last node to current third node - last becomes new second
			head.next = current.next;      // point head node to new second node
			new_end.next = null;           // make new end node - otherwise loop in linked list
			head = head.next.next;
		}
	}
}