/**
 * 
 */
package me.learn.personal.month4;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Title 341 :
 * 
 * Given a nested list of integers, implement an iterator to flatten it.
 * 
 * Each element is either an integer, or a list -- whose elements may also be
 * integers or other lists.
 * 
 * Example 1:
 * 
 * Input: [[1,1],2,[1,1]] Output: [1,1,2,1,1] Explanation: By calling next
 * repeatedly until hasNext returns false, the order of elements returned by
 * next should be: [1,1,2,1,1].
 * 
 * Example 2:
 * 
 * Input: [1,[4,[6]]] Output: [1,4,6] Explanation: By calling next repeatedly
 * until hasNext returns false, the order of elements returned by next should
 * be: [1,4,6].
 * 
 * 
 * 
 * @author bramanarayan
 * @date Jul 27, 2020
 */
public class FlattenNestedIterator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}

class NestedIterator implements Iterator<Integer> {

	Stack<NestedInteger> st = new Stack<NestedInteger>();
	
	// put all the contents to stack 
	public NestedIterator(List<NestedInteger> nestedList) {
		for(int i = nestedList.size()-1;i>=0;i--) {
			st.push(nestedList.get(i));
		}
	}

	@Override
	public Integer next() {
		if(hasNext()) {
			return st.pop().getInteger(); // its always an integer here.			
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public boolean hasNext() {
		
		if(st.isEmpty()) return false;
		
		// make sure the top element in stack is an integer.
		while(!st.isEmpty() && !st.peek().isInteger()) { // if its not an integer
			List<NestedInteger> tempList = st.pop().getList(); // its a list here now.
			for(int i = tempList.size()-1;i>=0;i--) {
				st.push(tempList.get(i));
			}
		}
		
		return !st.isEmpty();
	}
}

// mock interface
interface NestedInteger {
	public boolean isInteger();

	public Integer getInteger();

	public List<NestedInteger> getList();
}
