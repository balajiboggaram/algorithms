/**
 * 
 */
package me.learn.personal.month6;

import java.util.Arrays;

/**
 * Title 1101 :
 * 
 * Date : Jan 14, 2021
 * 
 * @author bramanarayan
 *
 */
public class EarliestMomentOfFriendship {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// basically the idea is - union find
	// This below code should be tuned via our parentMap template.

	// init parent map as itself , node -> parent
	// init visited set as empty
	// sort the logs based on asce timestamp
	// as you process the logs (ts,x,y)
		// px = find parent of x 
	    // py = find parent of y
	    // if px == py and visited size is N , viola you found the answer, the prev ts is the moment of friendship
	    // else -> union the parents
 
	// drawn from most votes
	public int earliestAcq(int[][] logs, int N) {

		Arrays.sort(logs, (a, b) -> a[0] - b[0]);

		Unionfind uf = new Unionfind(N);
		for (int[] log : logs) {
			// Do union & find and see if the group size is 1 then return the timestamp
			uf.union(log[1], log[2]);
			
			// if count becomes one then all are friends by now.
			if (uf.count == 1) {
				return log[0];
			}
		}
		return -1;
	}

	public class Unionfind {
		int[] root;
		int count;

		public Unionfind(int count) {
			this.root = new int[count];
			this.count = count;
			for (int i = 0; i < count; i++) {
				this.root[i] = i; // everyone is parent of themself
			}
		}

		public void union(int i, int j) {
			int x = find(root, i);
			int y = find(root, j);

			if (x != y) {
				root[x] = y;
				count--;
			}
		}

		public int find(int[] root, int i) {
			if (root[i] == i) {
				return i;
			}
			return find(root, root[i]);
		}
	}

}
