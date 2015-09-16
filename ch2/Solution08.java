package chapter2;

public class Solution08 {
	public static ListNode detectCycle(ListNode list) {
		//First use a fast pointer which moves two nodes at a time
		//and a slow pointer which moves one node at a time
		//If they meet at some point, there's a cycle
		//Then use a pointer starting from the beginning of the list
		//When they meet, that's the start point of the cycle
		ListNode fast = list, slow = list;
		if (list == null || list.next == null) return null;
		while (slow.next != null && fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				ListNode node = list;
				while (node != fast) {
					node = node.next;
					fast = fast.next;
				}
				return fast;
			}
		}
		return null;
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
		node5.next = node2;
		ListNode cycle = detectCycle(node1);
		System.out.println(cycle.val);

	}

}
