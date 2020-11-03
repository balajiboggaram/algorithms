package me.learn.personal.month1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * 
 * Title : 380 NO duplicates allowed
 * 
 * @author bramanarayan
 * @date May 15, 2020
 */
public class InsertDeleteGetRandom {
	
}

/**
 * 
 * Array list time complexity: 
 * 
 * get/read :  O(1) since you can seek the address directly from base
 * remove/delete : O(n) why ? Because once we delete the element at index, then we need to move the after values one by one to the left. 
 * add : O(1) becuase you always add the end of the array - next free address available.
 * update : O(1) since you are just changing the value but nothing value moving....across the array.
 * 
 */
class RandomizedSet {

	// Value -> position in the array list
	HashMap<Integer, Integer> map;
	ArrayList<Integer> list;

	/** Initialize your data structure here. */
	public RandomizedSet() {
		map = new HashMap<Integer, Integer>();
		list = new ArrayList<Integer>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if(map.containsKey(val)) return false;
		map.put(val, list.size());
		list.add(val);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 * 
	 * Swap the matched element with last element of array.
	 */
	public boolean remove(int val) {
		if(!map.containsKey(val)) return false;
		int position = map.get(val); 
		// if the deleted element is not the last element.
		if(position < list.size() -1 ) {
			int lastElement = list.get(list.size() -1); // What is the last value ?
			list.set(position, lastElement); // Set the last element in place where we just deleted
			map.put(lastElement, position); // Adjust the value of lastElement now.			
		}
		list.remove(list.size()-1); // remove the last element as its not needed.
		map.remove(val); // remove the value entry from map
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return list.get(new Random().nextInt(list.size()));
	}
}