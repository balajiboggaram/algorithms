/**
 * 
 */
package me.learn.personal.mocks;

/**
 * Title 1578 :
 * 
 * Date : Feb 7, 2021
 * 
 * @author bramanarayan
 *
 */
public class MinimumCostOfDeletingCharacter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minCost(String s, int[] cost) {

		if(s == null) return 0;
		
		int n = s.length();

		int result = 0;

		int prev = 0;

		for (int i = 1; i < n; i++) {
			if(s.charAt(i) != s.charAt(prev)) {
				prev = i;
			} else {
				if(cost[i] <= cost[prev]) {  
					result += cost[i];
				} else {
					result += cost[prev];
					prev = i;
				}
			}
		}
		
		return result;

	}

}
