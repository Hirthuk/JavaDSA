package ArrayAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Duplicate {
	
	//Brute Force Method - Time Limit Exceeded
	public static boolean containsDuplicate1(int[] nums) {
		for(int i = 0; i < nums.length-1; i++) {
			for(int j = i+1; j <nums.length; j++) {
				if(nums[i] == nums[j]) {
					return true;
				}
			}
		}
		return false;
	}
	
//	HashMap implementation - Time limit exceeded
	public  boolean containsDuplicate(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i <nums.length-1; i++) {
			if(map.containsValue(nums[i])) {
				return true;
			}
			map.put(i, nums[i]);
		}
		
		return false;
	}
	
//	Sorted array Binary search - Worked but not efficient
	public boolean containsDuplicate2(int[] nums) {
		 Arrays.sort(nums);
		 for(int i =0; i < nums.length; i++) {
			 int searcIndex = Arrays.binarySearch(nums, nums[i]);
			 if(searcIndex != i) {
				 return true;
			 }
		 }
		 return false;
	}
	
//	Random Index taking and checking
	public static boolean containsDuplicate3(int[] nums) {
		Map<Integer,Integer> map = new HashMap<>(nums.length);
		System.out.println(map.size());
		System.out.println(nums.length);
		return true;
	}
	public static void main(String[] args) {
	int[] nums = {1,2,1};
	boolean answer = containsDuplicate3(nums);
	System.out.println(answer);
	}
	
}
