/**
 * 
 */
package me.learn.personal.month4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Title 1441 :
 * 
 *  Given an array target and an integer n. In each iteration, you will read a number from  list = {1,2,3..., n}.

Build the target array using the following operations:

    Push: Read a new element from the beginning list, and push it in the array.
    Pop: delete the last element of the array.
    If the target array is already built, stop reading more elements.

You are guaranteed that the target array is strictly increasing, only containing numbers between 1 to n inclusive.

Return the operations to build the target array.

You are guaranteed that the answer is unique.

 

Example 1:

Input: target = [1,3], n = 3
Output: ["Push","Push","Pop","Push"]
Explanation: 
Read number 1 and automatically push in the array -> [1]
Read number 2 and automatically push in the array then Pop it -> [1]
Read number 3 and automatically push in the array -> [1,3]

Example 2:

Input: target = [1,2,3], n = 3
Output: ["Push","Push","Push"]

Example 3:

Input: target = [1,2], n = 4
Output: ["Push","Push"]
Explanation: You only need to read the first 2 numbers and stop.

Example 4:

Input: target = [2,3,4], n = 4
Output: ["Push","Pop","Push","Push","Push"]

 * 
 * @author bramanarayan
 * @date Jul 29, 2020
 */
public class BuildArrayWithStackOperations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BuildArrayWithStackOperations solution = new BuildArrayWithStackOperations();
		System.out.println(solution.buildArray(new int[] {1,2,3}, 3));
		System.out.println(solution.buildArray(new int[] {1,2}, 4));
		System.out.println(solution.buildArray(new int[] {2,3,4}, 4));

	}

	
	// keep a counter count;
	// i index in the target to match
	// compare the top of stack with ith element in target
	public List<String> buildArray(int[] target, int n) {
		
		int length = target.length;
		Stack<Integer> st = new Stack<Integer>();
		int i = 0;
		List<String> result = new ArrayList<String>();
		for(int count = 1; count <= target[length-1]; count++) {
			
			st.push(count);
			result.add("Push");
			
			if(st.peek() == target[i]) {
				i++;
			} else {
				st.pop();
				result.add("Pop");
			}
			
		}
		
		return result;

	}

}
