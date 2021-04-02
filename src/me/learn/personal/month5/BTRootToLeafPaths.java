/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.List;

import me.learn.utli.TreeNode;

/**
 * Title 257 :
 * 
 * Date : Dec 29, 2020
 * 
 * @author bramanarayan
 *
 */
public class BTRootToLeafPaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	List<String> result = new ArrayList<String>();
	public List<String> binaryTreePaths(TreeNode root) {
		util(root, "");
		return result;	
	}
	
	private void util(TreeNode root, String s) {
		
		if(root == null) return;
		
		s = s + root.val + "->";
		
		if(root.left == null && root.right == null) { 
			result.add(s.substring(0, s.length()-2));
		}
		
		util(root.left, s);
		util(root.right, s);
		
		
	}

}
