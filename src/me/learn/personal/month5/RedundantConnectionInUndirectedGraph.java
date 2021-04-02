/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 684 :
 * 
 * Date : Dec 24, 2020
 * 
 * @author bramanarayan
 *
 */
public class RedundantConnectionInUndirectedGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// remove one extra edge such that it becomes a tree of n edges

	// this problem is solved using disjoint sets - find union
	public int[] findRedundantConnection(int[][] edges) {

		// Rules of disjoint set find union
		// you need to maintain parent node of disjoint graph and rank
		// always merge the lower rank to higher rank node
		// rank purely indicates the # of nodes present in the tree
		
		DisjointSet set = new DisjointSet(edges.length);
		
		
		// for every given edge
		for(int[] edge : edges) {
			if(!set.isUnion(edge[0]-1, edge[1]-1)) {
				return edge;
			}
		}
		return null;
		
	}

}

class DisjointSet {

	int[] parent;
	int[] rank;

	public DisjointSet(int n) {
		this.parent = new int[n];
		this.rank = new int[n];
		

	}

	// find the root node 
	int find(int x) {

		if (parent[x] == 0)
			return x; // no parent for this node

		parent[x] = find(parent[x]); // keep traversing up until you find the root parent

		return parent[x];
	}
	
	boolean isUnion(int x, int y) {
		
		int rootX = find(x);
		int rootY = find(y);
		
		if(rootX == rootY) return false; // this indicates the graph is connected, There is no way we can perform union operation
		
		// Y rank is greater than X rank, so Y is the parent
		if(rank[rootX] < rank[rootY]) {
			parent[x] = rootY;
		} else if(rank[rootX] > rank[rootY]) {
			parent[y] = rootX;
		} else {
			// both are equal, so I can pick anyone of them
			parent[rootX] = rootY;
			rank[rootY]++;
		}
		return true; // union is done
	}
}