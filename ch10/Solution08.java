package chapter10;

public class Solution08 {
	//Use 32000 bits to store the appearance of each number
	public static void checkDuplicates(int[] array) {
		BitSet bs = new BitSet(32000);
		for (int i = 0; i < array.length; i++) {
			int num = array[i];
			int num0 = num - 1;
			if (bs.get(num0)) {
				System.out.println(num);
			} else {
				bs.set(num0);
			}
		}
	}
}
