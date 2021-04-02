/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 116, 117:
 * 
 * Date : Dec 24, 2020
 * 
 * @author bramanarayan
 *
 */
public class PopulateNextRightPointerBT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Easily You can solve this problem with queue in O(n) space
	// But the trick is to solve in O(1) space

	Node prev, leftmost = null;

	// In order to solve in O(1), all you need is to track the leftmost in next
	// level, prev in next level, also cur in current level
	public Node connect(Node root) {
		if (root == null)
			return root;

		leftmost = root;
		Node cur = leftmost;
		
		// until the next level do not exist, keep going
		while(leftmost != null) {
			prev = null; // first pointer in the next level
			cur = leftmost;
			leftmost = null;  // these all are init steps when you start each level
			
			while(cur != null) {
				
				process(cur.left);
				process(cur.right);
				cur = cur.next; // by the time you come to next level, the previous level next pointers would be already fixed
				
			}
			
		}

		return root;
	}
	
	private void process(Node child) {
		
		if(child != null) {
			if(prev == null) {
				prev = child;
				leftmost = child;
			} else {
				prev.next = child;
				prev = prev.next;
			}			
		}
	}

	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

}