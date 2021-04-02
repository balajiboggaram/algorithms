/**
 * 
 */
package me.learn.personal.month6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Title 403 :
 * 
 * Date : Feb 7, 2021
 * 
 * @author bramanarayan
 *
 */
public class FrogJump {

	  
	public boolean canCrossBEST(int[] stones) {
		if (stones.length == 0) {
			return true;
		}

		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>(stones.length);
		map.put(0, new HashSet<Integer>());
		map.get(0).add(1);
		for (int i = 1; i < stones.length; i++) {
			map.put(stones[i], new HashSet<Integer>());
		}

		for (int i = 0; i < stones.length - 1; i++) {
			int stone = stones[i];
			
			Set<Integer> steps = map.get(stone);
			
			for (int stepLength : steps) {
				
				int reach = stone + stepLength;
				
				// Did I reach the last stone, then we are done, then return
				if (reach == stones[stones.length - 1]) {
					return true;
				}
				
				// I have a valid stone to jump, so I will add what the possible next positions can be.
				HashSet<Integer> set = map.get(reach);
				if (set != null) {
					set.add(stepLength);
					if (stepLength - 1 > 0)
						set.add(stepLength - 1);
					set.add(stepLength + 1);
				}
			}
		}

		return false;
	}


}
