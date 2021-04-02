/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 836 :
 * 
 * Date : Dec 31, 2020
 * 
 * @author bramanarayan
 *
 */
public class RectangleOverlap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Check notes for beautiful picture wrt rectabngle 1
	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

		int x1 = rec1[0], y1 = rec1[1], x2 = rec1[2], y2 = rec1[3];
		int p1 = rec2[0], q1 = rec2[1], p2 = rec2[2], q2 = rec2[3];

        // check if rectangle is a line. THIS IS IMPORTANT
        if(x1 == x2 || y1 == y2 || p1 == p2 || q1 == q2) return false;

		// check for non-overlapping conditions only
		return !((x2 <= p1) || (y2 <= q1) || (x1 >= p2) || (y1 >= q2));

	}

}
