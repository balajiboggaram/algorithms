/**
 * 
 */
package me.learn.personal.month6;

import java.util.Stack;

/**
 * Title 1381 :
 * 
 * Date : Feb 6, 2021
 * 
 * @author bramanarayan
 *
 */
public class CustomStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


// This problem is similar to some other problem where we add/subtract the range i.j
class CustomStack1 {
	int n;
	int[] inc;
	Stack<Integer> stack;

	public CustomStack1(int maxSize) {
		n = maxSize;
		inc = new int[n];
		stack = new Stack<>();
	}

	public void push(int x) {
		if (stack.size() < n)
			stack.push(x);
	}

	public int pop() {
		// basically , this is the index of increment array
		int i = stack.size() - 1;
		if (i < 0)
			return -1;
		
		
		if (i > 0)
			inc[i - 1] += inc[i];
		
		int res = stack.pop() + inc[i];
		inc[i] = 0;
		return res;
	}

	public void increment(int k, int val) {
		int i = Math.min(k, stack.size()) - 1;
		if (i >= 0)
			inc[i] += val;
	}
}
