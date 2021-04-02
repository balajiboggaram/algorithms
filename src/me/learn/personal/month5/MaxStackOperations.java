/**
 * 
 */
package me.learn.personal.month5;

import java.util.Stack;

/**
 * Title 716 :
 * 
 * Date : Dec 31, 2020
 * 
 * @author bramanarayan
 *
 */
public class MaxStackOperations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MaxStack {
	Stack<Integer> stack;
	Stack<Integer> maxStack;

	public MaxStack() {
		stack = new Stack();
		maxStack = new Stack();
	}

	// for every element you add, you also add the element in maxStack 
	public void push(int x) {
		int max = maxStack.isEmpty() ? x : maxStack.peek();
		maxStack.push(max > x ? max : x);
		stack.push(x);
	}

	public int pop() {
		maxStack.pop();
		return stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int peekMax() {
		return maxStack.peek();
	}

	// basically use temporary memory to swap from/to original stack
	public int popMax() {

		Stack<Integer> buffer = new Stack<Integer>();
		int max = maxStack.peek();
		// until you see the max element in original stack, keep popping to buffer stack
		while (max != stack.peek()) {
			buffer.push(stack.pop());
			maxStack.pop();
		}

		stack.pop(); // pop the max element in original stack now.
		maxStack.pop(); // pop from maxstack too

		while (!buffer.isEmpty()) {
			push(buffer.pop()); // too much - reapeat again push operations from buffer.
		}
		return max;

	}
}
