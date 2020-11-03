package me.learn.utli;

/**
 * 
 * Title : A linked list node but with a random pointer
 * 
 * @author bramanarayan
 * @date May 7, 2020
 */
public class Node {

	public int val;
	public Node next;
	public Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}
