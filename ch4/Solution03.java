package chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution03 {
	//Generate the Linkedlist for each level of nodes
	//Iterate the LinkedList of last level and generate new LinkedList
	
	public static ArrayList<LinkedList<TreeNode>> listofDepth(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		list.add(root);
		while (!list.isEmpty()) {
			result.add(list);
			list = gen_list(list);
		}
		return result;
	}
	
	public static LinkedList<TreeNode> gen_list(LinkedList<TreeNode> list) {
		LinkedList<TreeNode> newlist = new LinkedList<TreeNode>();
		for (int i = 0; i < list.size(); i++) {
			TreeNode node = list.get(i);
			TreeNode lnode = node.left;
			TreeNode rnode = node.right;
			if (lnode != null) newlist.add(lnode);
			if (rnode != null) newlist.add(rnode);
		}
		return newlist;
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
		
		ArrayList<LinkedList<TreeNode>> result = listofDepth(root);
		for (int i = 0; i < result.size(); i++) {
			LinkedList<TreeNode> list = result.get(i);
			for (int j = 0; j < list.size(); j++) {
				TreeNode node = list.get(j);
				System.out.print(node.value + " ");
			}
			System.out.println();
		}

	}

}
