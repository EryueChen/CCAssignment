package chapter2;

import java.util.HashSet;

public class Solution01 {
	public static void removeDups(ListNode root) {
		//Store the value of last node and skip if it is the same with last one
		HashSet<Integer> set = new HashSet<Integer>();
		ListNode previous = null;
		ListNode node = root;
		while (node != null) {
			if (!set.contains(node.val)){
				set.add(node.val);
				previous = node;
			} else {
				previous.next = node.next;
				previous = node.next;
			}
			node = node.next;
		}
	}
	
	public static void removeDupsNobuf(ListNode root) {
		ListNode node = root;
		while (node != null) {
			ListNode follow = node;
			while (follow != null && follow.next != null) {
				if (follow.next.val == node.val) {
					follow.next = follow.next.next;
				}
				follow = follow.next;
			}
			node = node.next;
		}
	}
	
	public static void main(String[] args) {
		ListNode root = new ListNode(2);
		ListNode node1 = new ListNode(1);
		root.next = node1;
		ListNode node2 = new ListNode(1);
		node1.next = node2;
		removeDups(root);
		ListNode node = root;
		while (node != null) { 
			System.out.println(node.val);
			node = node.next;
		}
	}

}
