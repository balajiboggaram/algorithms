/**
 * 
 */
package me.learn.personal.month5;

import java.util.Stack;

import me.learn.utli.TreeNode;

/**
 * Title 536 :
 * 
 * Date : Dec 24, 2020
 * 
 * @author bramanarayan
 *
 */
public class ConstructBTFromString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        // The node on the top of the stack is the newest parent node.
        Stack<TreeNode> stack = new Stack<>();
        
        // I always keep the root of the tree separately
        TreeNode root = null;
        
        
        // If its a integer, read the number to a node and assign node as child. Push the new node
        // If its a (, update the new root
        // If its a ), pop a node from stack. 
        
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            
            
            // Build a new node when a number is encountered.
            if (c == '-' || (c >= '0' && c <= '9')) {
                String val = "" + c;
                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    val += s.charAt(i + 1);
                    i++;
                }
                TreeNode node = new TreeNode(Integer.parseInt(val));
                // Assign the new node to either left or right depending on
                // the situation.
                if (root != null) {
                    if (root.left == null) {
                        root.left = node;
                    } else {
                        root.right = node;
                    }
                }
                stack.push(node); // remember to push the node so that we remember this as next root if it has children
            
            
            } else if (c == '(') {
                // A number (node/child) must be followed this '(',  so we need its parent.
                root = stack.peek();
          
            } else {
                // The node on the top of the stack is done.
                stack.pop();
            }
            i++;
        }
        return stack.pop(); // ultimately this has the root
    }
	
	//or BEST

// given a string with paranthesis, Construct a binary tree
	public TreeNode str2tree1(String s) {

		int n = s.length();
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode cur = new TreeNode(s.charAt(0)); // the first digit is always the root node init.
		int i = 1;
		
		TreeNode parent = null ; // you need this for the final answer. which will be the root.
		while (i < n) {
			char ch = s.charAt(i);
			if(ch == ')') {
				st.push(cur);
			} else if (ch == ')') {
				parent = st.pop();
			} else {
				TreeNode temp = new TreeNode(ch);
				if(!st.isEmpty() && st.peek().left == null) {
					st.peek().left = temp;
				} else if(!st.isEmpty() && st.peek().right == null ) {
					st.peek().right = temp;
				}
				cur = temp;
			}
			i++;
			
		}
		return parent;
	}

}
