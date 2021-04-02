/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 968 : 
 * 
 * Date : Dec 28, 2020
 * 
 * @author bramanarayan
 *
 */
public class BinaryTreeCameras {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    
   // Return 0 if it's a leaf.
   // Return 1 if it's a parent of a leaf, with a camera on this node.
   // Return 2 if it's coverd, without a camera on this node.

    /*
    For each node,
    if it has a child, which is leaf (node 0), then it needs camera.
    if it has a child, which is the parent of a leaf (node 1), then it's covered.

    If it needs camera, then res++ and we return 1.
    If it's covered, we return 2.
    Otherwise, we return 0.
*/
    private static final int NO_COVERED = 0, CAMERA_COVERED = 1, HAS_CAMERA = 2;
    private int cameras = 0;

    public int minCameraCover(TreeNode root) {
        return (dfs(root) == NO_COVERED ? 1 : 0) + cameras;
    }

    private int dfs(TreeNode root) {
    	
    	
        if (root == null) return CAMERA_COVERED;
        
        // a leaf node 
        if (root.left == null && root.right == null) return NO_COVERED;

        // get cameras on left, and right
        
        int left = dfs(root.left), right = dfs(root.right);
        
        // if left is not covered and right is not covered, you need to palce a camera
        if (left == NO_COVERED || right == NO_COVERED) {
            cameras++;
            return HAS_CAMERA;
        }

        // If left or right child has camera, then current level is covered, else not.
        return left == HAS_CAMERA || right == HAS_CAMERA ? CAMERA_COVERED : NO_COVERED;
    }

}
