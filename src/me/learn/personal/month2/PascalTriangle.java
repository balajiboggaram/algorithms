package me.learn.personal.month2;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Title 118 : Given a non-negative integer numRows, generate the first numRows
 * of Pascal's triangle.
 * 
 * @author bramanarayan
 * @date May 21, 2020
 */
public class PascalTriangle {

	public static void main(String[] args) {
		PascalTriangle solution = new PascalTriangle();
		solution.generate(5);
	}

	public List<List<Integer>> generate(int numRows) {
		int i = 0;

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		while (i < numRows) {
			List<Integer> res = new ArrayList<Integer>();
			for (int k = 0; k <= i; k++) {
				if (k == 0 || k == i) {
					res.add(1);
				} else {
					res.add(result.get(i - 1).get(k) + result.get(i - 1).get(k - 1));
				}
			}

			result.add(res);
			i++;
		}
		return result;
	}

}
