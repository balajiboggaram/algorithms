package me.learn.personal.month1;

/**
 * 
 * Title : Remove the Nth node from Single Linked list from end.
 * 
 * @author bramanarayan
 * @date Apr 27, 2020
 */
public class RemoveNthNode {

	public static void main(String args[]) {
		RemoveNthNode solution = new RemoveNthNode();
		/*ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);

		l1.next = l2; // 1-> 2 -> 3 -> 4 -> 5
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;*/

		
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);

		l1.next = l2; // 1-> 2 
	
		solution.removeNthFromEnd(l1, 2);

	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return null;
		ListNode cur = head, tail = head, prev = null;
		int i = 0;
		
		// Traverse for n nodes first
		while(tail != null && i< n) {
			System.out.println("value : " + tail.val);
			tail = tail.next;
			i++;
		}
		
		// check if the number of nodes are less than n.
		if (i != n) {
			return null; // solution not possible
		}
		
		while( tail != null) {
			tail = tail.next;
			prev = cur;
			cur = cur.next;
		}
		
		if(prev != null) {
			prev.next = cur.next ; // Remove the cur node 
		} else {
			printList(cur.next); // If the prev is null, then return the next pointer of cur. i.e we are deleting cur here.
			return cur.next;
		}
		printList(head);
		return head;
	}

	void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + "  -> ");
			node = node.next;
		}
		System.out.println("---");
	}

}
