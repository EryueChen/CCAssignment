package chapter1;

public class Solution06 {
	public static String compression(String str) {
		//Traverse the string and do reduce on the string
		//If the character is different with the previous one,
		//output the previous character and its count
		char last = str.charAt(0);
		int count = 1;
		String compressed = "";
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				compressed += String.valueOf(last) + String.valueOf(count);
				last = str.charAt(i);
				count = 1;
			}
		}
		compressed += String.valueOf(last) + String.valueOf(count);
		return compressed;
	}
	
	public static void main(String[] args) {
		String test = "aabcccccaaa";
		System.out.println(compression(test));
	}

}
