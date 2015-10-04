package chapter5;

public class Solution06 {
	//XOR two numbers to find digit difference
	//Count the number of 1 in xor result
	public static int bitFlip(int a, int b) {
		int xor = a ^ b;
		int count = 0;
		while (xor > 0) {
			if (xor % 2 == 1) {
				count++;
			}
			xor >>= 1;
		}
		return count;
	}

	public static void main(String[] args) {
		int a = 29;
		int b = 15;
		System.out.println(bitFlip(a, b));
	}

}
