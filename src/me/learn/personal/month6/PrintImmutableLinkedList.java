/**
 * 
 */
package me.learn.personal.month6;

import java.util.Stack;

/**
 * Title 1265 :
 * 
 * Date : Jan 14, 2021
 * 
 * @author bramanarayan
 *
 */
public class PrintImmutableLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// print all the nodes in reverse
	public void printLinkedListInReverse(ImmutableListNode head) {

		if (head == null)
			return;
		ImmutableListNode cur = head;

		// put all the nodes in stack
		Stack<ImmutableListNode> st = new Stack<ImmutableListNode>();
		while (cur != null) {
			st.push(cur);
			cur = cur.getNext();
		}

		// now print contents of stack
		while (!st.isEmpty()) {
			st.pop().printValue();
		}
	}

	// This do not use constant space.
	public void printLinkedListInReverseRecursion(ImmutableListNode head) {
		if (head == null) {
			return;
		}
		printLinkedListInReverse(head.getNext());
		head.printValue();
	}

	// OR

	// space less O(logn n)
	public void printLinkedListInReverseBEST(ImmutableListNode head) {
		if (head == null) {
			return;

		}

		helper(head, null);
	}

	private void helper(ImmutableListNode start, ImmutableListNode end) {
		if (start == null || start == end) {
			return;

		} else if (start.getNext() == end) {
			start.printValue();
			return;
		}

		ImmutableListNode slow = start, fast = start;

		while (fast != end && fast.getNext() != end) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}

		helper(slow, end);
		helper(start, slow);
	}

	// mock up interface
	class ImmutableListNode {

		void printValue() {

		}

		ImmutableListNode getNext() {
			return null;
		}

	}

}
