/**
 * 
 */
package me.learn.personal.monthlychallenge.may;

/**
 * Title : Check if it is a straight line
 * 
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y]
 * represents the coordinate of a point. Check if these points make a straight
 * line in the XY plane.
 * 
 * @author bramanarayan
 * @date May 8, 2020
 */
public class StraightLinePoints {
	public static void main(String[] args) {
		StraightLinePoints solution = new StraightLinePoints();
		//int[][] points = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 } };
		//int[][] points2 = new int[][] { { 1, 1 }, { 2, 2 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 7, 7 } };
		int[][] points3 = new int[][] { { -4, -3 }, { 1, 0 }, { 3, -1 }, { 0, -1 }, { -5, 2 }, { 7, 7 } };

		//System.out.println(solution.checkStraightLine(points));
		//System.out.println(solution.checkStraightLine(points2));
		System.out.println(solution.checkStraightLine(points3));

	}

	/**
	 * This solution is based on the slopes. 
	 * 
	 * slope on straight line = y2-y1/x2-x1
	 */
	public boolean checkStraightLine(int[][] coordinates) {

		int n = coordinates.length;
		if (n == 2)
			return true;

		double slope = (double) (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
		System.out.println("Slope : " + slope);
		for (int i = 2; i < n; i++) {
			double curSlope = (double) (coordinates[i][1] - coordinates[i - 1][1]) / (coordinates[i][0] - coordinates[i - 1][0]);
			if (curSlope != slope) {
				return false;
			}
		}
		return true;
	}
}
