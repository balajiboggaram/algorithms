/**
 * 
 */
package me.learn.personal.month6;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 460 :
 * 
 * Date : Feb 7, 2021
 * 
 * @author bramanarayan
 *
 */
public class LFUCache {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class A460_LFUCache {

	final int capacity;
	int curSize;
	int minFrequency;
	Map<Integer, DLLNode> cache;
	Map<Integer, DoubleLinkedList> frequencyMap;

	public A460_LFUCache(int capacity) {
		this.capacity = capacity;
		this.curSize = 0;
		this.minFrequency = 0;

		this.cache = new HashMap<>();
		this.frequencyMap = new HashMap<>();
	}

	/**
	 * get node value by key, and then update node frequency as well as relocate
	 * that node
	 **/
	public int get(int key) {
		DLLNode curNode = cache.get(key);
		if (curNode == null) {
			return -1;
		}
		updateNode(curNode);
		return curNode.val;
	}

	/**
	 * add new node into LFU cache, as well as double linked list condition 1: if
	 * LFU cache has input key, update node value and node position in list
	 * condition 2: if LFU cache does NOT have input key - sub condition 1: if LFU
	 * cache does NOT have enough space, remove the Least Recent Used node in
	 * minimum frequency list, then add new node - sub condition 2: if LFU cache has
	 * enough space, add new node directly
	 **/
	public void put(int key, int value) {
		// corner case: check cache capacity initialization
		if (capacity == 0) {
			return;
		}

		if (cache.containsKey(key)) {
			DLLNode curNode = cache.get(key);
			curNode.val = value;
			updateNode(curNode);
		} else {
			curSize++;
			if (curSize > capacity) {
				// get minimum frequency list
				DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
				DLLNode deleteNode = minFreqList.removeTail();
				cache.remove(deleteNode.key);
				curSize--;
			}
			// reset min frequency to 1 because of adding new node
			minFrequency = 1;
			DLLNode newNode = new DLLNode(key, value);

			// get the list with frequency 1, and then add new node into the list, as well
			// as into LFU cache
			DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
			curList.addNode(newNode);
			frequencyMap.put(1, curList);
			cache.put(key, newNode);
		}
	}

	public void updateNode(DLLNode curNode) {
		int curFreq = curNode.frequency;
		DoubleLinkedList curList = frequencyMap.get(curFreq);
		curList.removeNode(curNode);

		// if current list the the last list which has lowest frequency and current node
		// is the only node in that list
		// we need to remove the entire list and then increase min frequency value by 1
		if (curFreq == minFrequency && curList.listSize == 0) {
			minFrequency++;
		}

		curNode.frequency++;
		// add current node to another list has current frequency + 1,
		// if we do not have the list with this frequency, initialize it
		DoubleLinkedList newList = frequencyMap.getOrDefault(curNode.frequency, new DoubleLinkedList());
		newList.addNode(curNode);
		frequencyMap.put(curNode.frequency, newList);
	}

	/*
	 * @param key: node key
	 * 
	 * @param val: node value
	 * 
	 * @param frequency: frequency count of current node (all nodes connected in
	 * same double linked list has same frequency)
	 * 
	 * @param prev: previous pointer of current node
	 * 
	 * @param next: next pointer of current node
	 */
	class DLLNode {
		int key;
		int val;
		int frequency;
		DLLNode prev;
		DLLNode next;

		public DLLNode(int key, int val) {
			this.key = key;
			this.val = val;
			this.frequency = 1;
		}
	}

	/*
	 * @param listSize: current size of double linked list
	 * 
	 * @param head: head node of double linked list
	 * 
	 * @param tail: tail node of double linked list
	 */
	class DoubleLinkedList {
		int listSize;
		DLLNode head;
		DLLNode tail;

		public DoubleLinkedList() {
			this.listSize = 0;
			this.head = new DLLNode(0, 0);
			this.tail = new DLLNode(0, 0);
			head.next = tail;
			tail.prev = head;
		}

		/** add new node into head of list and increase list size by 1 **/
		public void addNode(DLLNode curNode) {
			DLLNode nextNode = head.next;
			curNode.next = nextNode;
			curNode.prev = head;
			head.next = curNode;
			nextNode.prev = curNode;
			listSize++;
		}

		/** remove input node and decrease list size by 1 **/
		public void removeNode(DLLNode curNode) {
			DLLNode prevNode = curNode.prev;
			DLLNode nextNode = curNode.next;
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
			listSize--;
		}

		/** remove tail node **/
		public DLLNode removeTail() {
			// DO NOT FORGET to check list size
			if (listSize > 0) {
				DLLNode tailNode = tail.prev;
				removeNode(tailNode);
				return tailNode;
			}
			return null;
		}
	}
}