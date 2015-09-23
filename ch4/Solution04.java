package chapter4;

public class Solution04 {
	//Recursively calculate the depth of the tree
	public static int depth(TreeNode root) {
		if (root == null) return 0;
		return Math.max(depth(root.left), depth(root.right)) + 1;
	}
	
	//Recursively check whether the depth difference between left and right tree is large than 1
	public static boolean isBalance(TreeNode root) {
		if (root == null) {
			return true;
		} else {
			return isBalance(root.left) && isBalance(root.right) && Math.abs(depth(root.left) - depth(root.right)) <= 1;
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
		System.out.println(isBalance(root));
		TreeNode node5 = new TreeNode(8);
		TreeNode node6 = new TreeNode(9);
		node1.left = node5;
		node5.left = node6;
		System.out.println(isBalance(root));
	}

}
