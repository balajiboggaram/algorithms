package me.learn.personal.month1;

/**
 * 
 * Title : Given a linked list, return the node where the cycle begins. If there
 * is no cycle, return null.
 * 
 * To represent a cycle in the given linked list, we use an integer pos which
 * represents the position (0-indexed) in the linked list where tail connects
 * to. If pos is -1, then there is no cycle in the linked list.
 * 
 * @author bramanarayan
 * @date May 11, 2020
 */
public class LinkedListCycle2 {

	public static void main(String args[]) {

		LinkedListCycle2 solution = new LinkedListCycle2();
		ListNode l1 = new ListNode(3);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(0);
		ListNode l4 = new ListNode(4);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l1;

		ListNode result = solution.detectCycle(l1);
		System.out.println(result.val);
	}

	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		
		ListNode slow = head, fast = head; 
		  
        slow = slow.next; 
        fast = fast.next.next; 
  
        // Search for loop using slow and fast pointers 
        while (fast != null && fast.next != null) { 
            if (slow == fast) 
                break; 
  
            slow = slow.next; 
            fast = fast.next.next; 
        } 
  
        if (slow == fast) { 
            ListNode slow2 = head; 
            while (slow2 != slow) { 
                slow = slow.next; 
                slow2 = slow2.next;
            } 
            return slow;
        }

        return null;
	}

}
