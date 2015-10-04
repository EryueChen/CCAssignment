package chapter6;

import java.util.Random;

public class Solution07 {
	//P(G) = 1/2; P(BG) = 1/4; P(BBG) = 1/8; etc.
	//The ratio of boys is Sigma(i/2^i)
		
	public static int[] runOne() {
		Random random = new Random();
		int boys = 0;
		int girls = 0;
		while (girls == 0) {
			if (random.nextBoolean()) {
				girls++;
			} else {
				boys++;
			}
		}
		int[] genders = {girls, boys};
		return genders;
	}
	
	public static double runN(int n) {
		int boys = 0;
		int girls = 0;
		for (int i = 0; i < n; i++) {
			int[] genders = runOne();
			girls += genders[0];
			boys += genders[1];
		}
		return girls / (double) (boys + girls);
	}
	
	public static void main(String[] args) {
		int num = 100000;
		System.out.println(runN(num));
	}

}
