/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 510 :
 * 
 * Date : Dec 24, 2020
 * 
 * @author bramanarayan
 *
 */
public class InOrderSuccessorInBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	/**
	 
	    // the successor is somewhere lower in the right subtree
	    if (x.right != null) {
	      x = x.right;
	      while (x.left != null) x = x.left;
	      return x;
	    }

	    // the successor is somewhere upper in the tree
	    while (x.parent != null && x == x.parent.right) x = x.parent;
	    return x.parent;
	  }
	  */
	
	public Node1 inorderSuccessor(Node1 node) {

		if (node == null)
			return null;

		// case 1 - if right is not null; then its the minimum node on right side of
		// tree
		
		if(node.right != null) {
			Node1 cur = node.right;
			while(cur != null) {
				cur = cur.left;
			}
			return cur;
		} else {

			// case 2 - If the right is null, go up until the current node becomes the left
			// node to its parent. The parent node is the successor node.
			
			while(node.parent!= null ) {
				if(node.parent.right == node) {
					node = node.parent; // go up
				} else {
					return node.parent; // we found the successor here.
				}
			}
			
		}
		return null;
	}

}

class Node1 {
	 public int val;
	    public Node1 left;
	    public Node1 right;
	    public Node1 parent;
}
