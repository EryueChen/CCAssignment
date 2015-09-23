package chapter3;

import java.util.Stack;

public class Solution05 {
	//Use a stack to store all the sorted values
	//Pop the value from original stack and compare with the values in sorted stack
	//If the top of sorted stack is smaller than the current value,
	//pop it from the sorted stack and push back to the original one
	
	public static Stack<Integer> sortStack(Stack<Integer> stack) {
		Stack<Integer> sortedStack = new Stack<Integer>();
		while (!stack.isEmpty()) {
			int val = stack.pop();
			if (!sortedStack.isEmpty()) {
				int top = sortedStack.peek();
				while (top < val) {
					int other = sortedStack.pop();
					stack.push(other);
					top = sortedStack.peek();
				}
			}
			sortedStack.push(val);
		}
		return sortedStack;
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.push(2);
		stack.push(4);
		stack.push(1);
		stack.push(5);
		Stack<Integer> sortedStack = sortStack(stack);
		while (!sortedStack.isEmpty()) {
			System.out.println(sortedStack.pop());
		}

	}

}
