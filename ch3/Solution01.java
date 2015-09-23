package chapter3;

import java.util.EmptyStackException;

public class Solution01 {
	//Use an array to store three stacks of fixed capacity. 
	//The pop and push action operate on the end of the corresponding array position
	//The end position of each stack is recorded
	
	static int numOfStack = 3;
	static int stackCapacity = 10;
	static int[] values = new int[stackCapacity * numOfStack];
	static int[] sizes = new int[numOfStack];

	//Push the value to end of corresponding array
	public static void push(int stackNum, int value) {
		if (sizes[stackNum] != stackCapacity) {
			values[stackNum * stackCapacity + sizes[stackNum]] = value;
			sizes[stackNum]++;
		} else {
			throw new RuntimeException();
		}
	}

	//pop the value from the end of corresponding array
	public static int pop(int stackNum) {
		if (sizes[stackNum] != 0) {
			int index = stackNum * stackCapacity + sizes[stackNum] - 1;
			int value = values[index];
			values[index] = 0;
			sizes[stackNum]--;
			return value;
		} else {
			throw new EmptyStackException();
		}
	}
	
	//peek the value from the end of corresponding array
	public static int peek(int stackNum) {
		if (sizes[stackNum] != 0) {
			int index = stackNum * stackCapacity + sizes[stackNum] - 1;
			int value = values[index];
			return value;
		} else {
			throw new EmptyStackException();
		}
	}
	
	public static void main(String[] args) {
		push(0, 1);
		push(1, 2);
		push(2, 3);
		push(0, 4);
		push(0, 5);
		System.out.println(pop(0));
		System.out.println(peek(1));
		System.out.println(peek(0));
		System.out.println(peek(1));
	}

}
