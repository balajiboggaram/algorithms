/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 867 :
 * 
 * Date : Dec 30, 2020
 * 
 * @author bramanarayan
 *
 */
public class TransposeMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// naive approach
	public int[][] transpose(int[][] a) {

		int m = a.length;
		int n = a[0].length;
		int[][] result = new int[n][m]; //m*n ---> becomes n*m

		int k = 0;
		for (int j = 0; j < n; j++) {
			int[] temp = new int[m]; // read all the column elements
			for (int i = 0; i < m; i++) {
				temp[i] = a[i][j];
			}
			result[k++] = temp; // put that as result row
		}
		return result;

	}

}
