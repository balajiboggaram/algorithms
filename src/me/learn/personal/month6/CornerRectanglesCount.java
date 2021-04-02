/**
 * 
 */
package me.learn.personal.month6;

/**
 * Title 750 :
 * 
 * Date : Jan 14, 2021
 * 
 * @author bramanarayan
 *
 */
public class CornerRectanglesCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * To find an axis-aligned rectangle, my idea is to fix two rows (or two
	 * columns) first, then check column by column to find "1" on both rows. Say you
	 * find n pairs, then just pick any 2 of those to form an axis-aligned rectangle
	 * (calculating how many in total is just high school math, hint: combination).
	 * 
	 */

	public int countCornerRectangles(int[][] grid) {
		int ans = 0;
		for (int i = 0; i < grid.length - 1; i++) { // fix first row
			for (int j = i + 1; j < grid.length; j++) { // pick every other row as second row
				int counter = 0;
				for (int k = 0; k < grid[0].length; k++) {
					if (grid[i][k] == 1 && grid[j][k] == 1)
						counter++;
				}
				if (counter > 0)
					ans += counter * (counter - 1) / 2; // n *n-1 / 2
			}
		}
		return ans;
	}

}
