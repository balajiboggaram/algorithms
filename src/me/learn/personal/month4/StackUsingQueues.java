/**
 * 
 */
package me.learn.personal.month4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title 225 :
 * 
 * Implement the following operations of a stack using queues.
 * 
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of
 * the stack. top() -- Get the top element. empty() -- Return whether the stack
 * is empty.
 * 
 * Example:
 * 
 * MyStack stack = new MyStack();
 * 
 * stack.push(1); stack.push(2); stack.top(); // returns 2 stack.pop(); //
 * returns 2 stack.empty(); // returns false
 * 
 * Notes:
 * 
 * You must use only standard operations of a queue -- which means only push to
 * back, peek/pop from front, size, and is empty operations are valid. Depending
 * on your language, queue may not be supported natively. You may simulate a
 * queue by using a list or deque (double-ended queue), as long as you use only
 * standard operations of a queue. You may assume that all operations are valid
 * (for example, no pop or top operations will be called on an empty stack).
 * 
 * 
 * 
 * @author bramanarayan
 * @date Jul 27, 2020
 */
public class StackUsingQueues {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// idea : 
//  2 queues :
// push -> O(1)
// pop -> O(n)
// we can also do in one queue. but at every pop, make sure you rotate n-1 elements in the same queue.
class MyStack {

	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<>();
	int top = -1;

	/** Initialize your data structure here. */
	public MyStack() {

	}

	// O(1) operation
	/** Push element x onto stack. */
	public void push(int x) {
		q1.add(x);
		top = x;
	}

	// O(n) operation
	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		int val = 0;
		// you need to remove the elements from q1 until it has one element in it. and
		// add to q1, swap q2 with q1
		while (q1.size() > 1) {
			top = q1.remove(); // running meter, the last will be the top
			q2.add(top);
		
		}
		val = q1.remove();
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
		return val;

	}

	/** Get the top element. */
	public int top() {
		return top;
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return q1.isEmpty() && q2.isEmpty();
	}
}
