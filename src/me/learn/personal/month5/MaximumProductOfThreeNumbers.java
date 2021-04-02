/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 628 :
 * 
 * Date : Dec 31, 2020
 * 
 * @author bramanarayan
 *
 */
public class MaximumProductOfThreeNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// To find the max product of 3 elements
	// we need : min1, min2 + (max1,max2, max3)
	// The answer would be : min1 * min2 * max1 or max1 * max2 * max3 [either one of
	// them]
	public int maximumProduct(int[] a) {

		int n = a.length;
		int max1 = Integer.MIN_VALUE, max2 = max1, max3 = max1;
		int min1 = Integer.MAX_VALUE, min2 = min1;

		for (int i = 0; i < n; i++) {

			int value = a[i];

			if (min1 >= value) {
				min2 = min1;
				min1 = value;
			} else if (value <= min2) {
				min2 = value; // value lies between min1 and min2
			} else if (value >= max1) {
				max3 = max2;
				max2 = max1;
				max1 = value; // value is greater than max1
			} else if (value >= max2) {
				max3 = max2;
				max2 = value; // valu is between max1 and max2
			} else if (value >= max3) {
				max3 = n;
			}

		}
		return Math.max(max1 * max2 * max3, min1 * min2 * max1);

	}

}
