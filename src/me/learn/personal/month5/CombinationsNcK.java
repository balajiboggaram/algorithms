/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.List;

/**
 * Title 77 :
 * 
 * Date : Jan 2, 2021
 * 
 * @author bramanarayan
 *
 */
public class CombinationsNcK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		CombinationsNcK solution = new CombinationsNcK();
		System.out.println(solution.combine(4, 2));
	}

	List<List<Integer>> result = new ArrayList<>();

	// given n and k, rerutn all the possible combinatinos of picking 'k' numbers
	// out of n
	public List<List<Integer>> combine(int n, int k) {
		
		if( k== 0) return result;
		if(n == 0) return result;
		dfs(n, k, new ArrayList<Integer>(), 0);
		return result;

	}

	void dfs(int n, int k, List<Integer> temp, int start) {

		if (temp.size() == k) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}

		for (int i = start; i < n; i++) {
			temp.add(i+1);
			dfs(n, k, temp, i+1);
			temp.remove(temp.size()-1);
		}
	}

}
