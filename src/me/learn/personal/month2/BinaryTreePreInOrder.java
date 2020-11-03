package me.learn.personal.month2;

import me.learn.utli.TreeNode;

/**
 * 
 * Title 105 : Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]

Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 
 * 
 * @author bramanarayan
 * @date May 25, 2020
 */
public class BinaryTreePreInOrder {
	
	
	public static void main(String args[]) {
		BinaryTreePreInOrder solution = new BinaryTreePreInOrder();
		solution.buildTree(new int[] {3 , 9 , 20, 15 ,7}, new int[] {9 ,3, 15, 20, 7});
	}

	int preIndex = 0;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || preorder.length != inorder.length)
			return null;
		return buildTreeUtil(preorder, inorder, 0, inorder.length - 1);

	}

	private TreeNode buildTreeUtil(int[] preorder, int[] inorder, int inStart, int inEnd) {

		if (inStart > inEnd)
			return null;
		int value = preorder[preIndex];
		TreeNode temp = new TreeNode(preorder[preIndex]);
		preIndex++;
		if (inStart == inEnd)
			return temp;

		int inIndex = findInorderIndex(inorder, value);
		if (inIndex != -1) {
			temp.left = buildTreeUtil(preorder, inorder, inStart, inIndex - 1);
			temp.right = buildTreeUtil(preorder, inorder, inIndex + 1, inEnd);
			System.out.println(temp.val + " Left : " + temp.left + "   Right: " + temp.right);

		}
		return temp;
	}

	private int findInorderIndex(int[] inorder, int value) {
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == value)
				return i;
		}
		return -1;
	}

}
