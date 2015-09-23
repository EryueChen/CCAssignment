package chapter4;

public class Solution08 {
	//Recursively find if two nodes are in the same tree from top to down	
	public static TreeNode firstCommon(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null || root == node1 || root == node2) return root;
		TreeNode left = firstCommon(root.left, node1, node2);
		TreeNode right = firstCommon(root.right, node1, node2);
		if (left == null) return right;
		else if (right == null) return left;
		else return root;
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
		System.out.println(firstCommon(root, node1, node2).value);

	}

}
