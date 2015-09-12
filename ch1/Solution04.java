package chapter1;

import java.util.HashSet;

public class Solution04 {
	public static boolean isPalindromePermutation(String str) {
		HashSet<Character> alphabet = new HashSet<Character>();
		str = str.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == ' ') continue;
			if (alphabet.contains(c)) {
				alphabet.remove(c);
			} else {
				alphabet.add(c);
			}
		}
		if (alphabet.size() <= 1) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		String test1 = "Tact Coa";
		System.out.println(test1 + ": " + isPalindromePermutation(test1));
		String test2 = "Daad Good";
		System.out.println(test2 + ": " + isPalindromePermutation(test2));
	}

}
