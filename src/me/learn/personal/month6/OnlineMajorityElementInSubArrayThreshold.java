/**
 * 
 */
package me.learn.personal.month6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Title 1157 :
 * 
 * Date : Feb 7, 2021
 * 
 * @author bramanarayan
 *
 */
public class OnlineMajorityElementInSubArrayThreshold {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MajorityChecker {

	HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

	public MajorityChecker(int[] arr) {
		
		// put all the elements and their index positions in a map
		for (int i = 0; i < arr.length; i++) {
			ArrayList<Integer> temp = map.getOrDefault(arr[i], new ArrayList<Integer>());
			temp.add(i);
			map.put(arr[i], temp);
		}
	}

	public int query(int left, int right, int threshold) {
		
		for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
		
			ArrayList<Integer> temp = entry.getValue();
			
			if (temp.size() < threshold)
				continue;
			
			// the range will be [low,high]
			int low = Collections.binarySearch(temp, left);
			int high = Collections.binarySearch(temp, right);
			
			// if low or high is negative, means not found, will return (-insert postion - 1);
			
			if (low < 0)
				low = -low - 1;
			if (high < 0)
				high = (-high - 1) - 1;// make high positive, then high--
			
			
			if (high - low + 1 >= threshold)
				return entry.getKey();
		}
		return -1;
	}
}