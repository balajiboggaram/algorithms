/**
 * 
 */
package me.learn.personal.month4;

/**
 * Title 11 : Given n non-negative integers a1, a2, ..., an , where each
 * represents a point at coordinate (i, ai). n vertical lines are drawn such
 * that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 * which together with x-axis forms a container, such that the container
 * contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * @author bramanarayan
 * @date Jul 26, 2020
 */
public class ContainerWithMostWater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	// GREEDY
	// WIDTH takes precedence over Height
	public int maxArea(int[] a) {
		int l = 0;
		int h = a.length - 1;
		int maxArea = 0;
		while (l < h) {
			maxArea = Math.max(maxArea, Math.min(a[l], a[h]) * (h - l));

			// this is the trick here -
			// Greedy approach - if you always try to move towards the lower bar side.
			// rather higher bar, As if lower increases then we can get higher area by
			// breadth
			// rather higher area by height.
			if (a[l] < a[h]) {
				l++;
			} else {
				h--;
			}
		}
		return maxArea;
	}
}
