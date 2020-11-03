/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 531 : 
 * 
 * Given a picture consisting of black and white pixels, find the number of black lonely pixels.

The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels respectively.

A black lonely pixel is character 'B' that located at a specific position where the same row and same column don't have any other black pixels.

Example:

Input: 
[['W', 'W', 'B'],
 ['W', 'B', 'W'],
 ['B', 'W', 'W']]

Output: 3
Explanation: All the three 'B's are black lonely pixels.

 * 
 * @author bramanarayan
 * @date Jun 24, 2020
 */
public class LonelyPixel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public int findLonelyPixel(char[][] a) {
		int m = a.length;
		int n = a[0].length;

		// Compute the row and column counts i.e number of B's in a given row/column
		int[] rowCount = new int[m];
		int[] colCount = new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 'B') {
					rowCount[i]++;
					colCount[j]++;
				}
			}
		}

		// Now, For a lonely pixel - you need both row[i] and col[i] to be 1 and 1
		// resply
		int count  =0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(a[i][j] == 'B' && rowCount[i] == 1 && colCount[j] == 1) {
					count++;
				}
 			}
		}
		
		return count;
	}
		
}
	
	

