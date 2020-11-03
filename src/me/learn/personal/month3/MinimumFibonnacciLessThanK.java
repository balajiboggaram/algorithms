/**
 * 
 */
package me.learn.personal.month3;

import java.util.ArrayList;
import java.util.List;

/**
 * Title 1414 :
 * 
 * Given the number k, return the minimum number of Fibonacci numbers whose sum
 * is equal to k, whether a Fibonacci number could be used multiple times.
 * 
 * The Fibonacci numbers are defined as:
 * 
 * F1 = 1 F2 = 1 Fn = Fn-1 + Fn-2 , for n > 2.
 * 
 * It is guaranteed that for the given constraints we can always find such
 * fibonacci numbers that sum k.
 * 
 * 
 * @author bramanarayan
 * @date Jun 24, 2020
 */
public class MinimumFibonnacciLessThanK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinimumFibonnacciLessThanK solution = new MinimumFibonnacciLessThanK();
		System.out.println(solution.findMinFibonacciNumbers(7));
		System.out.println(solution.findMinFibonacciNumbers(10));
		System.out.println(solution.findMinFibonacciNumbers(19));

	}

	// Catch : You can use the same highest fib number to make up to k
	public int findMinFibonacciNumbers(int k) {
		if(k ==0) return 0;
		if(k ==1 || k ==2) return 1;
		int count = 0;
		
		// Step 1: Find all the fibonacci numbers less than k
		List<Integer> fib = findAllFib(k);
		
		// Keep picking the elements (as many times as you can) from the last (which is highests)
		int j = fib.size()-1;
		while(k > 0) {
			count = count + (k / fib.get(j));
			k = k % fib.get(j);
			j--;
		}
		
		return count;
		
	}
	
	// Compute all the fibonacci numbers less than k
	private List<Integer> findAllFib(int k) {
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(1);
		int prev1 =1 ;
		int prev2 = 1;
		while(prev2 < k) {
			int temp = prev1 + prev2;
			a.add(temp);
			prev1 = prev2;
			prev2 = temp;
		}
		return a;
		
	}

}
