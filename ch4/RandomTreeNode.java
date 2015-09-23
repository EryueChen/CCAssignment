package chapter4;

public class RandomTreeNode {
	public int value;
	public RandomTreeNode left;
	public RandomTreeNode right;
	public int size = 0;
	
	public RandomTreeNode(int value) {
		this.value = value;
		this.size = 1;
	}
	
	public int size() {
		return size;
	}
	
	//Recursively get the ith node from the tree
	public RandomTreeNode getIthNode(int i) {
		int leftSize = left == null ? 0 : left.size();
		if (i < leftSize) {
			return left.getIthNode(i);
		} else if (i == leftSize) {
			return this;
		} else {
			return right.getIthNode(i - (leftSize + 1));
		}
	}

	//When a value is to be inserted, insert it as inorder traversal
	public void insertInOrder(int value) {
		if (value <= this.value) {
			if (left == null) {
				left = new RandomTreeNode(value);
			} else {
				left.insertInOrder(value);
			}
		} else {
			if (right == null) {
				right = new RandomTreeNode(value);
			} else {
				right.insertInOrder(value);
			}
		}
		size++;
	}
	
	//Recursively find the node from subtree
	public RandomTreeNode find(int value) {
		if (value == this.value) {
			return this;
		} else if (value <= this.value) {
			return left != null ? left.find(value) : null;
		} else if (value > this.value) {
			return right != null ? right.find(value) : null;
		}
		return null;
	}

}
