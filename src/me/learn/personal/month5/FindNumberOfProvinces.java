/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 547 :
 * 
 * Date : Jan 1, 2021
 * 
 * @author bramanarayan
 *
 */
public class FindNumberOfProvinces {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// The city A -> city B, city B -> city C, then it implies city A -> city C.
	// now a province is defined as one chuck of connected(directly or indirectly)
	// cities
	// find the number odf such.
	// a[i][j] = 0 // if i and j are not connected.
	// = 1 // if i and j are connected

	// THis is similar to # of connected components in a undirected graph (probably lC 323)
	// the only difference, here is a graph matrix, versus in that its a adjacency list.

	public int findCircleNum(int[][] connect) {

		int n = connect.length; // n nodes in the graph. or kind of n citities

		int result = 0;
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				result++; // # of province count
				markCity(connect, visited, i);
			}
		}
		return result;
	}

	// similar to flood fill
	private void markCity(int[][] connnect, boolean[] visited, int i) {
		if (i < visited.length) {

			if (visited[i])
				return;

			if (!visited[i]) {
				visited[i] = true;
				for (int neigh = 0; neigh < visited.length; neigh++) {
					if (!visited[neigh] && connnect[i][neigh] == 1)
						markCity(connnect, visited, neigh);
				}
			}

		}

	}
	
	// OR (super below)
	
	// This is a classic find union problem of disjoint sets.
	// check 737 for approach template
	// prepare a parentMap for n citities and initialize that they are connected to themselv. 0->0,1->1, 2->2 ...
	// now for every cell in matrix 
		// setParent(i,j, parentMap) 
	// now once all the union operations are done. 
	// in the parent map, if we find any node whose parent is themself, then count++
	// return the count which is the total # of provinces.

}
