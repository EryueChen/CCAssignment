package chapter4;

import java.util.Random;

public class Solution11 {
	
	RandomTreeNode root = null;
	
	public int size() {
		return root == null ? 0 : root.size();
	}
	
	//Retrieve a random number and find the corresponding node in the tree
	public RandomTreeNode getRandomNode() {
		if (root == null) return null;
		Random random = new Random();
		int i = random.nextInt(size());
		return root.getIthNode(i);
	}

	public void insertInOrder(int value) {
		if (root == null) {
			root = new RandomTreeNode(value);
		} else {
			root.insertInOrder(value);
		}
	}
	
	public static void main(String[] args) {
		Solution11 s = new Solution11();
		for (int i = 0; i < 7; i++) {
			s.insertInOrder(i);
		}
		System.out.println(s.getRandomNode().value);
	}

}
