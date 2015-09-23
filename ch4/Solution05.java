package chapter4;

public class Solution05 {
	//Recursively check whether the left node value is smaller than root
	//And root node value is smaller than right node value
	
	public static boolean isBST(TreeNode root) {
		if (root == null) return true;
		TreeNode left = root.left;
		TreeNode right = root.right;
		if (left == null || right == null) return true;
		if (left.value > root.value || root.value > right.value) {
			return false;
		} else if (!isBST(left) || !isBST(right)) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(6);
		TreeNode node4 = new TreeNode(7);
		left.left = node1;
		left.right = node2;
		right.left = node3;
		right.right = node4;
		System.out.println(isBST(root));
		
		root = new TreeNode(4);
		left = new TreeNode(2);
		right = new TreeNode(6);
		root.left = left;
		root.right = right;
		node1 = new TreeNode(1);
		node2 = new TreeNode(3);
		node3 = new TreeNode(5);
		node4 = new TreeNode(7);
		left.left = node1;
		left.right = node2;
		right.left = node3;
		right.right = node4;
		System.out.println(isBST(root));
	}

}
