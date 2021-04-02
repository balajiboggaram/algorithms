/**
 * 
 */
package me.learn.personal.month7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title 465 :
 * 
 * Date : Feb 27, 2021
 * 
 * @author bramanarayan
 *
 */
public class AccountDebtBalancing {

	// [] -> i,j -> amount
	public int minTransfers(int[][] transactions) {

		// Prepare the ledger book i->j and j->i
		Map<Integer, Long> map = new HashMap();
		for (int[] t : transactions) {
			long val1 = map.getOrDefault(t[0], 0L);
			long val2 = map.getOrDefault(t[1], 0L);
			map.put(t[0], val1 - t[2]);
			map.put(t[1], val2 + t[2]);
		}

		// Add persons only with non-zero.
		// zero means - they dont own anything to anybody nor receive anything from
		// anybody.
		List<Long> list = new ArrayList();
		for (long val : map.values()) {
			if (val != 0)
				list.add(val);
		}

		// Only people with debts(give or receive)
		Long[] debts = new Long[list.size()];
		debts = list.toArray(debts);
		return helper(debts, 0, 0);

	}

	// Recursive Method to settle each person - one by one
	int helper(Long[] debts, int start, int count) {

		while (start < debts.length && debts[start] == 0)
			start++; // we already solved this position

		int res = Integer.MAX_VALUE;
		long previous = 0;
		
		// start,..(i) (i+1)........(debts-1)
		// -ve means - receive money
		// +ve means - give money to someone
		for (int i = start + 1; i < debts.length; i++) {
						
			if (debts[i] != previous && debts[start] * debts[i] < 0) {
				debts[i] = debts[i] + debts[start];
				res = Math.min(res, helper(debts, start + 1, count + 1));
				
				// Now backtrack here
				debts[i] = debts[i] - debts[start];
				previous = debts[i];
			}
		
		}
		return res == Integer.MAX_VALUE ? count : res;
	}

}
