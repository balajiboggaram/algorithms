/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import me.learn.utli.TreeNode;

/**
 * Title 637 :
 * 
 * Date : Dec 23, 2020
 * 
 * @author bramanarayan
 *
 */
public class AverageLevelsInBT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public List<Double> averageOfLevels(TreeNode root) {

		List<Double> result = new ArrayList<Double>();
		if (root == null)
			return null;

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			Double sum = 0.0;
			for (int i = 0; i < size; i++) {

				TreeNode temp = q.remove();
				sum += temp.val;
				if (temp.left != null)
					q.offer(temp.left);
				if (temp.right != null)
					q.offer(temp.right);
			}
						
			result.add((double) sum / size);
		}
		return result;
	}
}
