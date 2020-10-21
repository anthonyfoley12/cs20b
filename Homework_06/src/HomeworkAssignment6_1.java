//Author: Anthony Foley
//Class: CS 20B
//Assignment: Homework 6 Problem 1
//Date: 20 October 2020

public class HomeworkAssignment6_1 {

	public static void main(String[] args) {
		int size = 15;
		Solution q = new Solution(size);
		q.print_stats();
		System.out.println("--- Add 15 Elements ---");
		for(int i = 0; i < size; i++) {
			q.add(i);
		}
		q.print_stats();
		
		System.out.println("--- Remove 7 Elements ---");
		for(int i = 0; i < size / 2; i++) {
			q.remove();
		}
		q.print_stats();
		
		System.out.println("--- Add 1 Element ---");
		q.add(0);
		q.print_stats();
		
		System.out.println("--- PEEK ---");
		q.peek();
		q.print_stats();
		
		System.out.println("--- Remove all Elements ---");
		int current_num_elements = q.get_num_elements();
		for (int i = 0; i < current_num_elements; i++ ) {
			System.out.println(q.remove());
			q.print_stats();
		}
		System.out.println(q.isEmpty());
	}

}

/*
 * The Solution class implements an array-based queue (floating front design).
 * Constraints / Assumptions:
 *    * add(x) will never be done on a queue at capacity
 *    * remove() & peek() will never be done on empty queue
 *    * front and rear will have index -1 when queue is empty
 */
class Solution {

	// Dynamic array size
	private int capacity;
	// Queue
	private int[] elements;
	// Dynamic queue size
	private int numElements = 0;
	// Dynamic index for the front of queue, defaulting to -1
	private int front = -1;
	// Dynamic index for the rear of queue, defaulting to -1
	private int rear = -1;

	// Constructor
	public Solution(int capacity) {
		this.capacity = capacity;
		this.elements = new int[this.capacity];
	}
	// Get the front index
	public int getFront() {
		return this.front;
	}
	// Get the rear index
	public int getRear() {
		return this.rear;
	}

	/* 
	 * =====================================
	 * !!! DO NOT MODIFY ABOVE THIS LINE!!!
	 * ====================================.
	 */

	// add(x) - adds x to back of queue
	public void add(int x) {
		if (isEmpty()) {
			move_front();
		}
		move_rear();
		elements[rear] = x;
		increment_numElements();
	}
	// remove() - removes element from beginning of queue
	public int remove() { 
		int element = peek();
		move_front();
		decrement_numElements();
		if (isEmpty()) {
			reset_front_rear();
		}
		return element;
	}
	// peek() - returns value of elements at beginning of queue
	public int peek() { 
		return elements[front];
	}
	// isEmpty() - check if queue is empty and returns boolean result
	public boolean isEmpty() { 
		return numElements == 0;
	}
	
	public int get_num_elements() {
		return numElements;
	}
	
	// private functions
	private void move_rear() {
		rear = (rear + 1) % capacity;
	}
	private void move_front() {
		front = (front + 1) % capacity;
	}
	private void increment_numElements() {
		numElements = numElements + 1;
	}
	private void decrement_numElements() {
		numElements = numElements - 1;
	}
	// Constraint mandates front and rear have index -1 when queue is empty
	private void reset_front_rear() {
		front = -1;
		rear = -1;
	}
	public void print_stats() {
		System.out.println("Front " + getFront());
		System.out.println("Rear " + getRear());
		System.out.println("Num Elements " + get_num_elements());
	}

}