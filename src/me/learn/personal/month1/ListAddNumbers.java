package me.learn.personal.month1;

public class ListAddNumbers {

	public static void main(String args[]) {
		
		// l1 = 2 -> 4 -> 3
		// l2 = 5 -> 6 -> 4
		// result = 7 -> 0 -> 8
/*
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

*/	
		
		// 1->8
		// 0
		// result : 1 -> 8
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(8);

		ListNode l2 = new ListNode(0);
		
		ListAddNumbers solution = new ListAddNumbers();
		ListNode result = solution.addTwoNumbers(l1, l2);
		solution.printList(result);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
	 
	void printList(ListNode node) {
		 while (node != null) {
			 System.out.print(node.val + "  -> " );
			 node = node.next;
		 }
		 System.out.println("---");
	 }

}
