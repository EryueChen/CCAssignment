package chapter10;

import java.lang.annotation.Target;

public class Solution05 {
	//Still use binary search
	//If meet with empty string, expand to left and right to find nonempty one
	public static int sparseSearch(String[] list, String target) {
		return search(list, 0, list.length - 1, target);
	}
	
	public static int search(String[] list, int start, int end, String target) {
		if (start > end) return -1;
		int mid = (start + end) / 2;
		String midString = list[mid];
		if (midString.equals("")) {
			int dist = 1;
			while (list[mid + dist].equals("") && list[mid - dist].equals("")) {
				dist++;
			}
			if (!list[mid + dist].equals("")){
				midString = list[mid + dist];
				mid = mid + dist;
			}
			if (!list[mid - dist].equals("")) {
				midString = list[mid - dist];
				mid = mid - dist;
			}
		}
		if (midString.equals(target)) {
			return mid;
		} else if (midString.compareTo(target) < 0) {
			return search(list, mid + 1, end, target);
		} else {
			return search(list, start, mid - 1, target);
		}
	}
	
	public static void main(String[] args) {
		String[] list = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		int result = sparseSearch(list, "ball");
		System.out.println(result);
	}

}
