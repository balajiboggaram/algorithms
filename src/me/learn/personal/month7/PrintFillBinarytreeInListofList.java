/**
 * 
 */
package me.learn.personal.month7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import me.learn.utli.TreeNode;

/**
 * Title 655:
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class PrintFillBinarytreeInListofList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Always insert the element at mid
	 *  number of rows = height of tree
	 *  number of columns = 2 ^ height -1
	 *  
	 *  now, keep on filling the elements at every row using DFS
	 *  Input:
     1
    / \
   2   3
    \
     4
Output:
[["", "", "", "1", "", "", ""],
 ["", "2", "", "", "", "3", ""],
 ["", "", "4", "", "", "", ""]]

	 * 
	 */
	public List<List<String>> printTree(TreeNode root) {

		List<List<String>> res = new LinkedList<>();

		int height = root == null ? 1 : getHeight(root);

		int rows = height, columns = (int) (Math.pow(2, height) - 1);

		int m = rows;
		int n = columns;

		List<String> row = new ArrayList<>();

		for (int i = 0; i < n; i++)
			row.add("");

		for (int i = 0; i < m; i++)
			res.add(new ArrayList<>(row));

		DFS(root, res, 0, m, 0, n - 1);

		return res;
	}

	public void DFS(TreeNode root, List<List<String>> result, int currentRow, int totalRows, int i, int j) {
		if (currentRow == totalRows || root == null)
			return;
		
		int mid = (i + j) /2 ;
		// set the root value at mid always . here mid = i + j /2
		result.get(currentRow).set(mid, String.valueOf(root.val));
		
		DFS(root.left, result, currentRow + 1, totalRows, i, mid - 1);
		
		DFS(root.right, result, currentRow + 1, totalRows, mid + 1, j);
	}

	public int getHeight(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

}
