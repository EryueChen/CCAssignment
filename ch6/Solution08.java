package chapter6;

public class Solution08 {
	public static int breakingPoint = 40;
	public static int countDrops = 0;
	
	public static boolean drop(int floor) {
		countDrops++;
		return floor >= breakingPoint;
		
	}
	
	public static int findBreakPoint(int floors) {
		int interval = 14;
		int previous = 0;
		int egg1 = interval;
		while (!drop(egg1) && egg1 <= floors) {
			interval--;
			previous = egg1;
			egg1 += interval;
		} 
		int egg2 = previous + 1;
		while (egg2 < egg1 && egg2 <= floors && !drop(egg2)) {
			egg2++;
		}
		return egg2 > floors ? -1 : egg2;
		
	}

	public static void main(String[] args) {
		System.out.println(findBreakPoint(40));

	}

}
