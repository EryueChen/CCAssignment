package chapter4;

public class Solution06 {
	
	class NewTreeNode {
		int value;
		NewTreeNode left;
		NewTreeNode right;
		NewTreeNode parent;
		NewTreeNode(int value) { 
			this.value = value;
		}
	}
	
	//If the node has right subtree, the successor node is the left most node of the right subtree
	//If the node does not have a right subtree, the successor node is the root when it is on left subtree
	public static NewTreeNode getSuccessor(NewTreeNode node) {
		if (node == null) return null;
		NewTreeNode right = node.right;
		if (right == null) {
			NewTreeNode parent = node.parent;
			while (parent != null && parent.value < node.value) {
				parent = parent.parent;
			}
			return parent;
		} else {
			NewTreeNode pointer = right;
			while (pointer.left != null) {
				pointer = pointer.left;
			}
			return pointer;
		}
	}

	public static void main(String[] args) {
		Solution06 s = new Solution06();
		NewTreeNode root = s.new NewTreeNode(4);
		NewTreeNode left = s.new NewTreeNode(2);
		NewTreeNode right = s.new NewTreeNode(6);
		root.left = left;
		root.right = right;
		left.parent = root;
		right.parent = root;
		NewTreeNode node1 = s.new NewTreeNode(1);
		NewTreeNode node2 = s.new NewTreeNode(3);
		NewTreeNode node3 = s.new NewTreeNode(5);
		NewTreeNode node4 = s.new NewTreeNode(7);
		left.left = node1;
		node1.parent = left;
		left.right = node2;
		node2.parent = left;
		right.left = node3;
		node3.parent = right;
		right.right = node4;
		node4.parent = right;
		System.out.println(getSuccessor(node1).value);
		System.out.println(getSuccessor(left).value);
		System.out.println(getSuccessor(node2).value);
		System.out.println(getSuccessor(root).value);
		System.out.println(getSuccessor(node3).value);
		System.out.println(getSuccessor(right).value);
		System.out.println(getSuccessor(node4));
	}

}
