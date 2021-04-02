/**
 * 
 */
package me.learn.personal.month1;

import java.util.ArrayList;
import java.util.List;

import me.learn.utli.TreeNode;

/**
 * Title 1469 : 
 * 
 * Date : Jan 5, 2021
 * 
 * @author bramanarayan
 *
 */
public class FindAllLonelyNodes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	List<Integer> result = new ArrayList<Integer>();
    public List<Integer> getLonelyNodes(TreeNode root) {
    	if(root == null) return null;
    	
    	util(root);
    	return result;
    }
    
    void util(TreeNode root) {
    	if(root == null) return;
    	if(root.left == null && root.right != null) {
    		result.add(root.right.val);
    	}
    	
    	if(root.right == null && root.left != null) {
    		result.add(root.left.val);
    	}
    	
    	util(root.left);
    	util(root.right);
    }

}
