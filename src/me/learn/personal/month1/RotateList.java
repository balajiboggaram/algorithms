package me.learn.personal.month1;

import me.learn.utli.ListUtils;

/**
 * 
 * Title : Given a linked list, rotate the list to the right by k places, where
 * k is non-negative.
 * 
 * @author bramanarayan
 * @date May 6, 2020
 */
public class RotateList {

	public static void main(String args[]) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		// ListNode l4 = new ListNode(4);
		// ListNode l5 = new ListNode(5);

		l1.next = l2;
		l2.next = l3;
		// l3.next = l4;
		// l4.next = l5;

		RotateList solution = new RotateList();
		// ListNode head = solution.reverseList(l1);
		// ListUtils.printList(head);
		ListNode head = solution.rotateRight(l1, 4);
		ListUtils.printList(head);
	}
	
	/**
	 * LC solution 
	 */
	
	public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        ListNode current = head;
        ListNode tail = null;
        
        // Get LinkedList length
        while (current != null) {
            ++length;
            
            if (current.next == null) {
                tail = current;
            }
            
            current = current.next;            
        }
        
        if (length == 0 || length == 1) {
            return head;
        }
        
        k = k % length;
        
        if (k == 0) {
            return head;
        }
        
        return rotateRight(head, length, k);
    }
    
    private ListNode rotateRight(ListNode head, int length, int k) {
        
        // First let's determine cut point
        int cutPointIndex = length - k;
        ListNode cutPoint = head;
        
        for (int i = 0; i < cutPointIndex - 1; ++i) {
            cutPoint = cutPoint.next;
        }        
        
        // Get tail
        ListNode current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        
        ListNode tail = current.next;
        
        // Make new head the next of the cut point ...
        ListNode newHead = cutPoint.next;
        
        // Make next of tail, the old head ...
        tail.next = head;
        
        // Finally nullify cutpoint next to avoid circular referencing
        cutPoint.next = null;
        
        return newHead;
    }
    
    
    /*******/
	public ListNode rotateRightMy(ListNode head, int k) {

		if (head == null || k == 0)
			return head;

		int n = lengthList(head);
		
		if (n == 0 || n == 1)
			return head;
		
		k = k % n;
	
		// Reverse the given list
		head = reverseList(head);

		// Initialize the first list
		int count = 0;
		ListNode cur1 = head, head1 = head;
		while (cur1 != null && count < k - 1) {
			cur1 = cur1.next;
			count++;
		}

		if (cur1 == null)
			return head; // k > length of list

		ListNode head2 = cur1.next;
		cur1.next = null;

		head1 = reverseList(head1);
		head2 = reverseList(head2);

		head = head1;
		while (head1.next != null) {
			head1 = head1.next;
		}
		head1.next = head2;
		return head;
	}

	private int lengthList(ListNode head) {
		int count = 0;
		ListNode cur = head;
		while (cur != null) {
			cur = cur.next;
			count++;
		}
		System.out.println(count);
		return count;
	}

	/**
	 * Reverse a given single linked list in place
	 */
	private ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
		ListNode cur = null, first = head, temp = head;
		while (temp != null) {
			temp = first.next;
			first.next = cur;
			cur = first;
			first = temp;

		}
		return cur;
	}
}
