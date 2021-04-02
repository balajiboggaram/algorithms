/**
 * 
 */
package me.learn.personal.month5;

import java.util.TreeSet;

/**
 * Title 363 : 
 * 
 * Date : Feb 15, 2021
 * 
 * @author bramanarayan
 *
 */
public class MaximumSumSubRectangle {

	
	// SEE THIS : https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/SubRectangularMatrixWithMaximumSum.java
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// maximum sum sub rectangle no larger than k

    public int maxSumSubmatrix( int arr[][], int target ){
        int result = Integer.MIN_VALUE;
        int left =0, right =0, top=0, bottom=0;
        int row = arr.length;
        int col = arr[0].length;
        
        int[][] prefixSum = new int[row][col];
        for( int j = 0; j < col; j++){
            for( int i =0; i < row; i++ ){
                if( j == 0 ){
                    prefixSum[i][j] = arr[i][j];
                }else{
                    prefixSum[i][j] = arr[i][j] + prefixSum[i][j-1];
                }
            }
        }
        for( right =0; right < col; right++ ) {
            for( left =0; left <= right ; left++ ) {
                int currentSum = maxSum( prefixSum, right, target, left);
                result = Math.max( result, currentSum);
            }
        }
        return result == Integer.MIN_VALUE ? -1 : result;
    }
    private int maxSum( int[][] prefixSum, int col, int target, int left ) {
        int maxSum =Integer.MIN_VALUE;
        int curr =0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        
        for( int i =0; i < prefixSum.length; i++ ){
            if( left == 0 ) {
                curr  += prefixSum[i][col];
            }else { 
                curr  += prefixSum[i][col];
                curr -= prefixSum[i][left-1];
            }
            
            Integer ceil = set.ceiling( curr - target );
            if( ceil != null ) {
                maxSum = Math.max( maxSum, curr - ceil );
            }
            set.add(curr);
        }
        return maxSum;
    }

}
