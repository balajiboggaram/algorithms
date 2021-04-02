/**
 * 
 */
package me.learn.personal.month1;

/**
 * Title : 
 * 
 * Date : Feb 22, 2021
 * 
 * @author bramanarayan
 *
 */
public class SnakeTraversalArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static void print(int [][] mat) 
    { 
        // Traverse through all rows 
        for (int i = 0; i < mat.length; i++) 
        { 
  
            // If current row is even, print from 
            // left to right 
            if (i % 2 == 0) { 
                for (int j = 0; j < mat[0].length; j++) 
                    System.out.print(mat[i][j] +" "); 
            } 
            else
            { 

                // If current row is odd, print from 
                // right to left 
      
                for (int j = mat[0].length - 1; j >= 0; j--) 
                    System.out.print(mat[i][j] +" "); 
            } 
        } 
    } 

}
