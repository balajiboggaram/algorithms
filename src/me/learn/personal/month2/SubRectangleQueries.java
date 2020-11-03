/**
 * 
 */
package me.learn.personal.month2;

/**
 * Title 1476 : 
 * 
 * mplement the class SubrectangleQueries which receives a rows x cols rectangle as a matrix of integers in the constructor and supports two methods:

1. updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)

    Updates all values with newValue in the subrectangle whose upper left coordinate is (row1,col1) and bottom right coordinate is (row2,col2).

2. getValue(int row, int col)

    Returns the current value of the coordinate (row,col) from the rectangle.

 

Example 1:

Input
["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue","getValue"]
[[[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]],[0,2],[0,0,3,2,5],[0,2],[3,1],[3,0,3,2,10],[3,1],[0,2]]
Output
[null,1,null,5,5,null,10,5]
Explanation
SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,2,1],[4,3,4],[3,2,1],[1,1,1]]);  
// The initial rectangle (4x3) looks like:
// 1 2 1
// 4 3 4
// 3 2 1
// 1 1 1
subrectangleQueries.getValue(0, 2); // return 1
subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
// After this update the rectangle looks like:
// 5 5 5
// 5 5 5
// 5 5 5
// 5 5 5 
subrectangleQueries.getValue(0, 2); // return 5
subrectangleQueries.getValue(3, 1); // return 5
subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
// After this update the rectangle looks like:
// 5   5   5
// 5   5   5
// 5   5   5
// 10  10  10 
subrectangleQueries.getValue(3, 1); // return 10
subrectangleQueries.getValue(0, 2); // return 5

 * 
 * @author bramanarayan
 * @date Jun 18, 2020
 */
public class SubRectangleQueries {

	private int[][] rectangle;
	

	public SubRectangleQueries(int[][] rectangle) {
	
		this.rectangle = rectangle;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public void updateSubrectangle(int r1, int c1, int r2, int c2, int newValue) {
		for(int i =r1;i<=r2;i++) {
			for(int j = c1; j <= c2;j++) {
				rectangle[i][j] = newValue;
			}
		}
	}

	public int getValue(int row, int col) {
		return this.rectangle[row][col];
	}

}
