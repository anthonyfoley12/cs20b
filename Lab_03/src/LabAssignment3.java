// Author: Anthony Foley
// Class: CS 20B
// Assignment: Lab #3
// Date: 12 September 2020

public class LabAssignment3 {

	public static void main(String[] args) {
		Node node = new Node(1);
		Node current = node;
		System.out.println(node);
		System.out.println(current);
		for(int i = 2; i < 21; i++) {
			current.next = new Node(i);
			current = current.next;
		}
		Solution sol = new Solution();
		System.out.println(node);
		sol.printList(node);
		sol.reverseList(node);
		System.out.println("After revList: " + node);
		sol.printList(node);
	}
	
	

}

class Node {
    int val;
    Node next;
    Node(int x) { val = x; }
}

class Solution {
	public void reverseList(Node head) {
		System.out.println("Beginning revList: " + head);
		Node curr = head;
		Node prev = null;
		Node next = null;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		System.out.println("Before assign: " + head);
		head = prev;
		printList(head);
		System.out.println("After assign: " + head);
	}
	public void printList(Node head) { 
		Node node = head;
		while (node.next != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.println(node.val + "->NULL");
	}
}