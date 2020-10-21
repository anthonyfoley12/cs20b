import java.util.Arrays;

//Author: Anthony Foley
//Class: CS 20B
//Assignment: Homework 5 Problem 1
//Date: 07 October 2020

public class HomeworkAssignment5_2 {

	public static void main(String[] args) {
		int[] vals_1 = {1, 3, 2, 3, 4, 1, 3, 5, 2, 1};
		int num_groups_1 = 5;
		boolean expected_1 = true;
		int[] vals_2 = {1};
		int num_groups_2 = 4;
		boolean expected_2 = false;
		int[] vals_3 = {1, 3, 2, 3, 4, 1, 3, 5, 2, 1};
		int num_groups_3 = 0;
		boolean expected_3 = false;
		int[] vals_4 = {1, 3, 2, 3, 4, 1, 3, 5, 2, 1};
		int num_groups_4 = -1;
		boolean expected_4 = false;
		int[] vals_5 = {1, 3, 2, 3, 4, 1, 3, 5, 2, 1};
		int num_groups_5 = 1;
		boolean expected_5 = true;
		int[] vals_6 = {3, 4 , 5, 6};
		int num_groups_6 = 2;
		boolean expected_6 = true;
		int[] vals_7 = {3, 1,  1, 4, 2, 4, 5};
		int num_groups_7 = 4;
		boolean expected_7 = true;
		Solution sol = new Solution();
		
		System.out.println("Test 1: " + validate_result(sol.canDistribute(vals_1, num_groups_1), expected_1));
		System.out.println("Test 2: " + validate_result(sol.canDistribute(vals_2, num_groups_2), expected_2));
		System.out.println("Test 3: " + validate_result(sol.canDistribute(vals_3, num_groups_3), expected_3));
		System.out.println("Test 4: " + validate_result(sol.canDistribute(vals_4, num_groups_4), expected_4));
		System.out.println("Test 5: " + validate_result(sol.canDistribute(vals_5, num_groups_5), expected_5));
		System.out.println("Test 6: " + validate_result(sol.canDistribute(vals_6, num_groups_6), expected_6));
		System.out.println("Test 7: " + validate_result(sol.canDistribute(vals_7, num_groups_7), expected_7));
	}
	
	static String validate_result(boolean result, boolean expected) {
		if (result == expected) {
			return "Pass";
		}
		return "Fail";
	}
}

/*
 * The Solution class implements the following: 
 * canDistribute(resources, groups) -- returns boolean of equal division
 *                                     of resources into groups.
 */
class Solution {
	private int groups;
	private int[] resources;
	private int sum;
	private int max;
	private int allocation;
	private final int initial_start = 0;
	private final int initial_sum = 0;
	private boolean[] used_resources;
	
	public boolean canDistribute(int[] resources, int groups) {
		initialize_class_variable(resources, groups);
		if ( basic_tests_fail() ) 
			return false;
		return can_distribute_groups(initial_start, initial_sum);
	}
	
	private boolean can_distribute_groups(int iteration_start, int group_sum) {
		//System.out.println("Trying to distribute");
		if (only_one_group()) 
			return true;
		if (group_sum_equals_allocation(group_sum)) {
			reduce_groups();
			return can_distribute_groups(initial_start, initial_sum);
		}
		for (int resource = iteration_start; resource < resources.length; resource++) {
			if(!resource_is_used(resource)) {
				use_resource(resource);
				if(can_distribute_groups(resource + 1, group_sum + resources[resource])) {
					return true;
				}
				unuse_resource(resource);
			}
		}
		return false;
	}
	
	private void initialize_class_variable(int[] resources, int groups) {
		set_resources(resources);
		set_groups(groups);
		set_sum();
		set_max();
		set_allocation();
		set_used_resources();
		//print_initial();
	}
	
	private void print_initial() {
		System.out.println(Arrays.toString(resources) + " | " + groups);
	}
	
	private void set_resources(int[] avail_resources) {
		resources = avail_resources;
	}
	
	private boolean groups_exist() {
		return groups > 0;
	}
	
	private void set_groups(int num_groups) {
		groups = num_groups;
	}
	
	private void set_max() {
		max = Arrays.stream(resources).max().getAsInt();
	}
	
	private void set_sum() {
		sum = Arrays.stream(resources).sum();
	}
	
	private boolean basic_tests_fail() {
		return ( !groups_exist() || resources.length < groups || sum % groups != 0 || max > sum / groups );
	}
	
	private void set_allocation() {
		if (groups_exist()) {
			allocation = sum / groups;
		}
		
	}
	
	private void set_used_resources() {
		used_resources = new boolean[resources.length];
	}
	
	private boolean only_one_group() {
		return groups == 1;
	}
	
	private boolean group_sum_equals_allocation(int group_sum) {
		return group_sum == allocation;
	}
	
	private void reduce_groups() {
		groups = groups - 1;
	}
	
	private boolean resource_is_used(int resource) {
		return used_resources[resource];
	}
	
	private void use_resource(int resource) {
		used_resources[resource] = true;
	}
	
	private void unuse_resource(int resource) {
		used_resources[resource] = false;
	}
}