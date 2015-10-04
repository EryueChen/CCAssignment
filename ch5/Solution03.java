package chapter5;

import java.util.ArrayList;

public class Solution03 {
	//Generate two lists, one counts 1 and one counts 0
	//If there's only one 0, add the left and right ones together
	//If there are more than one 0, add one to the original length
	public static int flipBit(int num) {
		ArrayList<Integer> ones = new ArrayList<Integer>();
		ArrayList<Integer> zeros = new ArrayList<Integer>();
		int last = -1;
		int count = 0;
		if (num % 2 == 0) ones.add(0);
		while (num > 0) {
			int digit = num % 2;
			if (digit == last) {
				count++;
			} else {
				if (last == 1) ones.add(count);
				else if (last == 0) zeros.add(count);
				last = digit;
				count = 1;
			}
			num /= 2;
		}
		if (last == 1) ones.add(count);
		else if (last == 0) zeros.add(count);
		int max = 0;
		for (int i = 0; i < zeros.size(); i++) {
			if (zeros.get(i) == 1) {
				int len = ones.get(i) + ones.get(i + 1) + 1;
				if (len > max) max = len;
			} else {
				if (ones.get(i) + 1 > max) max = ones.get(i) + 1;
				if (ones.get(i + 1) + 1 > max) max = ones.get(i + 1) + 1;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int num = 1775;
		System.out.println(flipBit(num));
	}

}
