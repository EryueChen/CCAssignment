package chapter4;

public class Solution02 {
	//To generate the tree, use the middle element of the sorted array as the root of tree
	//Then recursively generate the left and right subtree using left and right subarray
	
	public static TreeNode minTree(int[] array, int start, int end) {
		if (start > end) return null;
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(array[mid]);
		root.left = minTree(array, start, mid - 1);
		root.right = minTree(array, mid + 1, end);
		return root;
		
	}
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7};
		TreeNode root = minTree(array, 0, 6);
		System.out.println(root.value);
		TreeNode l = root.left;
		TreeNode r = root.right;
		System.out.println(l.value + "," + r.value);
		System.out.println(l.left.value + "," + l.right.value + "," + r.left.value + "," + r.right.value);
	}

}
