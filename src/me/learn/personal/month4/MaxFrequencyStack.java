/**
 * 
 */
package me.learn.personal.month4;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Title 895 :
 * 
 *  Implement FreqStack, a class which simulates the operation of a stack-like data structure.

FreqStack has two functions:

    push(int x), which pushes an integer x onto the stack.
    pop(), which removes and returns the most frequent element in the stack.
        If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.

 

Example 1:

Input: 
["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
[[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
Output: [null,null,null,null,null,null,null,5,7,5,4]
Explanation:
After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to top.  Then:

pop() -> returns 5, as 5 is the most frequent.
The stack becomes [5,7,5,7,4].

pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
The stack becomes [5,7,5,4].

pop() -> returns 5.
The stack becomes [5,7,4].

pop() -> returns 4.
The stack becomes [5,7].

 * 
 * @author bramanarayan
 * @date Jul 29, 2020
 */
public class MaxFrequencyStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FreqStack solution = new FreqStack();
		solution.push(5);
		solution.push(7);
		solution.push(5);
		solution.push(7);
		solution.push(4);
		solution.push(5);
		System.out.println(solution.pop());
	}

}

// element -> frequency 
// frequencey -> elements (stack)
class FreqStack {

	Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
	Map<Integer,Stack<Integer>> smap = new HashMap<>();
	int max = 0;
	
    public FreqStack() {
        
    }
    
	public void push(int x) {
		
		int freq =  countMap.getOrDefault(x, 0) + 1 ;
		// update frequency in countMap
		countMap.put(x, freq);
		
		System.out.println("frequency : " + freq);
		
		// add the element to stack if the frequency is found.
		smap.computeIfAbsent(freq, f -> new Stack<Integer>()).push(x);
		
		
		if(freq > max) {
			max = freq;
		}
	}
    
    public int pop() {
 
    	System.out.println(max);
    	int element = smap.get(max).pop();
    	
    	// decrement in the countMap
    	countMap.put(element, countMap.get(element)-1);
    	
    	// remove from smap is no more element in the stack
    	if(smap.get(max).size() ==0) {
    		smap.remove(max);
    		max = max -1;
    	}
    	return element;
    	
    }
}
