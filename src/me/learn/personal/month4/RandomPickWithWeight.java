/**
 * 
 */
package me.learn.personal.month4;

import java.util.Arrays;
import java.util.Random;

/**
 * Title 528 :
 * 
 *  Given an array w of positive integers, where w[i] describes the weight of index i(0-indexed), write a function pickIndex which randomly picks an index in proportion to its weight.

For example, given an input list of values w = [2, 8], when we pick up a number out of it, the chance is that 8 times out of 10 we should pick the number 1 as the answer since it's the second element of the array (w[1] = 8).

Example 1:

Input
["Solution","pickIndex"]
[[[1]],[]]
Output
[null,0]

Explanation
Solution solution = new Solution([1]);
solution.pickIndex(); // return 0. Since there is only one single element on the array the only option is to return the first element.

 * 
 * @author bramanarayan
 * @date Aug 2, 2020
 */
public class RandomPickWithWeight {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SolutionRandPick solution = new SolutionRandPick(new int[] {1,3});
		// solution = new SolutionRandPick(new int[] {1});

		System.out.println(solution.pickIndex());
		System.out.println(solution.pickIndex());

		System.out.println(solution.pickIndex());
		System.out.println(solution.pickIndex());
		System.out.println(solution.pickIndex());
		System.out.println(solution.pickIndex());

	}

}

class SolutionRandPick {

	int[] a;
	int[] preSum;
	int sum= 0;
	Random r = new Random();
	
    public SolutionRandPick(int[] w) {
    	preSum = new int[w.length];
    	a = Arrays.copyOf(w, w.length);
    	preSum[0] = a[0];
        for(int i =1;i<a.length;i++) {
        	sum += a[i];
        	preSum[i] = sum;
        }    
    }
   
    public int pickIndex() {
    	
    	if(sum == 0) return 0;
    	
    	int x = r.nextInt(sum) +1;
    	
    	return findBSIndex(x);
    	
    }

    // Find the closest element greater than or equal to x
	private int findBSIndex(int x) {
		
		int low = 0;
		int high =  a.length-1;
		int max = -1;
		while(low < high) {
			int mid = low + (high - low)/2;
			if(preSum[mid] == x) {
				return mid;
			} else if(preSum[mid] > x) {
				max = mid;
				high  = mid ;
			} else {
				low = mid +1;
			}
		}
		return low;
	}
}

/**
 * Working answer: 
 * 
 * class Solution {

    Random random;
    int[] wSums;
    
    public Solution(int[] w) {
        this.random = new Random();
        for(int i=1; i<w.length; ++i)
            w[i] += w[i-1];
        this.wSums = w;
    }
    
    public int pickIndex() {
        int len = wSums.length;
        int idx = random.nextInt(wSums[len-1]) + 1;
        int left = 0, right = len - 1;
        // search position 
        while(left < right){
            int mid = left + (right-left)/2;
            if(wSums[mid] == idx)
                return mid;
            else if(wSums[mid] < idx)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
*/
