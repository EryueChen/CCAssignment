package chapter10;

public class Solution11 {
	//Swap the center element with the largest adjacent element
	public static void sortPeakValley(int[] array) {
		for (int i = 1; i < array.length; i += 2) {
			int biggestIndex = maxIndex(array, i - 1, i, i + 1);
			if (i != biggestIndex) {
				int tmp = array[i];
				array[i] = array[biggestIndex];
				array[biggestIndex] = tmp;
			}
		}
	}
	
	public static int maxIndex(int[] array, int a, int b, int c) {
		int len = array.length;
		int valuea = a < len ? array[a] : Integer.MIN_VALUE;
		int valueb = b < len ? array[b] : Integer.MIN_VALUE;
		int valuec = c < len ? array[c] : Integer.MIN_VALUE;
		int max = valuea;
		int maxIndex = a;
		if (valueb > max) { 
			maxIndex = b;
			max = valueb;
		}
		if (valuec > max) { 
			maxIndex = c;
			max = valuec;
		}
		return maxIndex;
	}

	public static void main(String[] args) {
		int[] array = {5, 3, 1, 2, 3};
		sortPeakValley(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " ");
		}
	}
}
