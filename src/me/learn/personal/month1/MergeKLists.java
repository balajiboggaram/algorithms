package me.learn.personal.month1;

import java.util.PriorityQueue;

import me.learn.utli.ListUtils;

/**
 * 
 * Title 23 : Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 * 
 * @author bramanarayan
 * @date May 14, 2020
 */
public class MergeKLists {

	public static void main(String args[]) {
		MergeKLists solution = new MergeKLists();

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;

		ListNode m1 = new ListNode(1);
		ListNode m2 = new ListNode(2);
		ListNode m3 = new ListNode(3);
		ListNode m4 = new ListNode(4);
		ListNode m5 = new ListNode(5);

		m1.next = m2;
		m2.next = m3;
		m3.next = m4;
		m4.next = m5;

		ListNode n1 = new ListNode(7);
		ListNode n2 = new ListNode(8);
		ListNode n3 = new ListNode(9);
		n1.next = n2;
		n2.next = n3;

		ListNode[] nList = new ListNode[] { l1, m1, n1 };
		ListNode result = solution.mergeKLists(nList);
		ListUtils.printList(result);

	}

	public ListNode mergeKLists(ListNode[] lists) {

		if (lists == null || lists.length == 0)
			return null;

		PriorityQueue<MergeTuple> queue = new PriorityQueue<MergeTuple>();

		int n = lists.length;

		// Add all the first nodes in the list of lists
		for (int i = 0; i < n; i++) {
			
			if(lists[i] != null) 
			queue.offer(new MergeTuple(lists[i]));
		}

		ListNode resultHead = new ListNode(0);
		ListNode result = resultHead;

		// Try to iterate the list
		while (!queue.isEmpty()) {
			MergeTuple temp = queue.poll();
			result.next = temp.node;
			result = result.next;

			if (temp.node.next == null)
				continue; // if a list has only few elements

			queue.offer(new MergeTuple(temp.node.next));
		}
		return resultHead.next;
	}

}

class MergeTuple implements Comparable<MergeTuple> {

	ListNode node;

	public MergeTuple(ListNode node) {
		this.node = node;
	}

	@Override
	public int compareTo(MergeTuple o) {
		return this.node.val - o.node.val;
	}

}
