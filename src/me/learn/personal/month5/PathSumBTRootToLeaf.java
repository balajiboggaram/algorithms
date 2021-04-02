/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.List;

import me.learn.utli.TreeNode;

/**
 * Title :
 * 
 * Date : Dec 29, 2020
 * 
 * @author bramanarayan
 *
 */
public class PathSumBTRootToLeaf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> pathSum(TreeNode root, int target) {

		if (root == null)
			return result;
		util(root, new ArrayList<Integer>(), target, 0);
		return result;
	}

	private void util(TreeNode root, ArrayList<Integer> tempList, int target, int sum) {
		
		if(root == null) return;
		sum = sum + root.val;
		tempList.add(root.val);

		if(sum == target && root.left == null && root.right == null) {
			System.out.println("Adding result now");
			result.add(new ArrayList<Integer>(tempList));
		}
		
		
		util(root.left, tempList, target, sum);
		util(root.right, tempList, target, sum);
		
		tempList.remove(tempList.size()-1); // remove the last element
		System.out.println(sum);
		
		
	}

}
