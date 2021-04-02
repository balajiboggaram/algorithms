/**
 * 
 */
package me.learn.personal.month7;

/**
 * Title 286 :
 * 
 * Date : Feb 25, 2021
 * 
 * @author bramanarayan
 *
 */
public class WallsAndGates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	// 0 -> is a gate
	// -1 is a wall
	// INF means empty.
	// you need to find the distance of eevery cell to nearest gate. 
	
	
	// was asked this in Yext
	public void wallsAndGates(int[][] rooms) {
	    for (int i = 0; i < rooms.length; i++)
	        for (int j = 0; j < rooms[0].length; j++)
	        	// start the flood fill from every gate.
	            if (rooms[i][j] == 0) dfs(rooms, i, j, 0);
	}

	private void dfs(int[][] rooms, int i, int j, int distance) {
	    if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < distance) return;
	    rooms[i][j] = distance;
	    dfs(rooms, i - 1, j, distance + 1);
	    dfs(rooms, i + 1, j, distance + 1);
	    dfs(rooms, i, j - 1, distance + 1);
	    dfs(rooms, i, j + 1, distance + 1);
	}

}
