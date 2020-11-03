package me.learn.personal.month2;

import me.learn.utli.TreeNode;

/**
 * 
 * Title 106 : Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]

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
public class BinaryTreePostInOrder {

	public static void main(String[] args) {
		BinaryTreePostInOrder solution = new BinaryTreePostInOrder();
		solution.buildTree( new int[] {9 ,3, 15, 20, 7}, new int[] {9, 15, 7, 20, 3});
	}	

	int postIndex = 0;

	public TreeNode buildTree(int[] inorder, int[] postOrder) {
		this.postIndex = postOrder.length - 1;
		if (postOrder.length == 0 || postOrder.length != inorder.length)
			return null;
		return buildTreeUtil(postOrder, inorder, 0, inorder.length - 1);

	}

	private TreeNode buildTreeUtil(int[] postOrder, int[] inorder, int inStart, int inEnd) {

		if (inStart > inEnd)
			return null;
		int value = postOrder[postIndex];
		TreeNode temp = new TreeNode(postOrder[postIndex]);
		postIndex--;
		if (inStart == inEnd)
			return temp;

		int inIndex = findInorderIndex(inorder, value);
		if (inIndex != -1) {
			temp.right = buildTreeUtil(postOrder, inorder, inIndex + 1, inEnd);
			temp.left = buildTreeUtil(postOrder, inorder, inStart, inIndex - 1);
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
