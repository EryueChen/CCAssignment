package chapter2;

public class Solution07 {
	public static ListNode isIntersection(ListNode list1, ListNode list2) {
		//Since two lists have different length
		//Use two pointers to start from different lists and traverse both
		//If two pointers become the same at some point, that's intersection point
		ListNode p1 = list1, p2 = list2;
		if (list1 == null || list2 == null) return null;
		while (p1 != null || p2 != null && p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
			if (p1 == p2) return p1;
			if (p1 == null) p1 = list2;
			if (p2 == null) p2 = list1;
		}
		return p1;
	}
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		ListNode node3 = new ListNode(3);
		node2.next = node3;
		ListNode node4 = new ListNode(4);
		node3.next = node4;
		ListNode node5 = new ListNode(5);
		node4.next = node5;
		ListNode node6 = new ListNode(2);
		node6.next = node3;
		ListNode intersect = isIntersection(node1, node6);
		if (intersect != null) System.out.println(intersect.val);
	}

}
