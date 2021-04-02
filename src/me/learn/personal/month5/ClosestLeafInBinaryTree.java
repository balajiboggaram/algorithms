/**
 * 
 */
package me.learn.personal.month5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import me.learn.utli.TreeNode;

/**
 * Title 742 :
 * 
 * Date : Dec 28, 2020
 * 
 * @author bramanarayan
 *
 */
public class ClosestLeafInBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// node to parent node map - MINE
	Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();

	// Given a target value 'k', you need to find the closest leaf node.

	// BLOOD FLOW BFS, (First find the node matching with k, then plot BFS on it)
	// Note that you need to maintain a parent map to plot the BFS in step #2.
	public int findClosestLeaf(TreeNode root, int k) {

		// Step #1 : find the kth node if it exists in tree
		DFS(root, null, k);

		// Step #2 : plot the BFS
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Set<TreeNode> visited = new HashSet<TreeNode>();
		q.add(kNode);
		visited.add(kNode);
		
		int result = -1;
		while (!q.isEmpty()) {

			int size = q.size(); // process the level

			for (int i = 0; i < size; i++) {

				TreeNode temp = q.poll();
				
				if (temp.left == null && temp.right == null) {
					result = temp.val;
					break; // we found ur closest leaf node. we are done
				}

				// Down direction
				if (temp.left != null && !visited.contains(temp.left)) {
					q.offer(temp.left);
					visited.add(temp.left);
				}
					
				
				if (temp.right != null && !visited.contains(temp.right)) {
					q.offer(temp.right);
					visited.add(temp.right);
				}

				// Up direction now from our parent map
				if (map.get(temp) != null && !visited.contains(map.get(temp))) {
					q.offer(map.get(temp));
					visited.add(map.get(temp));
				}

			}

		}

		return result;

	}

	TreeNode kNode;

	private void DFS(TreeNode root, TreeNode parent, int k) {
		if (root == null)
			return;
		map.put(root, parent); // add node to parent

		if (root.val == k) {
			kNode = root;
			return;
		}

		DFS(root.left, root, k);
		DFS(root.right, root, k);

	}

}
