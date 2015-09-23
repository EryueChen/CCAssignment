package chapter3;

import java.util.ArrayList;
import java.util.Stack;

public class Solution03 {
	//Use an index value to record the current using stack
	//If the current stack is empty, decrement the index and pop from previous stack
	//If the current stack is full, increment the index and push to next stack
	
	ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
	int index = -1;
	int capacity = 3;
	
	public void push(int value) {
		if (index < 0 || stacks.get(index).size() == capacity) {
			stacks.add(new Stack<Integer>());
			index++;
		}
		stacks.get(index).push(value);
	}
	
	public int pop() {
		while (stacks.get(index).isEmpty()){
			index--;
		}
		return stacks.get(index).pop();
	}
	
	public int popAt(int i) {
		return stacks.get(i).pop();
	}
	
	public static void main(String[] args) {
		Solution03 s = new Solution03();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		System.out.println(s.pop());
		System.out.println(s.popAt(0));
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		
	}

}
