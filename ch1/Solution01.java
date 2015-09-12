package chapter1;

public class Solution01 {
	public static boolean isUnique(String str) {
		int[] alphabets = new int[256];
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (alphabets[c] != 0) {
				return false;
			} else {
				alphabets[c]++;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String test1 = "abcd";
		System.out.println(test1 + ": " + isUnique(test1));
		String test2 = "abcc";
		System.out.println(test2 + ": " + isUnique(test2));
	}

}
