package me.learn.personal.month1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 
 * Title : Next Greater Node In Linked List
 * 
 * @author bramanarayan
 * @date May 7, 2020
 */
public class NextGreaterElementList {

	public static void main(String args[]) {

		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(5 );
		//ListNode l4 = new ListNode(3);
		//ListNode l5 = new ListNode(5);

		l1.next = l2;
		l2.next = l3;
		//l3.next = l4;
		//l4.next = l5;

		NextGreaterElementList solution = new NextGreaterElementList();
		solution.nextLargerNodes(l1);

	}

	public int[] nextLargerNodes(ListNode head) {
		ListNode cur = head;
		List<Integer> list = new ArrayList<Integer>();
		while (cur != null) {
			list.add(cur.val);
			cur = cur.next;
		}

		int n = list.size();
		int[] result = new int[n];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = n - 1; i >= 0; i--) {
			if (stack.isEmpty()) {
				result[i] = 0;
			} else {
				// keep popping all the elements smaller than ith element from stack
				while (!stack.isEmpty() && stack.peek() <= list.get(i)) {
					stack.pop();
				}
				// lets assign the value in result - which is next greatest element
				result[i] = stack.isEmpty() ? 0 : stack.peek();
			}
			stack.push(list.get(i));
		}
		System.out.println(Arrays.toString(result));
		return result;
	}
}
