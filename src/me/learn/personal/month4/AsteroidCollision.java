/**
 * 
 */
package me.learn.personal.month4;

import java.util.Stack;

/**
 * Title 735 :
 * 
 *   We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

Example 1:

Input: 
asteroids = [5, 10, -5]
Output: [5, 10]
Explanation: 
The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.

Example 2:

Input: 
asteroids = [8, -8]
Output: []
Explanation: 
The 8 and -8 collide exploding each other.

 * 
 * @author bramanarayan
 * @date Jul 29, 2020
 */
public class AsteroidCollision {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// CRAP question
	 public int[] asteroidCollision(int[] a) {
	        int n = a.length;
	        Stack<Integer> stack = new Stack<>();
	        int i=0;
	        while(i<a.length){
	            if(stack.isEmpty() || a[i]>0 || stack.peek()<0){
	                stack.push(a[i]);
	                i++;
	            }else{
	                if(-a[i] == stack.peek()){
	                    stack.pop();
	                    i++;
	                }else if(-a[i] > stack.peek()){
	                    stack.pop();
	                }else{
	                    i++;
	                }
	            }
	        }
	        int[] res = new int[stack.size()];
	        for(int j=res.length-1; j>=0; j--){
	            res[j] = stack.pop();
	        }
	        return res;
	    }

}
