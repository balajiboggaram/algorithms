/**
 * 
 */
package me.learn.personal.month3;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title 430 :
 * 
 * You are given a doubly linked list which in addition to the next and previous
 * pointers, it could have a child pointer, which may or may not point to a
 * separate doubly linked list. These child lists may have one or more children
 * of their own, and so on, to produce a multilevel data structure, as shown in
 * the example below.
 * 
 * Flatten the list so that all the nodes appear in a single-level, doubly
 * linked list. You are given the head of the first level of the list.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12] Output:
 * [1,2,3,7,8,11,12,9,10,4,5,6] Explanation:
 * 
 * The multilevel linked list in the input is as follows:
 * 
 * 
 * @author bramanarayan
 * @date Jul 10, 2020
 */
public class FalttenMultiLevelDoubleLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// ITERATIVE - USE STACK
	public Node flatten(Node head) {
		
		if(head == null) return head;

		Node pseudo = new Node(0, null, head, null);
		Node prev = pseudo;
		Deque<Node> st = new LinkedList<Node>();

		st.add(head);
		while (!st.isEmpty()) {
			Node cur = st.pop();
			
			// First push the next node, as this comes later point of time
			if(cur.next != null) {
				st.push(cur.next);
			}
			
			if(cur.child != null) {
				st.push(cur.child);
				cur.child = null; // mark this as single linked list . so no children
			}
			
			cur.prev = prev;
			prev.next = cur;
			prev = cur;
		}
		
		pseudo.next.prev = null;
		return pseudo.next;
	}

}

class Node {
	public int val;
	public Node prev;
	public Node next;
	public Node child;

	public Node(int i, Node prev, Node next, Node child) {
		this.val = i;
		this.prev = prev;
		this.next = next;
		this.child = child;
	}

}
