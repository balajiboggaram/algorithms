/**
 * 
 */
package me.learn.personal.month1;

/**
 * 
 * @author bramanarayan
 * @date May 14, 2020
 */
public class DeleteNodeList {

	public static void main(String[] args) {
		
	}

	public void deleteNode(ListNode node) {
		node.val = node.next.val; // Just copy the value of next node here
		node.next = node.next.next; // then delete the next code
	}

}
