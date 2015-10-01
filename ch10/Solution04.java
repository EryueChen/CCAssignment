package chapter10;

import java.util.ArrayList;

public class Solution04 {
	//Expand the list range exponentially to find the approximate range
	//Use binary search in the range 
	public static int searchInListy(Listy listy, int target) {
		int index = 1;
		while (listy.elementAt(index) != -1) {
			index *= 2;
		}
		return search(listy, 0, index, target);
	}

	public static int search(Listy listy, int start, int end, int target) {
		if (start > end) return -1;
		int mid = (start + end) / 2;
		if (target == listy.elementAt(mid)) return mid;
		if (target < listy.elementAt(mid)) {
			return search(listy, start, mid - 1, target);
		} else {
			return search(listy, mid + 1, end, target);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			list.add(i);
		}
		Listy listy = new Listy(list);
		int result = searchInListy(listy, 7);
		System.out.println(result);
	}

}
