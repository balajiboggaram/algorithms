/**
 * 
 */
package me.learn.personal.month6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Title 133 :
 * 
 * Date : Jan 14, 2021
 * 
 * @author bramanarayan
 *
 */
public class CloneGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	HashMap<Node, Node> map = new HashMap<>();
	Set<Node> visited = new HashSet<Node>();

	public Node cloneGraph(Node oNode) {
		if (oNode == null) {
			return oNode;
		}

		// Hash map to save the visited node and it's respective clone
		// as key and value respectively. This helps to avoid cycles.
		HashMap<Node, Node> map = new HashMap();

		// Put the first node in the queue
		LinkedList<Node> queue = new LinkedList<Node>();
		
		queue.add(oNode);
		// Clone the node and put it in the visited dictionary.
		map.put(oNode, new Node(oNode.val, new ArrayList()));

		// Start BFS traversal
		while (!queue.isEmpty()) {
			// Pop a node say "n" from the from the front of the queue.
			Node n = queue.remove();
			// Iterate through all the neighbors of the node "n"
			for (Node neighbor : n.neighbors) {
				
				if (!map.containsKey(neighbor)) {
					// Clone the neighbor and put in the visited, if not present already
					map.put(neighbor, new Node(neighbor.val, new ArrayList()));
					// Add the newly encountered node to the queue.
					queue.add(neighbor);
				}
				// Add the clone of the neighbor to the neighbors of the clone node "n".
				map.get(n).neighbors.add(map.get(neighbor));
			}
		}

		// Return the clone of the node from visited.
		return map.get(oNode);
	}

	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _children) {
			val = _val;
			neighbors = _children;
		}
	};

}
