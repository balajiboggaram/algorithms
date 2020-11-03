/**
 * 
 */
package me.learn.personal.month4;

import java.util.Stack;

/**
 * Title 739 :
 * 
 * Given a list of daily temperatures T, return a list such that, for each day
 * in the input, tells you how many days you would have to wait until a warmer
 * temperature. If there is no future day for which this is possible, put 0
 * instead.
 * 
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76,
 * 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * 
 * Note: The length of temperatures will be in the range [1, 30000]. Each
 * temperature will be an integer in the range [30, 100].
 * 
 * @author bramanarayan
 * @date Jul 26, 2020
 */
public class DailyTemperatures {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// stack - keep adding if a[i] less than s.peek(); // i.e no hot day obtained
	// still
	public int[] dailyTemperatures(int[] a) {

		int n = a.length;
		int[] res = new int[n];
		Stack<Integer> st = new Stack<Integer>();
		st.push(0);
		for (int i = 1; i < n; i++) {
			if(a[i] <= a[st.peek()]) {
				st.push(i);
			} else {
				while(!st.isEmpty() && a[i] > a[st.peek()]) {
					int lessWarmDay = st.pop();
					res[lessWarmDay] = i - lessWarmDay;
				}
				st.push(i);
			}
		}
		
		// for any other days in the stack, sorry there is no warmer day in future.
		while(!st.isEmpty()) {
			res[st.pop()] = 0;
		}
		
		return res;
	}

}
