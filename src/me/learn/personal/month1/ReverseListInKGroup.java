/**
 * 
 */
package me.learn.personal.month1;

/**
 * Title 25 :
 * 
 * Date : Jan 5, 2021
 * 
 * @author bramanarayan
 *
 */
public class ReverseListInKGroup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode reverseKGroup(ListNode head, int k) {

		ListNode current = head;
		ListNode next = null;
		ListNode prev = null;

		int count = 0;

		/* Reverse first k nodes of linked list */
		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		/*
		 * next is now a pointer to (k+1)th node Recursively call for the list starting
		 * from current. And make rest of the list as next of first node
		 */
		if (next != null)
			head.next = reverseKGroup(next, k);

		// prev is now head of input list
		return prev;
	}

	// oR
	// another lame approach
	public ListNode reverseLinkedList(ListNode head, int k) {

		// Reverse k nodes of the given linked list.
		// This function assumes that the list contains
		// atleast k nodes.
		ListNode new_head = null;
		ListNode ptr = head;

		while (k > 0) {

			// Keep track of the next node to process in the
			// original list
			ListNode next_node = ptr.next;

			// Insert the node pointed to by "ptr"
			// at the beginning of the reversed list
			ptr.next = new_head;
			new_head = ptr;

			// Move on to the next node
			ptr = next_node;

			// Decrement the count of nodes to be reversed by 1
			k--;
		}

		// Return the head of the reversed list
		return new_head;

	}

	public ListNode reverseKGroupBEST(ListNode head, int k) {

		int count = 0;
		ListNode ptr = head;

		// First, see if there are atleast k nodes
		// left in the linked list.
		while (count < k && ptr != null) {
			ptr = ptr.next;
			count++;
		}

		// If we have k nodes, then we reverse them
		if (count == k) {

			// Reverse the first k nodes of the list and
			// get the reversed list's head.
			ListNode reversedHead = this.reverseLinkedList(head, k);

			// Now recurse on the remaining linked list. Since
			// our recursion returns the head of the overall processed
			// list, we use that and the "original" head of the "k" nodes
			// to re-wire the connections.
			head.next = this.reverseKGroup(ptr, k);
			return reversedHead;
		}

		return head;
	}

}
