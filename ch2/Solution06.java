package chapter2;

import java.util.Stack;

public class Solution06 {
	public static boolean isPalindrome(ListNode list) {
		//Use two pointers to find the middle node of the list
		//Use a stack to push the first half and pop the second half
		//Skip the middle one if the list has odd length
		//If stack is empty, then is palindrome
		ListNode fast = list, slow = list;
		Stack<Integer> stack = new Stack<Integer>();
		while (fast != null && fast.next != null) {
			stack.push(slow.val);
			System.out.println(slow.val);
			fast = fast.next.next;
			slow = slow.next;
		}
		if (fast != null) stack.push(slow.val);
		while (slow != null) {
			int top = stack.pop();
			if (slow.val != top) return false;
			slow = slow.next;
		}
		return true;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		ListNode node3 = new ListNode(3);
		node2.next = node3;
		ListNode node4 = new ListNode(2);
		node3.next = node4;
		ListNode node5 = new ListNode(1);
		node4.next = node5;
		System.out.println(isPalindrome(node1));

	}

}
