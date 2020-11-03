/**
 * 
 */
package me.learn.personal.month3;

import java.util.ArrayDeque;
import java.util.Deque;

import me.learn.utli.TreeNode;

/**
 * Title 114 : 
 * 
 * Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6

The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

 * 
 * @author bramanarayan
 * @date Jul 10, 2020
 */
public class FlattenBinaryTreeToSLList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	// ITERATIVE using a STACK - Beautiful
	public void flatten(TreeNode root) {

		if (root == null)
			return;

		TreeNode pseudo = new TreeNode(0);
		pseudo.right = root;
		TreeNode prev = pseudo;

		Deque<TreeNode> st = new ArrayDeque<>();
		st.push(root);

		while (!st.isEmpty()) {
			TreeNode temp = st.pop();
			prev.right = temp;
			if (temp.right != null) {
				st.push(temp.right);
			}

			if (temp.left != null) {
				st.push(temp.left);
			}
			prev = temp;
			temp.left = null;
		}
	}
}
