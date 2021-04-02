/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.List;

/**
 * Title 986 :
 * 
 * Date : Jan 1, 2021
 * 
 * @author bramanarayan
 *
 */
public class IntervalIntersection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] intervalIntersection(int[][] a, int[][] b) {

		int m = a.length;
		int n = b.length;

		List<int[]> result = new ArrayList<>();

		int i = 0, j = 0;
		while (i < m && j < n) {
			int x1 = a[i][0];
			int y1 = a[i][1];

			int x2 = b[j][0];
			int y2 = b[j][1];

			int start = 0, end = 0;
			start = Math.max(x1, x2);
			end = Math.min(y1, y2);

			if (start <= end) {
				result.add(new int[] { start, end });
			}

			if (y1 < y2)
				i++;
			else
				j++;

		}
		return result.toArray(new int[result.size()][]);
	}
}
