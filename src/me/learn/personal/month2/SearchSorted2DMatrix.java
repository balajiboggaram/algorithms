/**
 * 
 */
package me.learn.personal.month2;

import java.util.PriorityQueue;

/**
 * Title 74 : Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true

Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false

 
 * 
 * @author bramanarayan
 * @date Jun 9, 2020
 */
public class SearchSorted2DMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SearchSorted2DMatrix solution = new SearchSorted2DMatrix();
		int[][] matrix = new int[][] {{1,5,9},{10,11,13},{12,13,15}};
	//	System.out.println(solution.searchMatrix(matrix, 8));
	//	System.out.println(solution.searchMatrix(matrix, 12));

		matrix = new int[][] {{1,3}};
		System.out.println(solution.searchMatrix(matrix, 3));

		
	}

	// trick is to compute the mid element value 
	// midIndex / #ofcolumns = row
	// midIndex % #ofcolumns = cloumn
	// O(log n) where n is total number of elements. 
	// the catch in this problem is the next row element is greater than last element of previous row.
	public boolean searchMatrix(int[][] matrix, int k) {
		int m = matrix.length;
		if(m ==0) return false;
		int n = matrix[0].length;
		if(n ==0 ) return false;
		
		int l = 0, h = m *n -1;
		while (l <=h) {
			int mid = l + ((h-l)/2);
			int midValue = matrix[mid/n][mid%n];
			if(midValue == k)
				return true;
			else if(k > midValue) {
				l = mid + 1;
			} else {
				h = mid -1;
			}
		}
	
		return false;
	
	}
	
	
	
	/**
	 * search value 'k' in the matrix - using heaps
	 * 
	 * This implementation is slight modification of 'k' th largest/smallest element.
	 */
	public boolean searchMatrixMy(int[][] matrix, int k) {
		// Use this if you want kth largest element
		// PriorityQueue<Tuple> heap = new
		// PriorityQueue<Tuple>(Collections.reverseOrder()); // descending order

		PriorityQueue<Tuple74> heap = new PriorityQueue<Tuple74>(); // default - ascending order
		int m = matrix.length;
		if(m == 0) return false;
		
		int n = matrix[0].length;
		if(n == 0) return false;
		
		// Put all the first element of every row in the queue
		for (int i = 0; i < m; i++) {
			heap.offer(new Tuple74(i, 0, matrix[i][0]));
		}

		// Now, try fetch until the queue is empty
		while (!heap.isEmpty()) {
			Tuple74 temp = heap.poll(); // Get smallest on top of the heap

			if (temp.value == k)
				return true; // value is found :)

			if (temp.y == n - 1) // m*m matrix
				continue;

			// Add the next element
			heap.offer(new Tuple74(temp.x, temp.y + 1, matrix[temp.x][temp.y + 1]));

		}

		return false;
	}

}

class Tuple74 implements Comparable<Tuple74> {

	int x;
	int y;
	int value;

	public Tuple74(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}

	@Override
	public int compareTo(Tuple74 o) {
		return this.value - o.value;
	}

}
