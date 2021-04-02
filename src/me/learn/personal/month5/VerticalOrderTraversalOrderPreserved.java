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
 * Title :
 * 
 * Date : Dec 28, 2020
 * 
 * @author bramanarayan
 *
 */
public class VerticalOrderTraversalOrderPreserved {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Map<Integer, List<Integer>> map = new TreeMap<>();

	public List<List<Integer>> verticalOrder(TreeNode root) {
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

			// In the given level, if there are nodes with same horizontal distance, then we
			// need to sort them and then add to main map.
			// Iterate the temporary map and sort same vertical level data and add to main
			// ap
			tempMap.keySet().stream().forEach(x -> {
				List<Integer> l = tempMap.get(x);
				Collections.sort(l);
				map.computeIfAbsent(x, a -> new ArrayList()).addAll(l);
			});

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

}
