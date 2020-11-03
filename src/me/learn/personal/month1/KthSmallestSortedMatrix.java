package me.learn.personal.month1;

import java.util.PriorityQueue;

/**
 * 
 * Title : Given a n x n matrix where each of the rows and columns are sorted in
 * ascending order, find the kth smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 * 
 * @author bramanarayan
 * @date May 12, 2020
 */
public class KthSmallestSortedMatrix {

	public static void main(String args[]) {
		KthSmallestSortedMatrix solution = new KthSmallestSortedMatrix();
		int[][] matrix = new int[][] {{1,5,9},{10,11,13},{12,13,15}};
		System.out.println(solution.kthSmallest(matrix, 8));
	}

	public int kthSmallest(int[][] matrix, int k) {
		// Use this if you want kth largest element
		//PriorityQueue<Tuple> heap = new PriorityQueue<Tuple>(Collections.reverseOrder()); // descending order		
		
		PriorityQueue<Tuple> heap = new PriorityQueue<Tuple>(); // default - ascending order
		int m = matrix.length;
		// Put all the first element of every row in the queue
		for (int i = 0; i < m; i++) {
			heap.offer(new Tuple(i, 0, matrix[i][0]));
		}

		// Now, try fetching k elements
		for (int i = 0; i < k-1; i++) {
			Tuple temp = heap.poll(); // Get smallest on top of the heap
			if (temp.y == m - 1) // m*m matrix
				continue;
			heap.offer(new Tuple(temp.x, temp.y + 1, matrix[temp.x][temp.y + 1]));
		}
		return heap.poll().value;
	}

}

class Tuple implements Comparable<Tuple> {

	int x;
	int y;
	int value;

	public Tuple(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}

	@Override
	public int compareTo(Tuple o) {
		return this.value - o.value;
	}

}