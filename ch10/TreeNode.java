package chapter10;

public class TreeNode {
	public int value;
	public TreeNode left;
	public TreeNode right;
	int left_size = 0;
	
	public TreeNode(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public void insert(int num) {
		if (this.value < num) {
			if (this.right == null) {
				this.right = new TreeNode(num);
			} else {
				this.right.insert(num);
			}
		} else {
			if (this.left == null) {
				this.left = new TreeNode(num);
			} else {
				this.left.insert(num);
			}
			this.left_size++;
		}
	}
}
