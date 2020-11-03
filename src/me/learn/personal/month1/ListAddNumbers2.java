package me.learn.personal.month1;

import me.learn.utli.ListUtils;

public class ListAddNumbers2 {
	
	public static void main(String args[]) {
		
		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(3);

		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListAddNumbers2 solution = new ListAddNumbers2();
		ListNode result = solution.addTwoNumbers(l1, l2);
		ListUtils.printList(result);

	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode m1 = reverse(l1);
		ListNode m2 = reverse(l2);
		return reverse(addTwoNumbers1(m1, m2));
	}

	/**
	 * This is same as AddTwoNumbers solution, Just copied here...
	 * 
	 * If the reverse is not allowed. Just use stacks - 3 stacks. 
	 * 2 for input stacks 
	 * 1 for result stack. 
	 * convert the result stack to linkedlist.
	 */
	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;

		if (l2 == null)
			return l1;

		ListNode result = null;
		ListNode resultHead = null;
		int resDigit = 0, carry = 0;

		while (l1 != null || l2 != null) {
			int x = (l1 == null) ? 0 : l1.val;
			int y = (l2 == null) ? 0 : l2.val;
			int sum = x + y + carry;

			resDigit = sum % 10;
			System.out.println(resDigit);
			carry = sum / 10;

			if (result == null) {
				result = new ListNode(resDigit);
				resultHead = result;
			} else {
				ListNode n = new ListNode(resDigit);
				result.next = n;
				result = n;
			}

			if (l1 != null) {
				l1 = l1.next;
			}

			if (l2 != null) {
				l2 = l2.next;
			}
		}

		if (carry > 0) {
			ListNode n = new ListNode(carry);
			result.next = n;
		}

		return resultHead;
	}
	
	/* Function to reverse the linked list */
	ListNode reverse(ListNode node) {
		ListNode prev = null;
		ListNode current = node;
		ListNode next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}
}
