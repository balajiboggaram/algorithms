/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 308 :
 * 
 * Date : Jan 9, 2021
 * 
 * @author bramanarayan
 *
 */
public class RangeSumQuery2DMutableMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Similar to 1-D version. Each tree will have four children: left-upper,
	 * right-upper, left-bottom, right-bottom.
	 * 
	 * Time complexity
	 * 
	 * Preprocessing: O(N): building tree takes N + N/4 + N / 16 + ... = 4 / 3 * N,
	 * where N is number of elements Query: O(logN)
	 * 
	 * Space complexity
	 * 
	 * O(N): tree size = N + N/4 + N / 16 + ... = 4 / 3 * N, where N is number of
	 * elements
	 */
	class NumMatrix {

		class Node {
			int r1, c1, r2, c2, sum;
			Node lu, ru, lb, rb;

			Node(int a, int b, int c, int d, int e) {
				r1 = a;
				c1 = b;
				r2 = c;
				c2 = d;
				sum = e;
			}
		}

		Node root;
		int[][] matrix;
		int M, N;

		public NumMatrix(int[][] matrix) {
			this.matrix = matrix;
			if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
				return;
			M = matrix.length;
			N = matrix[0].length;
			root = buildTree(0, 0, M - 1, N - 1);
		}

		Node buildTree(int r1, int c1, int r2, int c2) {
			if (r1 > r2 || c1 > c2)
				return null;
			if (r1 == r2 && c1 == c2)
				return new Node(r1, c1, r1, c1, matrix[r1][c1]);
			int mr = (r1 + r2) / 2, mc = (c1 + c2) / 2;
			Node parent = new Node(r1, c1, r2, c2, 0);
			parent.lu = buildTree(r1, c1, mr, mc);
			parent.ru = buildTree(r1, mc + 1, mr, c2);
			parent.lb = buildTree(mr + 1, c1, r2, mc);
			parent.rb = buildTree(mr + 1, mc + 1, r2, c2);

			parent.sum += parent.lu != null ? parent.lu.sum : 0;
			parent.sum += parent.ru != null ? parent.ru.sum : 0;
			parent.sum += parent.lb != null ? parent.lb.sum : 0;
			parent.sum += parent.rb != null ? parent.rb.sum : 0;
			return parent;
		}

		public void update(int row, int col, int val) {
			matrix[row][col] = val;
			updateTree(row, col, root);
		}

		void updateTree(int r, int c, Node node) {
			if (node == null)
				return;
			if (isLeaf(node)) {
				if (node.r1 == r && node.c1 == c) {
					node.sum = matrix[r][c];
				}
			} else {
				updateTree(r, c, node.lu);
				updateTree(r, c, node.ru);
				updateTree(r, c, node.lb);
				updateTree(r, c, node.rb);
				node.sum = 0;
				node.sum += node.lu != null ? node.lu.sum : 0;
				node.sum += node.ru != null ? node.ru.sum : 0;
				node.sum += node.lb != null ? node.lb.sum : 0;
				node.sum += node.rb != null ? node.rb.sum : 0;
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			return query(row1, col1, row2, col2, root);
		}

		int query(int r1, int c1, int r2, int c2, Node node) {
			if (node == null || node.r1 > r2 || node.r2 < r1 || node.c1 > c2 || node.c2 < c1)
				return 0;
			if (r1 <= node.r1 && c1 <= node.c1 && r2 >= node.r2 && c2 >= node.c2)
				return node.sum;
			return query(r1, c1, r2, c2, node.lu) + query(r1, c1, r2, c2, node.ru) + query(r1, c1, r2, c2, node.lb)
					+ query(r1, c1, r2, c2, node.rb);
		}

		boolean isLeaf(Node node) {
			return node.r1 == node.r2 && node.c1 == node.c2;
		}

	}

}
