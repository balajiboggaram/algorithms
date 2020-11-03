/**
 * 
 */
package me.learn.personal.month4;

import java.util.NoSuchElementException;
import java.util.Stack;

import me.learn.utli.TreeNode;

/**
 * Title 173 :
 * 
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * @author bramanarayan
 * @date Jul 26, 2020
 */
public class BinarySearchTreeIterator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class BSTIterator {

	Stack<TreeNode> st = new Stack<TreeNode>();
	
	// push all the left nodes of the root node
    public BSTIterator(TreeNode root) {
        TreeNode cur = root;
        while(cur != null) {
        	st.push(cur);
        	cur = cur.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
    	
    	if(!st.isEmpty()) { // can replace with hasNext()
        	TreeNode cur = st.pop();
        	int val = cur.val;
        	cur = cur.right;
        	while(cur != null) {
        		st.push(cur);
        		cur = cur.left;
        	}
        	return val;
    		
    	}
    	return -1;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }
}