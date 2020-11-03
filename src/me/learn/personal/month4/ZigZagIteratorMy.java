/**
 * 
 */
package me.learn.personal.month4;

import java.util.Arrays;
import java.util.List;

/**
 * Title 281 :
 * 
 * Given two 1d vectors, implement an iterator to return their elements
 * alternately.
 * 
 * 
 * 
 * Example:
 * 
 * Input: v1 = [1,2] v2 = [3,4,5,6] Output: [1,3,2,4,5,6] Explanation: By
 * calling next repeatedly until hasNext returns false, the order of elements
 * returned by next should be: [1,3,2,4,5,6].
 * 
 * @author bramanarayan
 * @date Jul 27, 2020
 */
public class ZigZagIteratorMy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ZigzagIterator solution = new ZigzagIterator(Arrays.asList(1,2), Arrays.asList(3,4,5,6));
		System.out.println(solution.next());
		System.out.println(solution.next());
		System.out.println(solution.next());
		System.out.println(solution.next());
		System.out.println(solution.next());
		System.out.println(solution.next());
		System.out.println(solution.next());
		System.out.println(solution.next());

	}

}

class ZigzagIterator {

	boolean first = true;
	List<Integer> v1;
	List<Integer> v2;
	int ptr1 = 0;
	int ptr2 = 0;

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		this.first = true;
		this.v1 = v1;
		this.v2 = v2;
	}

	public int next() {
		int result = -1;
		if (ptr1 < v1.size() && ptr2 < v2.size()) {
			if(first) {
				result = v1.get(ptr1++);
				first = false;
				return result;
			} else {
				result = v2.get(ptr2++);
				first = true;
				return result;
			}
		}
		
		// if only v1 exists
		if(ptr1 < v1.size()) {
			result = v1.get(ptr1++);
		}
		
		// if only v2 exists
		if(ptr2 < v2.size()) {
			result = v2.get(ptr2++);
		}
		
		return result;
	}

	public boolean hasNext() {
		return ptr1 < v1.size() || ptr2 < v2.size();
	}
}