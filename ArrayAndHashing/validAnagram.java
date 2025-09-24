package ArrayAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//For anagram checks, frequency counting O(n) time is the gold standard

public class validAnagram {
	
//	Brute force method - Using Arrays utility Package
	public static boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();
		Arrays.sort(sArray);
		Arrays.sort(tArray);
		
		System.out.println(sArray);
		System.out.println(tArray);
		
		return Arrays.equals(sArray, tArray);
		
	}
	
//	Method 2 -- Time Limit Exceeded
	public static boolean isAnagram1(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();
		Map<Integer, Character> anagramPair = new HashMap<>();
		for(int i=0; i < t.length(); i++) {
			anagramPair.put(i, tArray[i]);
		}
		
		System.out.println(anagramPair.values());
		for(int i=0; i<= sArray.length-1; i++) {
			if(anagramPair.containsValue(sArray[i])) {
				anagramPair.values().remove(sArray[i]);
			}
			else {
				return false;
			}
		}
		
		return true;
		
	}
	
//	Method 3 - Best by using how frequently the letters added -  In short same letter and in same number of times
	public static boolean isAnagram2(String s, String t) {
		
		if(s.length() != t.length()) return false;
		int[] characters = new int[26];
		for(int i=0;i < s.length(); i++) {
			characters[s.charAt(i) - 'a']++; 
			System.out.println(s.charAt(i));
			characters[t.charAt(i) - 'a']--;
		}
		
		for(int c: characters) {
			if(c != 0) {
				return false;
			}
		}
		
		return true;
	}
	
//	Method 3 flow how it works
//	Creating a new Integer array to 26 elements - all elements will be zero
//	Until reach the last element of s we keep taking adding the index of the respective words
//	Quick example s = til t = lit -> 't'-'a'=19, 'i'-'a'=8, 'l'-'a'=11 so at index 19 8 and 11 the values will be 1
//	again when it comes to t string l-a=11 i-a=8 t-a=19 here we using -- so that indexes will be reduced from 1 to zero
//	If all elements in the array is 0 that means this is anagram.
	
	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
		boolean result = isAnagram2(s,t);
		System.out.println(result);
	}
}
