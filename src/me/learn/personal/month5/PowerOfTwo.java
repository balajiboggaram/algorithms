/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 231 :
 * 
 * Date : Dec 31, 2020
 * 
 * @author bramanarayan
 *
 */
public class PowerOfTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPowerOfTwo(int n) {
		// if you & AND n and n-1, you will get  0. 
		// why ? if you notice n-1 is a pure complement of n (if its a power of 2)
		
		long num = (long) n; // only to handle the integer overflow
		
		if(num == 0) return false;
		return (num & (num-1)) == 0;
		
	}

}
