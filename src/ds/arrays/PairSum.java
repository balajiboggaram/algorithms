package ds.arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers, and then a number "sum", Verify if any two numbers adds up to "sum"
 * 
 * @author Balaji Boggaram
 *
 */
public class PairSum {

	public static void main(String[] args) {
		PairSum pairSumDriver = new PairSum();
		
		// Method 1
		pairSumDriver.checkPairSum(new int[] {1,3,4}, 5);
		pairSumDriver.checkPairSum(new int[] {1,3,4,6}, 10);
		pairSumDriver.checkPairSum(new int[] {1,3,4,6}, 16);

		// Method 2
		pairSumDriver.checkPairSum2(new int[] {1,3,4}, 5);
		pairSumDriver.checkPairSum2(new int[] {1,3,4,6}, 10);
		pairSumDriver.checkPairSum2(new int[] {1,3,4,6}, 16);

	}
	
	/**
	 * METHOD 1 : Using HashMap
	 * 
	 * Lets have a HashMap<Integer,Integer> which stores (sum-x, x)
	 * When an integer 'x' is read from an input array, then 
	 * 1. Try to retreive (sum-x) as key from hashmap, 
	 *   1.1 If it exists, then return sum-x, and x as pair of elements 
	 *   1.2 If it doesn't exist, then just put sum-x,x in to hashmap
	 * 
	 * 2. Exit : Return as no pair if we cannot find (sum-x) as key from hashmap 
	 */
	
	public boolean checkPairSum(int a[], int sum) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			int x = a[i];
			if (map.containsKey(x)) {
				System.out.println(String.format("Pair sum constitues elements : %d and %d", sum - x, x));
				return true;
			} else {
				map.put(sum - x, x);
			}
		}
		System.out.println("No pair exists in array that constitute sum : " + sum);
		return false;
	}
	
	/**
	 * METHOD 2 : via Sorting
	 * 
	 * Lets sort the array of integers in ascending order 
	 * Once sorting is done, keep two pointers i and j which positions at start and end respectively
	 * Now, Lets start reading integer array one by one (from start and end both sides) - 
	 *      For now, Lets call the element read as 'x' positioned at i
	 *      and then 'y' as element read as position j
	 * if (x+y) == sum, then Hurray !! we found that there does exists a pair that constitutes sum
	 * if (x+y) < sum, then increment i
	 * else decrement j
	 * 
	 *  if both pointers i and j cross, then we did not find any pair. This will be the exit condition of program
	 * 
	 */
	
	public boolean checkPairSum2(int a[], int sum) {
		
		// Sort the array
		Arrays.sort(a);
		
		// keep two pointers i and j
		int i =0; 
		int j= a.length-1;
		
		while (j>i) {
			int x = a[i];
			int y = a[j];
			if((x +y) == sum) {
				System.out.println(String.format("Pair sum constitues elements : %d and %d", x,y ));
				return true;
			} else if ( (x+y) < sum) {
				i++;
			} else {
				j--;
			}
		}
		
		System.out.println("No pair exists in array that constitute sum : " + sum);
		return false;		
	}
	

}
