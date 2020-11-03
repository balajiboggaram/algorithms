package me.learn.personal.month1;

/**
 * 
 * Title 11 : Given n non-negative integers a1, a2, ..., an , where each
 * represents a point at coordinate (i, ai). n vertical lines are drawn such
 * that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 * which together with x-axis forms a container, such that the container
 * contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * @author bramanarayan
 * @date May 18, 2020
 */
public class ContainerWithMostWater {

	public static void main(String args[]) {
		ContainerWithMostWater solution = new ContainerWithMostWater();
		System.out.println(solution.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
	}

	/**
	 * How this approach works?
	 * 
	 * Initially we consider the area constituting the exterior most lines. Now, to
	 * maximize the area, we need to consider the area between the lines of larger
	 * lengths. If we try to move the pointer at the longer line inwards, we won't
	 * gain any increase in area, since it is limited by the shorter line. But
	 * moving the shorter line's pointer could turn out to be beneficial, as per the
	 * same argument, despite the reduction in the width. This is done since a
	 * relatively longer line obtained by moving the shorter line's pointer might
	 * overcome the reduction in area caused by the width reduction.
	 */
	public int maxArea(int[] height) {
		int n = height.length;
		int low = 0, high = n - 1;
		int maxArea = 0;
		// Hint : try maxWidth first before maxHeight area
		while (low < high) {
			maxArea = Math.max(maxArea, Math.min(height[low], height[high]) * (high - low));

			// this is the trick here -
			// Greedy approach - if you always try to move towards the lower bar side.
			// rather higher bar, As if lower increases then we can get higher area by
			// breadth
			// rather higher area by height.
			if (height[low] < height[high]) {
				low++;
			} else {
				high--;
			}
		}
		return maxArea;
	}

}
