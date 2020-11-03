package me.learn.personal.month1;

import me.learn.utli.Node;

/**
 * 
 * Title : Copy List with Random Pointer
 * 
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * The Linked List is represented in the input/output as a list of n nodes. Each
 * node is represented as a pair of [val, random_index] where:
 * 
 * val: an integer representing Node.val random_index: the index of the node
 * (range from 0 to n-1) where random pointer points to, or null if it does not
 * point to any node.
 * 
 * 
 * @author bramanarayan
 * @date May 7, 2020
 */
public class RandomDeepCopyList {

	public static void main(String args[]) {

		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);

		n1.next = n2;
		n1.random = n4;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		RandomDeepCopyList solution = new RandomDeepCopyList();
		solution.copyRandomList(n1);
	}

	public Node copyRandomList(Node head) {

		if (head == null)
			return head;

		/*
		 * create duplicate nodes and stick them in between the original nodes
		 */
		Node cur = head;
		while (cur != null) {
			Node temp = new Node(cur.val);
			temp.next = cur.next;
			cur.next = temp;
			cur = temp.next;
		}

		// Fix the random pointers now
		cur = head;
		Node copy = head.next;
		while (cur != null) {
			if (cur.random != null) {
				copy.random = cur.random.next; // fix the copy random pointer
			}
			if (cur.next.next != null) {
				cur = cur.next.next;
				copy = cur.next;
			} else {
				break;
			}
		}

		// Now, separate the lists
		cur = head;
		copy = head.next;
		Node copyHead = copy;
		while (cur != null) {
			System.out.println(cur.val);

			cur.next = copy.next;
			cur = cur.next;
			if (cur != null) { // that last cur node will be null
				copy.next = cur.next;
				copy = copy.next;
			}
		}
		return copyHead;
	}

}
