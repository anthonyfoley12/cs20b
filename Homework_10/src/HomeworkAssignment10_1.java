import java.util.*;

//Author: Anthony Foley
//Class: CS 20B
//Assignment: Homework 10 Problem 1
//Date: 20 November 2020

public class HomeworkAssignment10_1 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5));
		System.out.println(list);
		Solution<Integer> sol = new Solution<Integer>(list);
		System.out.println(sol.print());
		System.out.println(sol.dequeue());
//		sol.enqueue(6);
//		System.out.println(sol.print());
//		sol.dequeue();
//		System.out.println(sol.print());
//		sol.enqueue(5);
//		System.out.println(sol.print());

	}

}

/*
 * The Solution class implements a max heap with the following methods:
 * enqueue(elem) - add element to the max heap.
 * 
 * dequeue()     - removes the highest priority element of
 *                 the max heap.
 *                 
 * reheapUp(x)   - move the lowest priority element up
 *                 the tree to reestablish the max heap
 *                 property.
 *                 
 * reheapUp(x)   - move the lowest priority element up
 *                 the tree to reestablish the max heap
 *                 property.
 *                 
 * reheapDown(x) - move the highest priority element down
 *                 the tree to reestablish the max heap
 *                 property.
 */
class Solution<T> {
	
	// YOU MAY ADD ANY INSTANCE VARIABLES HERE
	ArrayList<T> list;
	final static int FIRST_IDX = 0;
	
	// -------------------------------------------- 
	// !!!!PLEASE DO NOT MODIFY THIS CONSTRUCTOR!!!
	// -------------------------------------------- 
	public Solution(ArrayList<T> list) {
		this.list = list;
	}
	// -------------------------------------------- 
	// !!!!PLEASE DO NOT MODIFY THIS PRINT METHOD
	// -------------------------------------------- 
	public String print() {
		return Arrays.toString(list.toArray());
	}
	
	// enqueue(element) - add element to the max heap.
	public void enqueue(T element) {
		list.add(element);
		reheapUp(0);
	}
	
	// dequeue() - removes the highest priority element of
	//             the max heap.
	public void dequeue() {
		int last_idx = get_last_idx();
		//int ret = list.get(0);
		list.set(FIRST_IDX, list.get(last_idx));
		list.remove(last_idx);
		reheapDown(0);
	}
	
	// reheapUp(x) - move the lowest priority element up
	//               the tree to reestablish the max heap
	//               property.
	private void reheapUp(int x) {
		int idx = get_last_idx();
		while (has_parent(idx) && parent_is_smaller(idx)) {
			//System.out.println("SWAP");
			swap(idx, get_parent_idx(idx));
			idx = get_parent_idx(idx);
		}
	}
	
	// reheapDown(x) - move the highest priority element down
	//                 the tree to reestablish the max heap
	//                 property.
	private void reheapDown(int x) {
		int idx = 0;
		while (has_left(idx)) {
			int larger_child_idx = get_larger_child(idx);
			int current_val = (int) list.get(idx);
			int largest_child = (int)list.get(larger_child_idx);
			
			if (current_val > largest_child) {
				break;
			} else {
				swap(idx, larger_child_idx);
			}
			idx = larger_child_idx;
		}
	}
	
	// YOU MAY ADD ANY ADDITIONAL METHODS 
	// OF YOUR CHOICE HERE
	private int get_last_idx() {
		return list.size() - 1;
	}
	private int get_larger_child(int idx) {
		int right_val = (int) get_right_val(idx);
		int left_val = (int) get_left_val(idx);
		return ( has_right(idx) && right_val > left_val ) ? get_right_idx(idx) : get_left_idx(idx);
	}
	private boolean parent_is_smaller(int idx) {
		int parent = (int) get_parent_val(idx);
		int child = (int) list.get(idx);
		return parent < child;
	}
	
	private int get_left_idx(int parent_idx) { 
		return 2 * parent_idx + 1;
	}
	private int get_right_idx(int parent_idx) { 
		return 2 * parent_idx + 2;
	}
	private int get_parent_idx(int child_idx) { 
		return (child_idx - 1) / 2;
	}
	
	private boolean has_left(int idx) {
		return get_left_idx(idx) < list.size();
	}
	private boolean has_right(int idx) {
		return get_right_idx(idx) < list.size();
	}
	private boolean has_parent(int idx) {
		return get_parent_idx(idx) >= 0;
	}
	
	private T get_left_val(int idx) { 
		return list.get(get_left_idx(idx));
	}
	private T get_right_val(int idx) { 
		return list.get(get_right_idx(idx));
	}
	private T get_parent_val(int idx) { 
		return list.get(get_parent_idx(idx));
	}
	
	private void swap(int idx_1, int idx_2) {
		T temp = list.get(idx_1);
		list.set(idx_1, list.get(idx_2));
		list.set(idx_2,  temp);
	}
}