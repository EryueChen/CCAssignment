package chapter2;

public class Solution02 {
	public static ListNode kthToLast(ListNode root, int k) {
		ListNode p1 = root, p2 = root;
		while (k > 0) {
			p1 = p1.next;
			k--;
		}
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(5);
		ListNode node2 = new ListNode(4);
		node1.next = node2;
		ListNode node3 = new ListNode(3);
		node2.next = node3;
		ListNode node4 = new ListNode(2);
		node3.next = node4;
		ListNode node5 = new ListNode(1);
		node4.next = node5;
		int k = 2;
		ListNode result = kthToLast(node1, k);
		System.out.println("The " + k + "th to last: " + result.val);

	}

}
