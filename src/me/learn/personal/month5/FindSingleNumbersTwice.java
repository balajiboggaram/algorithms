/**
 * 
 */
package me.learn.personal.month5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Title 260 :
 * 
 * Date : Jan 1, 2021
 * 
 * @author bramanarayan
 *
 */
public class FindSingleNumbersTwice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// o(n), O(n)
	public int[] singleNumber(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		Arrays.stream(nums).forEach(x -> {
			if(set.contains(x)) {
				set.remove(x);
			} else {
				set.add(x);
			}
		});
		Iterator<Integer> it = set.iterator();
		return new int[] {it.next(), it.next()};
	}
	
	// o(n) O(1) using bitmasks
	 // This function sets the values of 
    // *x and *y to non-repeating elements
    // in an array arr[] of size n
    public static void UniqueNumbers2(int[] arr,int n)
    {
        int sum =0;
        for(int i = 0;i<n;i++)
        {
           
            // Xor  all the elements of the array 
            // all the elements occuring twice will 
            // cancel out each other remaining 
            // two unnique numbers will be xored
            sum = (sum^arr[i]);
        }
       
        // Bitwise & the sum with it's 2's Complement
        // Bitwise & will give us the sum containing 
        // only the rightmost set bit
        sum = (sum&-sum);
 
        // sum1 and sum2 will contains 2 unique
        // elements elements initialized with 0 box 
        // number xored with 0 is number itself
        int sum1 = 0;
        int sum2 = 0;
 
        // traversing the array again
        for(int i = 0;i<arr.length;i++)
        {
 
            // Bitwise & the arr[i] with the sum
            // Two possibilities either result == 0 
            // or result > 0
            if((arr[i]&sum) > 0)
            {
 
                // if result > 0 then arr[i] xored 
                // with the sum1
                sum1 = (sum1^arr[i]);
            }
            else
            {
                // if result == 0 then arr[i] 
                // xored with sum2
                sum2 = (sum2^arr[i]); 
            }
        }
 
        // print the the two unique numbers
        System.out.println("The non-repeating elements are "+
                                          sum1+" and "+sum2); 
    }
 

}
