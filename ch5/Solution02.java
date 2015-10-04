package chapter5;

public class Solution02 {
	//Calculate the bit continuously after decimal point
	public static String binaryToString(double num) {
		if (num >= 1 || num <= 0) return "ERROR";
		String result = "0.";
		double deg = 0.5;
		while (num > 0) {
			if (num >= deg) {
				result += "1";
				num -= deg;
			} else {
				result += "0";
			}
			deg /= 2;
			if (result.length() > 32) return "ERROR";
		}
		return result;
	}
	public static void main(String[] args) {
		double n = 0.9375;
		System.out.println(binaryToString(n));
	}

}
