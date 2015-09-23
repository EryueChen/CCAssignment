package chapter4;

public class Solution10 {
	//Find if t2 is a subtree of t1
	public static boolean containsTree(TreeNode t1, TreeNode t2) {
		if (t2 == null) {
			return true;
		}
		return subTree(t1, t2);
	}
	
	//Recursively check whether r1's subtree is the same as r2
	public static boolean subTree(TreeNode r1, TreeNode r2) {
		if (r1 == null) {
			return false;
		} else if (r1.value == r2.value && matchTree(r1, r2)) {
			return true;
		}
		return (subTree(r1.left, r2) || subTree(r1.right, r2));
	}
	
	//Recursively check whether two trees are the same
	public static boolean matchTree(TreeNode r1, TreeNode r2) {
		if (r2 == null && r1 == null) {
			return true;
		} else if (r1 == null || r2 == null) {
			return false;
		} else if (r1.value != r2.value) {
			return false;
		} else {
			return (matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right));
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
		
		TreeNode subroot = new TreeNode(2);
		TreeNode subleft = new TreeNode(4);
		TreeNode subright = new TreeNode(5);
		subroot.left = subleft;
		subroot.right = subright;

		System.out.println(containsTree(root, subroot));

	}

}
