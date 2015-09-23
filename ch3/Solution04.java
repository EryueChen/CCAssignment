package chapter3;

import java.util.Stack;

public class Solution04 {
	//Push the values to the first stack
	//When the value is needed for dequeue,
	//pop all the values from the first stack and push to the second stack
	//Now the value added first is on the top of the second stack
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void add(int value) {
		stack1.push(value);
	}
	
	public int peek() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.peek();
	}
	
	public int pop() {
		peek();
		return stack2.pop();
	}
	
	public static void main(String[] args) {
		Solution04 s = new Solution04();
		s.add(1);
		s.add(2);
		s.add(3);
		System.out.println(s.peek());
		System.out.println(s.pop());
		s.add(4);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

}
