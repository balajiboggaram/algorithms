/**
 * 
 */
package me.learn.personal.mocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Title 1512 :
 * 
 * Date : Feb 7, 2021
 * 
 * @author bramanarayan
 *
 */
public class Mock1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numIdenticalPairs(int[] nums) {

		int count = 0;

		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			map.computeIfAbsent(nums[i], x -> new ArrayList<Integer>()).add(i);
		}

		for (Entry<Integer, List<Integer>> e : map.entrySet()) {
			if (e.getValue().size() > 1) {
				int temp = e.getValue().size();
				count = count + (temp * (temp - 1)) / 2;
			}
		}

		return count;

	}

}
