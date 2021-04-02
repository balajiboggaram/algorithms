/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Title 498 :
 * 
 * Date : Dec 25, 2020
 * 
 * @author bramanarayan
 *
 */
public class DiagonalTraverseZigZag {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DiagonalTraverseZigZag solution = new DiagonalTraverseZigZag();
		System.out.println(
				Arrays.toString(solution.findDiagonalOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } })));
	}

	// Read all the elements diagonally 
	// Now, keep flipping them based on reverse boolean
	public int[] findDiagonalOrder(int[][] matrix) {

		List<List<Integer>> res = new ArrayList<>();

		Queue<Element> q1 = new LinkedList<Element>();
		Set<Integer> visited = new HashSet<>();

		int m = matrix.length;
		if (m == 0)
			return new int[] {}; // if no rows
		if (m == 1)
			return matrix[0]; // if only one row

		int n = matrix[0].length;

		q1.add(new Element(matrix[0][0], 0, 0));

		while (!q1.isEmpty()) {

			List<Integer> tempList = new ArrayList<Integer>();
			int size = q1.size();
			for (int i = 0; i < size; i++) {

				Element temp = q1.poll();
				tempList.add(temp.x);

				// right side element - add
				if (temp.j < n - 1 && !visited.contains(matrix[temp.i][temp.j + 1])) {
					q1.offer(new Element(matrix[temp.i][temp.j + 1], temp.i, temp.j + 1));
					visited.add(matrix[temp.i][temp.j + 1]);
				}

				// down element - add
				if (temp.i < m - 1 && !visited.contains(matrix[temp.i + 1][temp.j])) {
					q1.offer(new Element(matrix[temp.i + 1][temp.j], temp.i + 1, temp.j));
					visited.add(matrix[temp.i + 1][temp.j]);
				}

			}
			System.out.println(tempList);
			res.add(tempList);

		}

		// once you traverse, all we need is to place them in zig zag fashion
		boolean reverse = false;
		int[] result = new int[m * n];
		int k = 0;
		result[k++] = res.get(0).get(0);
		for (int i = 1; i < res.size(); i++) {
			List<Integer> temp = res.get(i);
			if (reverse) {
				Collections.reverse(temp);
			}
			for (Integer x : temp) {
				result[k++] = x;
			}
			reverse = !reverse;

		}

		return result;

	}

	class Element {
		public Element(int x, int i, int j) {
			this.x = x;
			this.i = i;
			this.j = j;
		}

		int x;
		int i;
		int j;
	}

	
	// OR
	
	public int[] findDiagonalOrderBEST(int[][] matrix) {
	    if(matrix.length == 0)
	        return new int[0];

	    int result[] = new int[matrix.length * matrix[0].length];
	    int curRow = 0;
	    int curCol = 0;
	    int k = 0;
	    boolean isUp = true;
	    
	    int m = matrix.length;
	    int n = matrix[0].length;
	    
	    
	    for(int i = 0; i < m+n; i++) {
	        if(isUp) {
	        	// going up
	            while(curRow >= 0 && curCol < n) {
	                result[k++] = matrix[curRow--][curCol++];
	            }
	            if(curCol == n)
	                curCol = n - 1;
	            curRow = i + 1 - curCol;
	            isUp = !isUp;
	        }
	        else {
	        	
	        	// coming down
	            while(curRow < m && curCol >= 0) {
	                result[k++] = matrix[curRow++][curCol--];
	            }
	            if(curRow == m)
	                curRow = m - 1;
	            curCol = i + 1 - curRow;
	            isUp = !isUp;
	        }
	    }        
	    return result;
	}
	
	
}
