package chapter1;

public class Solution09 {
	public static boolean isRotation(String s1, String s2) {
		return isSubstring(s2, s1+s1);
	}
	
	public static boolean isSubstring(String s1, String s2) {
		return s2.indexOf(s1) != -1;
	}
	
	public static void main(String[] args) {
		String s1 = "erbottlewat";
		String s2 = "waterbottle";
		System.out.println(s1 + ", " + s2);
		System.out.println(isRotation(s1, s2));
	}

}
