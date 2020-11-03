package me.learn.personal.month1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * 
 * Title 381 : Design a data structure that supports all following operations in
 * average O(1) time. Note: Duplicate elements are allowed.
 * 
 * insert(val): Inserts an item val to the collection. remove(val): Removes an
 * item val from the collection if present. getRandom: Returns a random element
 * from current collection of elements. The probability of each element being
 * returned is linearly related to the number of same value the collection
 * contains.
 * 
 * 
 * @author bramanarayan
 * @date May 15, 2020
 */
public class InsertDeleteGetRandomDuplicates {

}

class RandomizedCollection {

	// Value -> position in the array list
	HashMap<Integer, ArrayList<Integer>> map;
	ArrayList<Integer> list;

	/** Initialize your data structure here. */
	public RandomizedCollection() {
		map = new HashMap<Integer, ArrayList<Integer>>();
		list = new ArrayList<Integer>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if (map.containsKey(val)) {
			ArrayList<Integer> positionList = map.get(val);
			positionList.add(list.size());
			list.add(val);
			return false;
		} else {
			map.put(val, new ArrayList<>(Arrays.asList(list.size())));
			list.add(val);
		}
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 * 
	 * Swap the matched element with last element of array.
	 */
	public boolean remove(int val) {
		if (!map.containsKey(val))
			return false;

		ArrayList<Integer> elementPositions = map.get(val);
		int positionToDelete = elementPositions.get(elementPositions.size() - 1);

		// if the deleted element is not the last element.
		if (positionToDelete < list.size() - 1) {

			int lastElement = list.get(list.size() - 1); // What is the last value ?
			ArrayList<Integer> lastElementPositions = map.get(lastElement);
			list.set(positionToDelete, lastElement); // replace with lastElement now..

			lastElementPositions.set(lastElementPositions.size() - 1, positionToDelete); // add the new position

		}
		list.remove(list.size() - 1); // remove the last element which was been replaced.

		// Remove the value from map, If its duplicate then remove the position.
		if (elementPositions.size() == 1) {
			map.remove(val);
		} else {
			elementPositions.remove(elementPositions.size() - 1); // remove the position from the val element;
		}
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return list.get(new Random().nextInt(list.size()));
	}
}