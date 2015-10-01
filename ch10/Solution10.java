package chapter10;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution10 {
	//Build a binary tree to store while numbers are added
	//Count number of all the nodes on the left as the rank
	TreeNode root = null;
	
	public void track(int num) {
		if (root == null) {
			root = new TreeNode(num);
		} else {
			root.insert(num);
		}
	}
	
	public int getRankOfNumber(int num) {
		return getRank(root, num);
	}

	public int getRank(TreeNode node, int num) {
		if (node.value == num) {
			return node.left_size;
		} else if (node.value > num) {
			if (node.left == null) return -1;
			else return getRank(node.left, num);
		} else {
			int right_rank = 0;
			if (node.right == null) {
				right_rank = -1;
			} else {
				right_rank = getRank(node.right, num);
			}
			return right_rank + 1 + node.left_size;
		}
	}
	
	public static void main(String[] args) {
		Solution10 s = new Solution10();
		s.track(5);
		s.track(1);
		s.track(4);
		s.track(4);
		s.track(5);
		s.track(9);
		s.track(7);
		s.track(13);
		s.track(3);
		System.out.println(s.getRankOfNumber(1));
		System.out.println(s.getRankOfNumber(3));
		System.out.println(s.getRankOfNumber(4));
	}
}
