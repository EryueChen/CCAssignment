package chapter5;

public class Solution01 {
	//Record the first and last part separately by shifting
	//Add the other number to the original number
	public static int insertBits(int m, int n, int i, int j) {
		int last = ((1 << i) - 1) & n;
		int first = (n >> (j + 1)) << (j + 1);
		int mid = m << i;
		int result = last | first | mid;
		return result;
	}

	public static void main(String[] args) {
		int n = 1024;
		int m = 19;
		System.out.println(insertBits(m, n, 2, 6));
	}

}
