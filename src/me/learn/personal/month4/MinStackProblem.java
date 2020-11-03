/**
 * 
 */
package me.learn.personal.month4;

import java.util.Stack;

/**
 * Title 155 :
 * 
 *  Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2

 * 
 * @author bramanarayan
 * @date Jul 26, 2020
 */
public class MinStackProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// TWO STACKS
class MinStack {
	
	Stack<Integer> minStack = new Stack<Integer>();
	Stack<Integer> st = new Stack<Integer>();

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if(st.isEmpty()) {
        	st.push(x);
        	minStack.push(x);
        } else {
        	// found a better minimum
        	if(!minStack.isEmpty() && x <= minStack.peek()) {
        		minStack.push(x);
        	}
        	st.push(x);
        }
    }
    
    public void pop() {
        int x = st.pop();
        if(minStack.peek() == x) {
        	minStack.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
