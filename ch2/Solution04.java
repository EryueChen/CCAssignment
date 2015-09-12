package chapter2;

public class Solution04 {
	public static ListNode partition(ListNode root, int pivot) {
		ListNode beforeStart = null;
		ListNode beforeEnd = null;
		ListNode afterStart = null;
		ListNode afterEnd = null;
		ListNode node = root;
		while (node != null) {
			
			if (node.val < pivot) {
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = node;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				if (afterStart == null) {
					afterStart = node;
					afterEnd = node;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = node.next;
		}
		afterEnd.next = null;
		if (beforeEnd == null) {
			return afterStart;
		} else {
			beforeEnd.next = afterStart;
			return beforeStart;
		}
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(5);
		node1.next = node2;
		ListNode node3 = new ListNode(8);
		node2.next = node3;
		ListNode node4 = new ListNode(5);
		node3.next = node4;
		ListNode node5 = new ListNode(10);
		node4.next = node5;
		ListNode node6 = new ListNode(2);
		node5.next = node6;
		ListNode node7 = new ListNode(1);
		node6.next = node7;
		
		System.out.println("Original: ");
		ListNode node = node1;
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		int pivot = 5;
		System.out.println("\nPivot: " + pivot);
		System.out.println("Paritioned: ");
		node = partition(node1, pivot);
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

}
