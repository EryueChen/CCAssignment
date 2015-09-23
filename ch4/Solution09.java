package chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution09 {
	//Recursively get the sequences from left and right nodes and weave them together
	public static ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		if (node == null) {
			LinkedList<Integer> list = new LinkedList<Integer>();
			result.add(list);
			return result;
		}
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(node.value);
		ArrayList<LinkedList<Integer>> left = allSequences(node.left);
		ArrayList<LinkedList<Integer>> right = allSequences(node.right);
		for (LinkedList<Integer> l : left) {
			for (LinkedList<Integer> r : right) {
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				weaveList(l, r, weaved, prefix);
				result.addAll(weaved);
			}
		}
		return result;
	}
	
	//Weave two lists to generate all the possible sequences
	public static void weaveList(LinkedList<Integer> l, LinkedList<Integer> r, ArrayList<LinkedList<Integer>> weaved, LinkedList<Integer> prefix) {
		if (l.size() == 0 || r.size() == 0) {
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(l);
			result.addAll(r);
			weaved.add(result);
			return;
		}
		int headFirst = l.removeFirst();
		prefix.addLast(headFirst);
		weaveList(l, r, weaved, prefix);
		prefix.removeLast();
		l.addFirst(headFirst);
		
		int headSecond = r.removeFirst();
		prefix.addLast(headSecond);
		weaveList(l, r, weaved, prefix);
		prefix.removeLast();
		r.addFirst(headSecond);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		
		ArrayList<LinkedList<Integer>> result = allSequences(root);
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println();
		}

	}

}
