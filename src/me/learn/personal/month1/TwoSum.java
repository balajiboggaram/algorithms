package me.learn.personal.month1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String args[]) {
		
		TwoSum solution = new TwoSum();
		solution.twoSum(new int[] {2, 7, 11, 15}, 9); // 0 and 1
		solution.twoSum(new int[] {2, 7, 11, 15}, 18); // 1 and 2 
		solution.twoSum(new int[] {2, 7, 11, 15}, 17); // 0 and 3

	}

	public int[] twoSum(int[] nums, int target) {

	
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				result[0] = map.get(nums[i]);
				result[1] = i;
				System.out.println(result[0] + "   --> " + result[1]);
				return result;
			}
			map.put(target - nums[i], i);
		}
		return result;
	}
}
