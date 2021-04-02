/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Title 491 :
 * 
 * Date : Dec 21, 2020
 * 
 * @author bramanarayan
 *
 */
public class IncreasingSubsequences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IncreasingSubsequences solution = new IncreasingSubsequences();
		System.out.println(solution.findSubsequences(new int[] {4,6,7,7}));
		
	}

	// pure back tracking. 
	public List<List<Integer>> findSubsequences(int[] a) {

		Set<List<Integer>> result = new HashSet<>();
		
		int n = a.length;
		
		findUtil(a, result, new ArrayList<Integer>(), 0);
		
		return new ArrayList(result);

	}

	// temp - will always contain increasing subsequences seen so far
	private void findUtil(int[] a, Set<List<Integer>> result, ArrayList<Integer> temp, int start) {
		
		
		if(temp.size() > 1) {
			result.add(new ArrayList<Integer>(temp)); // new is very important as its a copy.
		}
		
		for(int i = start;i< a.length;i++) {
			if(temp.size() == 0 || a[i] >= temp.get(temp.size()-1)) {
				temp.add(a[i]);
				findUtil(a, result, temp, i+1);
				temp.remove(temp.size()-1);
			}
		}
		
	}

}
