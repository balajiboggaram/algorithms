/**
 * 
 */
package me.learn.personal.month7;

import java.util.ArrayList;
import java.util.List;

/**
 * Title : 
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class AllPossbileFactorsCombinationsOfNumber {

	// Example
/*
 * For example, n = 16. Let the variable i be from 2 to 4, 
 * when i = 2, then i is one factor of 16, and its corresponding factor is 8, 
 * so we add 2 and 8 to a temp list,
 *  then add the temp list to the result list. 
 *  And remove 8 from the temp list, and recursively do 8 from 2 to 2 for the same procedure.

The result should be:
[2, 8]
[2, 2, 4]
[2, 2, 2, 2]
[4, 4]
 */
	
	
	
	
	public List<List<Integer>> getFactors(int n) {
	    List<List<Integer>> res = new ArrayList<>();
	    backTrack(res, new ArrayList<Integer>(), 2, n);
	    return res;
	}

	// if i is the factor of n, then add i, n/i as 'one of the result'
	// after adding, remove the last element and then recur again
	
	public void backTrack(List<List<Integer>> res, List<Integer> cur, int start, int n) {
	    int upper = (int)Math.sqrt(n);
	    for(int i = start; i <= upper; i++) {
	        int factor = -1;
	        if(n % i == 0) {
	            factor = n/i;
	        }
	        if(factor != -1 && factor >= i) {
	            cur.add(i);
	            cur.add(factor);
	            res.add(new ArrayList<Integer>(cur));
	            cur.remove(cur.size()-1);
	            backTrack(res, cur, i, factor);
	            cur.remove(cur.size()-1);
	        }
	    }
	}
	
}
