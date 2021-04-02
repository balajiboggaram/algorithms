/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.List;

/**
 * Title 412 :
 * 
 * Date : Dec 30, 2020
 * 
 * @author bramanarayan
 *
 */
public class FizzBuzz {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// output string representation of numbers from 1 to n
	// multiples of 3 -> fizz
	// multiples of 5 -> Buzz
	public List<String> fizzBuzz(int n) {
		
		List<String> result = new ArrayList<String>();
		if( n ==0) return result;
		
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				result.add("FizzBuzz");
			} else if (i % 3 == 0) {
				result.add("Fizz");
			} else if (i % 5 == 0) {
				result.add("Buzz");
			} else {
				result.add(String.valueOf(i));
			}
		}
		return result;
	}

}
