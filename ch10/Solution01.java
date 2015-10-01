package chapter10;

public class Solution01 {
	//Merge two array from end to start
	public static void mergeSortedArray(int[] A, int[]B, int lengthA, int lengthB) {
		int index = lengthA + lengthB - 1;
		lengthA--;
		lengthB--;
		while (index >= 0) {
			int valA = lengthA >= 0 ? A[lengthA] : Integer.MIN_VALUE;
			int valB = lengthB >= 0 ? B[lengthB] : Integer.MIN_VALUE;
			if (valA > valB) {
				A[index--] = A[lengthA--];
			} else {
				A[index--] = B[lengthB--];
			}
		}
	}

	public static void main(String[] args) {
		int[] A = new int[10];
		int[] B = new int[4];
		int i;
		for (i = 0; i < 4; i++) {
			A[i] = 2 * i + 1;
			B[i] = 2 * i;
		}
		A[i] = 2 * i + 1;
		for (int j = 0; j < 5; j++) {
			System.out.print(A[j] + " ");
		}
		System.out.println();
		for (int j = 0; j < 4; j++) {
			System.out.print(B[j] + " ");
		}
		System.out.println();
		mergeSortedArray(A, B, 5, 4);
		for (int j = 0; j < 9; j++) {
			System.out.print(A[j] + " ");
		}
		System.out.println();
	}

}
