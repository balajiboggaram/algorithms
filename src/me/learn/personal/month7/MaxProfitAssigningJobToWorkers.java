/**
 * 
 */
package me.learn.personal.month7;

import java.util.Map;
import java.util.TreeMap;

/**
 * Title 826 :
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class MaxProfitAssigningJobToWorkers {

	public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

		// difficutlyLevel -> Max profit obtained from difficulty <= difficultyLevel
		TreeMap<Integer, Integer> tmap = new TreeMap<>();

		// init - difficultyLevel -> profit
		// in case two jobs have same difficulty but different profit, we want to count
		// the higher profit
		for (int i = 0; i < difficulty.length; i++) {
			tmap.put(difficulty[i], Math.max(profit[i], tmap.getOrDefault(difficulty[i], 0)));
		}

		int max = 0, res = 0;
		// Beauty : maximum profit at this difficulty or below in case lower difficulty
		// job offers higher profit
		for (Integer key : tmap.keySet()) {
			max = Math.max(tmap.get(key), max); // keep capturing the max profit from lower levels, and keep assigning
												// to higher difficutly level
			tmap.put(key, max);
		}

		// Now start the runner
		Map.Entry<Integer, Integer> entry = null;
		for (int i = 0; i < worker.length; i++) {
			if (tmap.containsKey(worker[i])) {
				res += tmap.get(worker[i]);
			} else {
				entry = tmap.floorEntry(worker[i]); // assign the job with less difficutly level than what a worker can
													// do, hence floor
				if (entry != null) {
					res += entry.getValue();
				}
			}
		}
		return res;
	}

}
