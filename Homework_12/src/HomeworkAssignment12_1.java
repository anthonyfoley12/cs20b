
//Author: Anthony Foley
//Class: CS 20B
//Assignment: Homework 12 Problem 1
//Date: 7 December 2020

public class HomeworkAssignment12_1 {

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.findThatSock(new int[] {1, 1, 2, 2, 3, 3, 4}));
		System.out.println(sol.findThatSock(new int[] {1, 2, 2, 3, 3, 4, 4}));
		System.out.println(sol.findThatSock(new int[] {1}));
		System.out.println(sol.findThatSock(new int[] {1, 1, 2, 3, 3}));

	}

}

class Solution {
	public int findThatSock(int[] socks) { 
		int left = 0;
		int right = socks.length - 1;
		while (left < right) {
			int mid = ( left + right ) / 2;
			System.out.println("Left: " + left + " Right: " + right + " Mid: " + mid);
			if ( ( mid % 2 == 0 && socks[mid] == socks[mid + 1] ) ||
				 ( mid % 2 == 1 && socks[mid] == socks[mid - 1] ) ) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return socks[left];
	}
}