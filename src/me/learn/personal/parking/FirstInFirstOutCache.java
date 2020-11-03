package me.learn.personal.parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import me.learn.personal.month1.ListNode;

/**
 * 
 * 
 * 
 * @author bramanarayan
 * @date May 15, 2020
 */
public class FirstInFirstOutCache {

}

class RandomizedSet1 {

	HashMap<Integer, ListNode> map;
	ListNode cur;
	int count;

	/** Initialize your data structure here. */
	public RandomizedSet() {
		map = new HashMap<Integer, ListNode>();
		cur = new ListNode(0);
		count = 0;
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if (map.containsKey(val))
			return false;
		ListNode temp = new ListNode(val);
		map.put(val, cur);
		cur.next = temp;
		cur = cur.next;
		count++;
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		if (!map.containsKey(val))
			return false;
		ListNode temp = map.get(val);
		cur.next = cur.next.next; // delete the node
		map.remove(val); // delete from the map
		count--;
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		Random r = new Random();
		r.nextInt(count);
		map.ge
	}
}
