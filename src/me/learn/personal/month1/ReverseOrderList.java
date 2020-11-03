package me.learn.personal.month1;

import java.util.Stack;

import me.learn.utli.ListUtils;

public class ReverseOrderList {

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
		
		ReverseOrderList solution = new ReverseOrderList();
		solution.reorderList(l1);
		ListUtils.printList(l1);
	}

	/**
	 * Push all the contents to stack, and then fetch half of it.
	 * Address both odd and even count cases in the list gracefully.
	 * 
	 * or 
	 * 
	 * you can just reverse the second half of the linked list.
	 * and then use merge step to merge the first half and second half.
	 */
	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;

		Stack<ListNode> s = new Stack<ListNode>();
		ListNode resultHead = new ListNode(0), result = resultHead;
		ListNode cur = head;
		int count = 0;
		while (cur != null) {
			s.push(cur);
			cur = cur.next;
			count++;
		}
		cur = head;
		System.out.println("Stack size : " + s.size());
		int i =0;
		while (i<count/2) {
			System.out.println(" Cur : " + cur.val);

			System.out.println(" Stack : " + s.peek().val);

			result.next = cur;
			cur = cur.next;
			result = result.next;
			result.next = s.pop();
			result = result.next;
			i++;
		}
		if(count % 2 != 0) {
			result.next = s.pop();
			result = result.next;
		}
		result.next = null;
	}
}
