package chapter1;

public class Solution02 {
	public static boolean isPermutation(String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		int[] alphabet = new int[256];
		for (int i = 0; i < str2.length(); i++) {
			alphabet[str1.charAt(i)]++;
			alphabet[str2.charAt(i)]--;
		}
		for (int i = 0; i < 256; i++) {
			if (alphabet[i] != 0) return false; 
		}
		return true;
	}
	
	public static void main(String[] args) {
		String test1_a = "abcd";
		String test1_b = "dcab";
		System.out.println(test1_a + ", " + test1_b + ": " + isPermutation(test1_a, test1_b));
		String test2_a = "abcd";
		String test2_b = "dcaa";
		System.out.println(test2_a + ", " + test2_b + ": " + isPermutation(test2_a, test2_b));

	}

}
