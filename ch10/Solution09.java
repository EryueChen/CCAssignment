package chapter10;

public class Solution09 {
	//Use Binary Search for matrix, search upper left or bottom right matrix recursively
	public static int[] searchInMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		return search(matrix, 0, m - 1, 0, n - 1, target);
	}

	public static int[] search(int[][] matrix, int vstart, int vend, int hstart, int hend, int target) {
		if (vstart > vend || hstart > hend) {
			int[] result = {-1, -1};
			return result;
		}
		int vmid = (vstart + vend) / 2;
		int hmid = (hstart + hend) / 2;
		if (matrix[vmid][hmid] == target) {
			int[] result = {vmid, hmid};
			return result;
		} else if (matrix[vmid][hmid] < target) {
			int[] result = search(matrix, vmid + 1, vend, hmid, hend, target);
			if (result[0] == -1 && result[1] == -1) {
				result = search(matrix, vmid, vend, hmid + 1, hend, target);
			}
			return result;
		} else {
			int[] result = search(matrix, vstart, vmid - 1, hstart, hmid, target);
			if (result[0] == -1 && result[1] == -1) {
				result = search(matrix, vstart, vmid, hstart, hmid - 1, target);
			}
			return result;
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {17, 18, 19, 20}};
		int[] index = searchInMatrix(matrix, 14);
		System.out.println(index[0] + "," + index[1]);
	}

}
