
//Author: Anthony Foley
//Class: CS 20B
//Assignment: Homework 8 Problem 1
//Date: 02 November 2020

public class HomeworkAssignment8_1 {

	public static void main(String[] args) {
//		Integer bst_1[] = {3, 0, 0};
//		Integer bst_2[] = {0, 0, 3};
//		Integer bst_3[] = {0, 0, 1, 1, null, 1, 3};
//		Integer bst_4[] = {0, 0, 3, 0, null, 3, 0, 0, null, null, null, null, null, 2, 1};
//		Integer bst_5[] = {9, 0, 0, 0, 0, 0, 0, null, null, null, 0, 0};
//		Integer bst_6[] = {0, 0, 0, 4, null, 2, 0};
//		Integer bst_7[] = {0, 0, 0, 4, null, 2, 0};
//		Integer bsts[][] = {bst_1, bst_2, bst_3, bst_4, bst_5, bst_6};
//		Tree t = new Tree();
//		Solution sol = new Solution();
//		for(Integer bst[] : bsts) {
//			System.out.println(sol.distribute(t.array_to_tree(bst)));
//		}
	}
}

class BSTNode {
	int val;
	BSTNode left;
	BSTNode right;
	BSTNode(int x) { val = x; }
}

/* 
 * The Tree class implements an array_to_tree method uses
 * level-order traversal to create a binary search tree 
 * from the BSTNode class.
 * 
 * array_ti_tree(input) - convert input array to binary search
 *                        tree and return root node.
 */
class Tree {
	public BSTNode array_to_tree(Integer[] input){
		BSTNode root = tree_node(input,1);
	    return root;
	}
	
	private BSTNode tree_node(Integer[] input, int index){
	    if(index <= input.length){
	        Integer value = input[index - 1];
	        if(value != null){
	        	BSTNode node = new BSTNode(value);
	            node.left = tree_node(input, index * 2);
	            node.right = tree_node(input, index * 2 + 1);
	            return node;
	        }
	    }
	    return null;
	}
}

class Solution {
	/*
	 * The Solution class implements a distribute method to
	 * calculate how many moves are required to distribute
	 * 1 unit to N nodes (level-order traversal).
	 * 
	 * distribute(BSTNode) - return number of moves to distribute
	 *                       1 unit to N nodes.
	 */
	private int moves;
	
	public int distribute(BSTNode tree) {
		moves = 0; // Initialize moves
		distribute_ppe(tree);
		return moves;
	}

	private int distribute_ppe(BSTNode node) {
		if (node == null) return 0;
		int left = distribute_ppe(node.left);
		int right = distribute_ppe(node.right);
		moves += Math.abs(left) + Math.abs(right);
		return node.val - 1 + left + right;
	}
}