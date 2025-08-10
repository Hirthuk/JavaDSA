package ArrayAndHashing;

public class validAnagram {

//	Brute force
	public static boolean isAnagram(String s, String t) {
		if(s.contains(t)) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
		
		System.out.println(isAnagram(s,t));

	}

}
