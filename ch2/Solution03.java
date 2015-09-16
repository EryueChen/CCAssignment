package chapter2;

public class Solution03 {
	public static void deleteMiddle(ListNode root, ListNode middle) {
		//Change the value of middle to the value of next node
		//Delete the next node
		ListNode next = middle.next;
		middle.val = next.val;
		middle.next = next.next;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		ListNode node3 = new ListNode(3);
		node2.next = node3;
		ListNode node4 = new ListNode(4);
		node3.next = node4;
		deleteMiddle(node1, node3);
		ListNode node = node1;
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

}
