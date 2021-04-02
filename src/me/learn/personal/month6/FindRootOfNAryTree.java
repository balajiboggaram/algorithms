/**
 * 
 */
package me.learn.personal.month6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Title 1506 :
 * 
 * Date : Jan 14, 2021
 * 
 * @author bramanarayan
 *
 */
public class FindRootOfNAryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	// ensure the node's indegree is zero, that is your root node
	public Node findRoot(List<Node> tree) {

		Map<Node, Integer> map = new HashMap<>();
		Set<Node> visited = new HashSet<Node>();
		for (Node node : tree) {
			visited.add(node);
			for (Node child : node.children) {
				map.put(child, map.getOrDefault(child, 0) + 1);
			}
		}

		// now return the node with indegree value 0
		
		for(Node n : visited) {
			if(!map.containsKey(n)) return n;
		}
		
		return null;

	}

	class Node {
		public int val;
		public List<Node> children;

		public Node() {
			children = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			children = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _children) {
			val = _val;
			children = _children;
		}
	};

}
