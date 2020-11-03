/**
 * 
 */
package me.learn.personal.month3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Title 1086 :
 * 
 * Given a list of scores of different students, return the average score of
 * each student's top five scores in the order of each student's id.
 * 
 * Each entry items[i] has items[i][0] the student's id, and items[i][1] the
 * student's score. The average score is calculated using integer division.
 *
 * Example 1:
 * 
 * Input:
 * [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * Output: [[1,87],[2,88]] Explanation: The average of the student with id = 1
 * is 87. The average of the student with id = 2 is 88.6. But with integer
 * division their average converts to 88.
 * 
 * @author bramanarayan
 * @date Jul 15, 2020
 */
public class HighFive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	// SORTING + TOP 5
	public int[][] highFive(int[][] items) {

		int n = items.length;
		Map<Integer, List<Integer>> m = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < n; i++) {
			if (m.containsKey(items[i][0])) {
				m.get(items[i][0]).add(items[i][1]);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(items[i][1]);
				m.put(items[i][0], list);
			}
		}

		// compute average now
		int[][] res = new int[m.size()][m.size()];
		int k = 0;
		for(Entry<Integer,List<Integer>> e : m.entrySet()) {
			
			// sort in descending order for top 5 elements
			Collections.sort(e.getValue(), Collections.reverseOrder());
			int tempResult = 0;

			for(int i = 0;i<5;i++) {
				tempResult += e.getValue().get(i);
			}
			
			res[k] = new int[] {e.getKey(), tempResult/5 };
			k++;
		}
		
		return res;
	}

}
