/**
 * 
 */
package me.learn.personal.month4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title 1237 :
 * 
 *  
 * Given a function  f(x, y) and a value z, return all positive integer pairs x and y where f(x,y) == z.

The function is constantly increasing, i.e.:

    f(x, y) < f(x + 1, y)
    f(x, y) < f(x, y + 1)

The function interface is defined like this: 

interface CustomFunction {
public:
  // Returns positive integer f(x, y) for any given positive integer x and y.
  int f(int x, int y);
};

For custom testing purposes you're given an integer function_id and a target z as input, where function_id represent one function from an secret internal list, on the examples you'll know only two functions from the list.  

You may return the solutions in any order.
 * @author bramanarayan
 * @date Aug 6, 2020
 */
public class FindPositiveIntegerForEquation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Binary search
	public List<List<Integer>> findSolution(CustomFunction cf, int z) {
		int x = 1;
		int y = 1001;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		while(x < 1001 && y >=1 ) {
			int val = cf.f(x,y);
			if( val == z ) {
				result.add(Arrays.asList(x,y));
				x++;
				y--;
			} else if (val < z ) {
				x++; // increment on less 
			} else {
				y--; // decrement on more
			}
		}
		return result;
	}

}

// Mock class
class CustomFunction {

	public int f(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
