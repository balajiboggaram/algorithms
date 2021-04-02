/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Title 589 :
 * 
 * Date : Dec 30, 2020
 * 
 * @author bramanarayan
 *
 */
public class NAryPreOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> preorder(Node root) {
		List<Integer> result = new ArrayList<Integer>();

		if (root == null)
			return result;

		Stack<Node> st = new Stack<Node>();


		st.push(root);
		while (!st.isEmpty()) {
			Node temp = st.pop();
			result.add(temp.val);

			List<Node> children = temp.children;
			for (int i = children.size() - 1; i >= 0; i--) {
				st.push(children.get(i));
			}
		}
		return result;

	}

	class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};

	
	
	//or 
	
	public List<Integer> list = new ArrayList<>();
    public List<Integer> preorderDFS(Node root) {
        if (root == null)
            return list;
        
        list.add(root.val);
        for(Node node: root.children)
            preorder(node);
                
        return list;
    }
}
