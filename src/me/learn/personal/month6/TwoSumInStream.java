/**
 * 
 */
package me.learn.personal.month6;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 170 :
 * 
 * Date : Jan 14, 2021
 * 
 * @author bramanarayan
 *
 */
public class TwoSumInStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class TwoSum {
		private HashMap<Integer, Integer> map; // number -> count

		/** Initialize your data structure here. */
		public TwoSum() {
			this.map = new HashMap<Integer, Integer>();
		}

		/** Add the number to an internal data structure.. */
		public void add(int number) {
			
			map.put(number, map.getOrDefault(number, 0)+1);
		}

		// we could have done this with just hashset, but the input might contain dups
		/** Find if there exists any pair of numbers which sum is equal to the value. */
		public boolean find(int target) {
			
			for (Map.Entry<Integer, Integer> entry : this.map.entrySet()) {
				
				int complement = target - entry.getKey();

				if (complement != entry.getKey()) {
					if (this.map.containsKey(complement))
						return true;
				} else {
					// if complement is same as key 5 + 5 = 10
					if (entry.getValue() > 1)
						return true;
				}
			}
			return false;
		}
	}
}
