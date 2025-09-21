package ArrayAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//static methods → belong to the class, can be called without creating an object.
//non-static methods → belong to an object, you must create an instance to call them.
//In Java, you cannot define a method inside another method.
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
	public static boolean containsDuplicate2(int[] nums) {
		 Arrays.sort(nums);
		 	for(int i=0; i< nums.length-1; i++) {
		 		int searchIndex = Arrays.binarySearch(nums, nums[i]);
		 		if(searchIndex != i) {
		 			return true;
		 		}
		 	}
				 return false;
	}
	
//	Random Index taking and checking - Critical flaws -Just try
	public static boolean containsDuplicate3(int[] nums) {
		Map<Integer,Integer> map = new HashMap<>(nums.length);
		while(!(nums.length == map.size())) {
			int randomNumber = (int)Math.random()*(nums.length+1);
			 if(map.containsValue(nums[randomNumber]) && !(map.containsKey(randomNumber))) {
				 return true;
			 }
			 map.put(randomNumber, nums[randomNumber]);
		}
		return false;
	}

//	Using set is the only best way because it will store only unique values
	public static boolean containsDuplicate4(int[] nums) {
		Set<Integer> set = new HashSet<>(nums.length);
		
		for(int num: nums) {
			if(!set.add(num)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
	int[] nums = {1,2,1};
	boolean answer = containsDuplicate2(nums);
	System.out.println(nums.length);
	System.out.println(answer);
	}
	
}
