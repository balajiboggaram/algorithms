/**
 * 
 */
package me.learn.personal.month4;

import java.util.Stack;

/**
 * Title 232 :
 * 
 * Implement the following operations of a queue using stacks.
 * 
 * push(x) -- Push element x to the back of queue. pop() -- Removes the element
 * from in front of queue. peek() -- Get the front element. empty() -- Return
 * whether the queue is empty.
 * 
 * Example:
 * 
 * MyQueue queue = new MyQueue();
 * 
 * queue.push(1); queue.push(2); queue.peek(); // returns 1 queue.pop(); //
 * returns 1 queue.empty(); // returns false
 * 
 * Notes:
 * 
 * You must use only standard operations of a stack -- which means only push to
 * top, peek/pop from top, size, and is empty operations are valid. Depending on
 * your language, stack may not be supported natively. You may simulate a stack
 * by using a list or deque (double-ended queue), as long as you use only
 * standard operations of a stack. You may assume that all operations are valid
 * (for example, no pop or peek operations will be called on an empty queue).
 * 
 * 
 * 
 * @author bramanarayan
 * @date Jul 27, 2020
 */
public class QueueUsingStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// idea:
// flush from s1 to s2 only when s2 is empty.
// push to s1
// pop from s2.
class MyQueue {
	
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();

    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s2.isEmpty()) { 
        	// copy from s1 ---> s2
        	while(!s1.isEmpty()) {
        		s2.push(s1.pop());
        	}
        }
        return !s2.isEmpty() ? s2.pop() : -1; // throw underflow exception
    }
    
    /** Get the front element. */
    public int peek() {
    	
    	// you can move this code to a common method such that can be used by both pop andpeek
    	 if(s2.isEmpty()) { 
         	// copy from s1 ---> s2
         	while(!s1.isEmpty()) {
         		s2.push(s1.pop());
         	}
         }
    	
    	
       return s2.peek(); 
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
