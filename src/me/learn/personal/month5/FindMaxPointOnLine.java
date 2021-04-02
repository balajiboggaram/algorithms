/**
 * 
 */
package me.learn.personal.month5;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 149 :
 * 
 * Date : Jan 6, 2021
 * 
 * @author bramanarayan
 *
 */
public class FindMaxPointOnLine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxPoints(int[][] points) {
		if (points == null)
			return 0;

		int solution = 0;
		for (int i = 0; i < points.length; i++) {

			int x1 = points[i][0];
			int y1 = points[i][1];
			Map<String, Integer> map = new HashMap<>();
			int duplicate = 0;
			int max = 0;
			for (int j = i + 1; j < points.length; j++) {

				int x2 = points[j][0];
				int y2 = points[j][1];

				int deltaX = x2 - x1;
				int deltaY = y2 - y1;

				if (deltaX == 0 && deltaY == 0) {
					duplicate++; // same point
					continue;
				}

				int gcd = gcd(deltaX, deltaY);
				int dX = deltaX / gcd;
				int dY = deltaY / gcd;

				String key = dX + "," + dY;

				map.put(key, map.getOrDefault(key, 0) + 1);
				max = Math.max(max, map.get(key));
			}

			solution = Math.max(solution, max + duplicate + 1);
		}

		return solution;
	}

	public int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

}
