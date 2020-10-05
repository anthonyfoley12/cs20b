// Author: Anthony Foley
// Class: CS 20B
// Assignment: Lab #2
// Date: 17 September 2020

public class LabAssignment2 {

	public static void main(String[] args) {
		Node node = new Node(1);
		Node current = node;
		for(int i = 2; i < 21; i++) {
			current.next = new Node(i);
			current = current.next;
		}
		Solution sol = new Solution();
		sol.printList(node);
	}

}

class Node {
    int val;
    Node next;
    Node(int x) { val = x; }
}

/* 
 * The Solution class implements the following:
 * printList() -- prints values of a linked list concatenated with '->'
 */
class Solution {
	public void printList(Node head) { 
		Node node = head;
		while (node.next != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.println(node.val + "->NULL");
	}
}