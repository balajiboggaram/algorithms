package me.learn.utli;

import me.learn.personal.month1.ListNode;

public class ListUtils {

	public static void printList(ListNode l) {
		while( l != null) {
			System.out.print(l.val);
			l =l.next;
		}
		System.out.println("");
	}
	
	public static void printList(Node l) {
		while( l != null) {
			System.out.print(l.val);
			l =l.next;
		}
		System.out.println("");
	}
}
