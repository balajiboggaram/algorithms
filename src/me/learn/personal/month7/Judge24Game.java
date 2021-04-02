/**
 * 
 */
package me.learn.personal.month7;

import java.util.ArrayList;
import java.util.List;


/**
 * Title 24 :
 * 
 * Date : Feb 28, 2021
 * 
 * @author bramanarayan
 *
 */
public class Judge24Game {
	
	// CAN I GET 24 with 4 CARDS (1 to 9 value)

	public boolean judgePoint24(int[] nums) {
		List<Double> list = new ArrayList<>();
		 // add all numbers to list
		for (int i : nums) {
			list.add((double) i);
		}
		return dfs(list);
	}

	// find if we can get 24
	private boolean dfs(List<Double> list) {
		// if there is only one element
		if (list.size() == 1) {
			if (Math.abs(list.get(0) - 24.0) < 0.001) {
				return true;
			}
			return false;
		}

		// Take 2 numbers - find all the results - try to operate all possible operators on those just two numbers
		// now after done, prepare a list without those two numbers and recur again for DFS.
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				
				double val1 = list.get(i);
				double val2 = list.get(j);
				
				List<Double> values = generatePossibleResults(val1, val2);
				
				for (double c : values) {
					List<Double> nextRound = new ArrayList<>();
					nextRound.add(c);
					
					// add all other numbers except i and j. Both i and j are turned to one nubmer (after operation on them)
					for (int k = 0; k < list.size(); k++) {
						if (k == j || k == i)
							continue;
						nextRound.add(list.get(k));
					}
					if (dfs(nextRound))
						return true;
				}
			}
		}
		return false;

	}

	private List<Double> generatePossibleResults(double a, double b) {
		List<Double> res = new ArrayList<>();
		res.add(a + b);
		res.add(a - b);
		res.add(b - a);
		res.add(a * b);
		res.add(a / b);
		res.add(b / a);
		return res;
	}
}
