/**
 * 
 */
package me.learn.personal.month2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title 1306 :
 * 
 *  Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.

Notice that you can not jump outside of the array at any time.

Example 1:

Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation: 
All possible ways to reach at index 3 with value 0 are: 
index 5 -> index 4 -> index 1 -> index 3 
index 5 -> index 6 -> index 4 -> index 1 -> index 3 
 * 
 * @author bramanarayan
 * @date Jun 9, 2020
 */
public class JumpGameThree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JumpGameThree solution = new JumpGameThree();
		System.out.println(solution.canReach(new int[] {4,2,3,0,3,1,2}, 5));
		System.out.println(solution.canReach(new int[] {3,0,2,1,2}, 2));
		System.out.println(solution.canReach(new int[] {3,0,1,2}, 0));

	}

	// The idea is to do a BFS starting from 'start'
	// Keep a matrix to track visited
	public boolean canReach(int[] arr, int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		int n = arr.length;
		boolean[] visited = new boolean[n];
		
		if(start > n-1) return false;
		
		while(!q.isEmpty()) {
			int t = q.remove();
			visited[t]=true;
			if(arr[t] == 0) return true;
			
			// If its not visited and is less than length
			if(arr[t] + t <= n-1 && !visited[arr[t] + t]) {
				q.add(arr[t] +t);
			}
			
			// If its not visited and is greater than 0
			if( t - arr[t] >= 0 && !visited[t - arr[t]]) {
				q.add(t-arr[t]);
			}
		}
		return false;
	}

}
