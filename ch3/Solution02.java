package chapter3;

import java.util.Stack;

public class Solution02 extends Stack<Integer>{
	//Use a stack to push the smaller values
	//Each time if the current min is poped, also pop it from min stack
	Stack<Integer> s = new Stack<Integer>();
	public void push(int value) {
		if (value < min()) {
			s.push(value);
		}
		super.push(value);
	}
	
	public Integer pop() {
		int value = super.pop();
		if (value == min()) {
			s.pop();
		}
		return value;
	}
	
	public int min() {
		if (s.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return s.peek();
		}
	}
	
	public static void main(String[] args) {
		Solution02 s = new Solution02();
		s.push(10);
		s.push(2);
		s.push(5);
		System.out.println(s.min());
		System.out.println(s.pop());
		s.push(1);
		System.out.println(s.min());
		System.out.println(s.pop());
		System.out.println(s.min());
	}
 }
