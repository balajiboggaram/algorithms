package me.learn.personal.month4;
import java.util.Hashtable;

public class LRUCacheCustomDLL {

}


class LRUCache {

	class DLinkedNode {
		int key;
		int value;
		DLinkedNode left;
		DLinkedNode right;
	}

	/**
	 * Always add the new node right after head;
	 */
	private void addNode(DLinkedNode node) {

		node.left = head;
		node.right = head.right;

		head.right.left = node;
		head.right = node;
	}

	/**
	 * Remove an existing node from the linked list.
	 */
	private void removeNode(DLinkedNode node) {
		DLinkedNode pre = node.left;
		DLinkedNode post = node.right;

		pre.right = post;
		post.left = pre;
	}

	/**
	 * Move certain node in between to the head.
	 */
	private void moveToHead(DLinkedNode node) {
		this.removeNode(node);
		this.addNode(node);
	}

// pop the current tail. 
	private DLinkedNode popTail() {
		DLinkedNode res = tail.left;
		this.removeNode(res);
		return res;
	}

	private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
	private int count;
	private int capacity;
	private DLinkedNode head, tail;

	public LRUCache(int capacity) {
		this.count = 0;
		this.capacity = capacity;

		head = new DLinkedNode();
		head.left = null;

		tail = new DLinkedNode();
		tail.right = null;

		head.right = tail;
		tail.left = head;
	}

	public int get(int key) {

		DLinkedNode node = cache.get(key);
		if (node == null) {
			return -1; // should raise exception here.
		}

		// move the accessed node to the head;
		this.moveToHead(node);

		return node.value;
	}

	public void put(int key, int value) {
		DLinkedNode node = cache.get(key);

		if (node == null) {

			DLinkedNode newNode = new DLinkedNode();
			newNode.key = key;
			newNode.value = value;

			this.cache.put(key, newNode);
			this.addNode(newNode);

			++count;

			if (count > capacity) {
				// pop the tail
				DLinkedNode tail = this.popTail();
				this.cache.remove(tail.key);
				--count;
			}
		} else {
			// update the value.
			node.value = value;
			this.moveToHead(node);
		}
	}

}