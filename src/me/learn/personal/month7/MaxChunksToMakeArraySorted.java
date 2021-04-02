/**
 * 
 */
package me.learn.personal.month7;

/**
 * Title 769 :
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class MaxChunksToMakeArraySorted {

	// Divide the array into maximum number of chunks
	
	// Keep track of max.
	// As soon as the max becomes i, you need to chunk it.
	 public int maxChunksToSorted(int[] arr) {
	        if (arr == null || arr.length == 0) return 0;
	        
	        int count = 0, max = 0;
	        for (int i = 0; i < arr.length; i++) {
	            max = Math.max(max, arr[i]);
	            if (max == i) {
	                count++;
	            }
	        }
	        
	        return count;
	    }

}
