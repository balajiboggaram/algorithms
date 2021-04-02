/**
 * 
 */
package me.learn.personal.month5;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 137 :
 * 
 * Date : Jan 1, 2021
 * 
 * @author bramanarayan
 *
 */
public class FindSingleNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int result ; 
	// every element appears 3 times except for one
	public int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		map.entrySet().forEach(x -> {
			 if(x.getValue() < 3) {
				 result = x.getKey();
				 
			 }
		});
		return result;
	}
	
	// Ne bonghu ley ra - how can one come up with this in interview :) 
	public int singleNumberConstantSpace(int[] nums) {
	    int seenOnce = 0, seenTwice = 0;

	    for (int num : nums) {
	      // first appearence: 
	      // add num to seen_once 
	      // don't add to seen_twice because of presence in seen_once

	      // second appearance: 
	      // remove num from seen_once 
	      // add num to seen_twice

	      // third appearance: 
	      // don't add to seen_once because of presence in seen_twice
	      // remove num from seen_twice
	      seenOnce = ~seenTwice & (seenOnce ^ num);
	      seenTwice = ~seenOnce & (seenTwice ^ num);
	    }

	    return seenOnce;
	  }

}
