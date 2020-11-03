/**
 * 
 */
package me.learn.personal.month3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Title 983 :
 * 
 * In a country popular for train travel, you have planned some train travelling
 * one year in advance. The days of the year that you will travel is given as an
 * array days. Each day is an integer from 1 to 365.
 * 
 * Train tickets are sold in 3 different ways:
 * 
 * a 1-day pass is sold for costs[0] dollars; a 7-day pass is sold for costs[1]
 * dollars; a 30-day pass is sold for costs[2] dollars.
 * 
 * The passes allow that many days of consecutive travel. For example, if we get
 * a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7,
 * and 8.
 * 
 * Return the minimum number of dollars you need to travel every day in the
 * given list of days.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: days = [1,4,6,7,8,20], costs = [2,7,15] Output: 11 Explanation: For
 * example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1. On
 * day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4,
 * ..., 9. On day 20, you bought a 1-day pass for costs[0] = $2, which covered
 * day 20. In total you spent $11 and covered all the days of your travel.
 * 
 * 
 * @author bramanarayan
 * @date Jul 6, 2020
 */
public class MinimumCostTickets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	// DYNAMIC PROGRAMMING
	public int mincostTickets(int[] days, int[] costs) {

		List<Integer> travelDates = Arrays.stream(days).boxed().collect(Collectors.toList());

		int[] minCost = new int[366];
		minCost[0] =0;
		for (int i = 1; i < 366; i++) {

			// if I am not travelling on day i, then i am not spending anything today.
			// cost is same as yesterday
			if (!travelDates.contains(i)) {
				minCost[i] = minCost[i - 1];
				continue;
			}

			int prev0 = minCost[i - 1] + costs[0];
			int prev7Day = minCost[Math.max(0, i - 7)] + costs[1];
			int prev30Day = minCost[Math.max(0, i - 30)] + costs[2];

			minCost[i] = Math.min(prev0, Math.min(prev7Day, prev30Day));

		}

		return minCost[365];
	}

}
