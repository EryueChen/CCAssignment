package chapter1;

public class Solution08 {
	public static void zeroMatrix(int[][] matrix) {
		//First rotate the matrix upside down
		//Second do matrix transposition
		int rows = matrix.length;
		int columns = matrix[0].length;
		int row = 1, column = 1;
		for (int i = 0; i < columns; i++) {
			if (matrix[0][i] == 0) row = 0;
		}
		for (int i = 0; i < rows; i++) {
			if (matrix[i][0] == 0) column = 0;
		}
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < columns; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < columns; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		if (row == 0) {
			for (int i = 0; i < columns; i++) {
				matrix[0][i] = 0;
			}
		}
		if (column == 0) {
			for (int i = 0; i < rows; i++) {
				matrix[i][0] = 0;
			}
		}
	}
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3}, {4, 5, 0}, {7, 8, 9}};
		System.out.println("Original:");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		zeroMatrix(matrix);
		System.out.println("Zeroed:");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
