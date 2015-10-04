package chapter5;

public class Solution04 {
	
	//Find the rightmost non-trailing one. Count the number of trailing ones c.
	//Clear all the bits on the right and add back c + 1 ones
	public static int prevNumber(int n) {
		int c = n;
		int c0 = 0;
		int c1 = 0;

		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}
		if (c == 0) return -1;
		while (((c & 1) == 0) && (c != 0)) {
			c0++;
			c >>= 1;
		}
		if (c0 + c1 == 31 || c0 + c1 == 0) {
			return -1;
		}
		int p = c0 + c1;
		n &= ((~0) << (p + 1));
		int mask = (1 << (c1 + 1)) - 1;
		n |= mask << (c0 - 1);
		return n;		
	}
	
	//Find the rightmost non-trailing zero. Find number of ones c on the right
	//Flip that bit, clear all the bits on right and add back c - 1 ones.
	public static int nextNumber(int n) {
		int c = n;
		int c0 = 0;
		int c1 = 0;
		while (((c & 1) == 0) && (c != 0)) {
			c0++;
			c >>= 1;
		}
		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}
		if (c0 + c1 == 31 || c0 + c1 == 0) {
			return -1;
		}
		int p = c0 + c1;
		n |= (1 << p);
		n &= ~((1 << p) - 1);
		n |= (1 << (c1 - 1)) - 1;
		return n;
	}
	
	public static void main(String[] args) {
		int num = 13948;
		System.out.println("Prev " + prevNumber(num));
		System.out.println("Next " + nextNumber(num));
	}

}
