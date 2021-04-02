/**
 * 
 */
package me.learn.personal.month5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Title 406 :
 * 
 * Date : Jan 1, 2021
 * 
 * @author bramanarayan
 *
 */
public class QueueReconstructionByHeight {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] reconstructQueue(int[][] people) {

		// base condition
		if (people == null || people.length == 0 || people[0].length == 0)
			return new int[0][0];

		// sort people on height and then on the index (rank). the height is decreasing
		// and rank is increasing order
		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (b[0] == a[0])
					return a[1] - b[1];
				return b[0] - a[0];
			}
		});

		// basically insert person at index 'i'. This works because the you are trying to insert person based on their rank. 
		// this will automatically put them based on the count.
		List<int[]> output = new LinkedList<>();
		for (int[] p : people) {
			output.add(p[1], p); // add p at index p[1]
		}

		int n = people.length;
		return output.toArray(new int[n][2]);
	}

}
