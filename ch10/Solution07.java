package chapter10;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution07 {
	//Use a bit vector with 4 billion bits. 
	//Traverse all the numbers and set corresponding bit as 1
	//Find the first number with value 0
	static long numberOfInts = ((long) Integer.MAX_VALUE) + 1;
	static byte[] bitfield = new byte[(int) (numberOfInts / 8)];
	static String filename = "./input07";

	public static void findOpenNumber() {
		Scanner in = null;
		try {
			in = new Scanner(new FileReader(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (in.hasNextInt()) {
			int n = in.nextInt();
			bitfield[n / 8] |= 1 << (n % 8);
		}
		for (int i = 0; i < bitfield.length; i++) {
			for (int j = 0; j < 8; j++) {
				if ((bitfield[i] & (1 << j)) == 0) {
					System.out.println(i * 8 + j);
					return;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		long count = 0;
		PrintWriter f = null;
		try {
			f = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (count < Long.parseLong("4000000000")) {
			f.write((count%(Integer.MAX_VALUE - 1)) + "\n");
			count++;
		}
		findOpenNumber();
	}

}
