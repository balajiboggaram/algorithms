/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import me.learn.utli.TreeNode;

/**
 * Title 987 :
 * 
 * Given a binary tree, return the vertical order traversal of its nodes values.
 * 
 * For each node at position (X, Y), its left and right children respectively
 * will be at positions (X-1, Y-1) and (X+1, Y-1).
 * 
 * Running a vertical line from X = -infinity to X = +infinity, whenever the
 * vertical line touches some nodes, we report the values of the nodes in order
 * from top to bottom (decreasing Y coordinates).
 * 
 * If two nodes have the same position, then the value of the node that is
 * reported first is the value that is smaller.
 * 
 * Return an list of non-empty reports in order of X coordinate. Every report
 * will have a list of values of nodes.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [3,9,20,null,null,15,7] Output: [[9],[3,15],[20],[7]] Explanation:
 * Without loss of generality, we can assume the root node is at position (0,
 * 0): Then, the node with value 9 occurs at position (-1, -1); The nodes with
 * values 3 and 15 occur at positions (0, 0) and (0, -2); The node with value 20
 * occurs at position (1, -1); The node with value 7 occurs at position (2, -2).
 * 
 * 
 * Date : Dec 9, 2020
 * 
 * @author bramanarayan
 *
 */
public class VerticalOrderTraversalBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// ORDER IS PRESERVED IN THIS ONE TOO.
	Map<Integer, List<Integer>> map = new TreeMap<>();

	public List<List<Integer>> verticalTraversal(TreeNode root) {

		List<List<Integer>> resultList = new ArrayList<>();

		if (root == null)
			return resultList;

		levelOrderTraversal(root);

		map.keySet().stream().forEach(x -> {
			resultList.add(map.get(x));
		});

		return resultList;

	}

	// BFS traversal
	void levelOrderTraversal(TreeNode root) {

		Queue<Tuple> q = new LinkedList<>();
		q.add(new Tuple(root, 0));

		// Temporary map to store same level data and sort (because sort is required),
		// before adding to main map
		Map<Integer, List<Integer>> tempMap = new TreeMap<>();

		while (!q.isEmpty()) {

			tempMap.clear();

			int size = q.size();
			for (int i = 0; i < size; i++) {

				Tuple epop = q.poll();
				TreeNode node = epop.node;
				int d = epop.d;

				tempMap.computeIfAbsent(d, x -> new ArrayList()).add(node.val);
				if (node.left != null)
					q.add(new Tuple(node.left, d - 1));
				if (node.right != null)
					q.add(new Tuple(node.right, d + 1));
			}

			// In the given level, if there are nodes with same horizontal distance, then we need to sort them and then add to main map.
			// Iterate the temporary map and sort same vertical level data and add to main ap
			tempMap.keySet().stream().forEach(x -> {
				List<Integer> l = tempMap.get(x);
				Collections.sort(l);
				map.computeIfAbsent(x, a -> new ArrayList()).addAll(l);
			});

		}
	}
}

class Tuple {
	TreeNode node;
	int d;

	Tuple(TreeNode node, int d) {
		this.node = node;
		this.d = d;
	}
}
