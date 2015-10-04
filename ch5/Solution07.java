package chapter5;

public class Solution07 {
	//Record the number on odd bits and even bits
	//Shift two numbers and add together
	public static int swapBits(int num) {
		return ((num & 0xaaaaaaaa) >>> 1) | ((num & 0x55555555) << 1);
	}
	
	public static void main(String[] args) {
		int num = 170; //10101010
		System.out.println(swapBits(num)); //01010101
	}

}
