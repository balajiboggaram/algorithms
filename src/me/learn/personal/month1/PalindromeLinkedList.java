package me.learn.personal.month1;

import java.util.Stack;

/**
 * 
 * Title : Given a singly linked list, determine if it is a palindrome.
 * 
 * @author bramanarayan
 * @date May 12, 2020
 */
public class PalindromeLinkedList {

	public static void main(String args[]) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(2);
		ListNode l6 = new ListNode(1);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;

		PalindromeLinkedList solution = new PalindromeLinkedList();
		System.out.println(solution.isPalindrome(l1));
	}

	/**
	 * Alternative : You can also solve this using O(1) space by reversing last half
	 * of the linked list. and then compare the 2 list halves equally.
	 */
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		int length = listLength(head);
		Stack<Integer> s = new Stack<Integer>();
		ListNode cur = head;
		int count = 0;
		while (cur != null && count < length / 2) {
			s.push(cur.val);
			cur = cur.next;
			count++;
		}

		// move if the length is odd.
		if (length % 2 != 0) {
			cur = cur.next;
		}

		while (!s.isEmpty()) {
			if (s.pop() != cur.val)
				return false;
			cur = cur.next;
		}
		return true;
	}

	private int listLength(ListNode root) {
		ListNode cur = root;
		int count = 0;
		while (cur != null) {
			count++;
			cur = cur.next;
		}
		return count;
	}
}
