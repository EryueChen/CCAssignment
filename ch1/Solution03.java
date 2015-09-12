package chapter1;

public class Solution03 {
	public static void urlify(char[] str, int len) {
		int newlen = len - 1;
		for (int i = 0; i < len; i++) {
			if (str[i] == ' ') newlen += 2;
		}
		for (int i = len - 1; i >= 0; i--) {
			if (str[i] != ' ') {
				str[newlen--] = str[i];
			} else {
				str[newlen - 2] = '%';
				str[newlen - 1] = '2';
				str[newlen] = '0';
				newlen -= 3;
			}
		}
	}
	

	public static void main(String[] args) {
		char[] test = "Mr John Smith    ".toCharArray();
		urlify(test, 13);
		System.out.println(test);
	}

}
