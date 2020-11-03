/**
 * 
 */
package me.learn.personal.month4;

import javax.xml.soap.Node;

import me.learn.utli.TreeNode;

/**
 * Title 641 :
 *  
 *  Design a circular deque.
 *  
 *  Your implementation should support following operations:

    MyCircularDeque(k): Constructor, set the size of the deque to be k.
    insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
    insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
    deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
    deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
    getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
    getRear(): Gets the last item from Deque. If the deque is empty, return -1.
    isEmpty(): Checks whether Deque is empty or not. 
    isFull(): Checks whether Deque is full or not.

 
 * 
 * @author bramanarayan
 * @date Jul 29, 2020
 */
public class DesignCircularDeque {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// I am using Doubly Linked List approach
class MyCircularDeque {
	
	TreeNode head = new TreeNode(-1);
	TreeNode tail = new TreeNode(-1);
	int size;
	int capacity;
	
		// Head <-> tail
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        head.right = tail;
        tail.left = head;
        capacity = k;
        size = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(size == capacity) return false;
        TreeNode temp = new TreeNode(value);
        TreeNode next = head.right;
        
        temp.right = next;
        next.left = temp;
        head.right = temp;
        temp.left = head;
        
        size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(size == capacity) return false;
        TreeNode temp = new TreeNode(value);
        
        TreeNode prev = tail.left;
        prev.right = temp;
        temp.left = prev;
        temp.right = tail;
        tail.left = temp;
        
        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(size == 0) return false; // nothing to delte
        TreeNode next = head.right.right;
        head.right = next;
        next.left = head;
        size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(size == 0) return false;
        TreeNode prev = tail.left.left;
        prev.right = tail;
        tail.left = prev;
        size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(size == 0) return -1;
        return head.right.val;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        
    	if(size == 0) return -1;
    	return tail.left.val;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
