package chapter1;

public class Solution07 {
	public static void rotateMatrix(int[][] matrix) {
		int rows = matrix.length;
		int columns = matrix[0].length;
		for (int i = 0; i < rows / 2; i++) {
			for (int j = 0; j < columns; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[rows - 1 - i][j];
				matrix[rows - 1 - i][j] = tmp;
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < i; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
	}
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		System.out.println("Original:");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		rotateMatrix(matrix);
		System.out.println("Rotated:");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
