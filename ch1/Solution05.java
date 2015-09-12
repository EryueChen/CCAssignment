package chapter1;

public class Solution05 {
	public static boolean isOneAway(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		if (Math.abs(len1 - len2) > 1) return false;
		int min = Math.min(len1, len2);
		for (int i = 0; i < min; i++){
			if (str1.charAt(i) != str2.charAt(i)) {
				String substr1 = str1.substring(i + min - len2 + 1);
				String substr2 = str2.substring(i + min - len1 + 1);
				if (substr1.equals(substr2)) return true;
				else return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println("pale, ple: " + isOneAway("pale", "ple"));
		System.out.println("pales, pale: " + isOneAway("pales", "pale"));
		System.out.println("pale, bale: " + isOneAway("pale", "bale"));
		System.out.println("pale, bale: " + isOneAway("pale", "bake"));
	}

}
