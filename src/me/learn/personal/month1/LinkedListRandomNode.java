package me.learn.personal.month1;

import java.util.Random;

/**
 * 
 * Title : Given a singly linked list, return a random node's value from the
 * linked list. Each node must have the same probability of being chosen.
 * 
 * Follow up: What if the linked list is extremely large and its length is
 * unknown to you? Could you solve this efficiently without using extra space?
 * Answer is : Reservior Sampling
 * 
 * @author bramanarayan
 * @date May 8, 2020
 */
public class LinkedListRandomNode {

	int n;
	ListNode head;

	public LinkedListRandomNode(ListNode head) {
		this.head = head;
		n = 0;
		ListNode cur = head;
		while (cur != null) {
			n++;
			cur = cur.next;
		}
	}

	public int getRandom() {

		Random r = new Random();
		int x = r.nextInt(n);
		ListNode cur = head;
		int c = 0;
		while (cur != null && c != x) {
			cur = cur.next;
			c++;
		}
		return cur.val;
	}
	
	/**
	 * Extension question : 
	 * 
	 * Example

    Choose 3 numbers from [111, 222, 333, 444]. Make sure each number is selected with a probability of 3/4
    First, choose [111, 222, 333] as the initial reservior
    Then choose 444 with a probability of 3/4
    For 111, it stays with a probability of
        P(444 is not selected) + P(444 is selected but it replaces 222 or 333)
        = 1/4 + 3/4*2/3
        = 3/4
    The same case with 222 and 333
    Now all the numbers have the probability of 3/4 to be picked


THIS PROBLEM IS SPECIAL THAT WHERE k = 1.

1) Create an array reservoir[0..k-1] and copy first k items of stream[] to it.
2) Now one by one consider all items from (k+1)th item to nth item.
…a) Generate a random number from 0 to i where i is index of current item in stream[]. Let the generated random number is j.
…b) If j is in range 0 to k-1, replace reservoir[j] with arr[i]
	
	 */

}
