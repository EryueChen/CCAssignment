package chapter4;

import java.util.HashMap;

public class Solution12 {
	//Use a hashmap to store the count of partial sum 
	//If a number can be found, the difference with which equals to target,
	//the path is found and the count should increment
	
	public static int countPaths(TreeNode root, int target) {
		if (root == null) return 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		incrementMap(map, 0, 1);
		return countPaths(root, target, map, 0);
	}
	
	//Recursively calculate the partial sum and update the hashmap
	public static int countPaths(TreeNode node, int target, HashMap<Integer, Integer> map, int partial) {
		if (node == null) return 0;
		partial += node.value;
		incrementMap(map, partial, 1);
		int sum = partial - target;
		int count = map.containsKey(sum) ? map.get(sum) : 0;
		count += countPaths(node.left, target, map, partial);
		count += countPaths(node.right, target, map, partial);
		incrementMap(map, partial, -1);
		return count;
	}
	
	//Update the hashmap with new value added
	public static void incrementMap(HashMap<Integer, Integer> map, int key, int delta) {
		if (!map.containsKey(key)) {
			map.put(key, 0);
		}
		map.put(key, map.get(key) + delta);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		TreeNode node1 = new TreeNode(6);
		TreeNode node2 = new TreeNode(7);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		left.left = node1;
		left.right = node2;
		right.left = node3;
		right.right = node4;
		System.out.println(countPaths(root, 9));
	}

}
