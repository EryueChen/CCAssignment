package chapter2;

class PartialSum {
	public ListNode sum = null;
	public int carry = 0;
}

public class Solution05 {
	public static ListNode addLists(ListNode list1, ListNode list2, int carry) {
		if (list1 == null && list2 == null && carry == 0) {
			return null;
		}
		int value = carry;
		if (list1 != null) value += list1.val;
		if (list2 != null) value += list2.val;
		ListNode result = new ListNode(value % 10);
		if (list1 != null || list2 != null) {
			ListNode more = addLists(list1 == null ? null : list1.next,
					list2 == null ? null : list2.next, value >= 10 ? 1 : 0);
			result.next = more;
		}
		return result;
	}
	
	
	
	public static int length(ListNode node) {
		int count = 0;
		while (node != null) {
			node = node.next;
			count++;
		}
		return count;
	}
	
	public static ListNode insertBefore(ListNode list, int data) {
		ListNode node = new ListNode(data);
		if (list != null) {
			node.next = list;
		}
		return node;
	}
	
	public static ListNode padList(ListNode node, int padding) {
		ListNode head = node;
		for (int i = 0; i < padding; i++) {
			head = insertBefore(head, 0);
		}
		return head;
	}
	
	public static PartialSum addListsHelper(ListNode list1, ListNode list2) {
		if (list1 == null && list2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}
		PartialSum sum = addListsHelper(list1.next, list2.next);
		int val = sum.carry + list1.val + list2.val;
		ListNode full_result = insertBefore(sum.sum, val % 10);
		sum.sum = full_result;
		sum.carry = val / 10;
		return sum;
	}
	
	public static ListNode addListsForward(ListNode list1, ListNode list2) {
		int len1 = length(list1);
		int len2 = length(list2);
		if (len1 < len2) {
			list1 = padList(list1, len2 - len1);
		} else {
			list2 = padList(list2, len1 - len2);
		}
		PartialSum sum = addListsHelper(list1, list2);
		if (sum.carry == 0) {
			return sum.sum;
		} else {
			ListNode result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(7);
		ListNode node2 = new ListNode(1);
		node1.next = node2;
		ListNode node3 = new ListNode(6);
		node2.next = node3;
		
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(9);
		node4.next = node5;
		ListNode node6 = new ListNode(2);
		node5.next = node6;
		
		ListNode result = addLists(node1, node4, 0);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
		System.out.println();
		result = addListsForward(node1, node4);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}

}
