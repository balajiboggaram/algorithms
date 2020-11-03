package me.learn.personal.month1;

/**
 * 
 * Title : Given a (singly) linked list with head node root, write a function to
 * split the linked list into k consecutive linked list "parts".
 * 
 * The length of each part should be as equal as possible: no two parts should
 * have a size differing by more than 1. This may lead to some parts being null.
 * 
 * The parts should be in order of occurrence in the input list, and parts
 * occurring earlier should always have a size greater than or equal parts
 * occurring later.
 * 
 * Return a List of ListNode's representing the linked list parts that are
 * formed. Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4],
 * null ]
 * 
 * @author bramanarayan
 * @date May 12, 2020
 */
public class SplitLinkedList {

	public static void main(String args[]) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
		SplitLinkedList solution = new SplitLinkedList();
		solution.splitListToParts(l1, 4);
	}

	ListNode[] splitListToParts(ListNode root, int k) {

		ListNode[] result = new ListNode[k];
		if (root == null)
			return result;

		int n = listLength(root);
		int[] lengths = new int[k];
		if (n <= k) {
			for (int i = 0; i < n; i++) {
				lengths[i] = 1;
			}
		} else {
			for (int i = 0; i < k; i++) {
				lengths[i] = n / k;
			}
			int rem = n % k;
			for (int i = 0; i < rem; i++) {
				int value = lengths[i];
				lengths[i] = value + 1;
			}
		}

		ListNode cur = root;
		for (int i = 0; i < k; i++) {
			ListNode tempHead = new ListNode(0);
			ListNode temp = tempHead;
			int count = 0;
			while (cur != null && count < lengths[i]) {
				temp.next = cur;
				cur = cur.next;
				temp = temp.next;
				count++;
			}
			temp.next = null;
			result[i] = tempHead.next;
		}

		return result;
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
