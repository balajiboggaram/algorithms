/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title : 
 * 
 * Date : Feb 15, 2021
 * 
 * @author bramanarayan
 *
 */
public class TwoLargestIntegers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public  int[] twoLargest(int values[]){
	    int largestA = Integer.MIN_VALUE, largestB = Integer.MIN_VALUE;

	    for(int value : values) {
	        if(value > largestA) {
	            largestB = largestA;
	            largestA = value;
	        } else if (value > largestB) {
	            largestB = value;
	        }
	    }
	    return new int[] { largestA, largestB }; 
	}
	
	
}
