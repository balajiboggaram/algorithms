/**
 * 
 */
package me.learn.personal.month7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Title :
 * 
 * Date : Feb 27, 2021
 * 
 * @author bramanarayan
 *
 */
public class FIFOCache {

	class Node {
		String value;
		Node left;
		Node right;
	}

	private final HashMap<String, List<Node>> map;
	private final int maxSize;

	private Node head;
	private Node tail;
	private int size;

	public FIFOCache(int n) {
		maxSize = n;
		map = new HashMap<>(maxSize);
	}

	/**
	 * ADD METHOD
	 */
	void add(String element) {
		if (size == maxSize) {
			
			Node toRemove = head;
			// remove from list
			
			removeFromList(toRemove);
			// remove node from map
			
			List<Node> nodes = map.get(toRemove.value);
			Iterator<Node> iterator = nodes.iterator();
			while (iterator.hasNext()) {
				Node cur = iterator.next();
				if (cur == toRemove) {
					iterator.remove();
					break;
				}
			}
			if (nodes.size() == 0) {
				map.remove(toRemove.value);
			}
		}
		Node node = new Node();
		node.value = element;
		// add into list
		addLast(node);
		// add node into map
		List<Node> nodes = map.get(element);
		if (nodes == null) {
			nodes = new ArrayList<>(1);
			map.put(element, nodes);
		}
		nodes.add(node);
	}

	private void addLast(Node node) {
		if (tail == null) {
			head = tail = node;
		} else {
			tail.right = node;
			node.left = tail;
			tail = node;
		}
		size++;
	}

	private void removeFromList(Node toRemove) {
		if (toRemove == tail && toRemove == head) {
			tail = head = null;
		} else if (toRemove == head) {
			head = head.right;
			head.left = null;
		} else if (toRemove == tail) {
			tail = tail.left;
			tail.right = null;
		} else {
			toRemove.left.right = toRemove.right;
			toRemove.right.left = toRemove.left;
		}
		size--;
	}

	boolean contains(String element) {
		return map.containsKey(element);
	}

	void remove(String element) {
		List<Node> nodes = map.get(element);
		if (nodes != null) {
			// remove from map
			map.remove(element);
			for (Node node : nodes) {
				removeFromList(node);
			}
		}
	}

}