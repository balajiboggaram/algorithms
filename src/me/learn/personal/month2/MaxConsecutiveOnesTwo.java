/**
 * 
 */
package me.learn.personal.month2;

/**
 * Title 487 :
 * 
 *   Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

Example 1:

Input: [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
    After flipping, the maximum number of consecutive 1s is 4.

Note:

    The input array will only contain 0 and 1.
    The length of input array is a positive integer and will not exceed 10,000

Follow up:
What if the input numbers come 
in one by one as an infinite stream? In other words, 
you can't store all numbers coming from the stream as
 it's too large to hold in memory. Could you solve it efficiently? 
 * 
 * @author bramanarayan
 * @date Jun 11, 2020
 */
public class MaxConsecutiveOnesTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MaxConsecutiveOnes solution = new MaxConsecutiveOnes();
		System.out.println(solution.findMaxConsecutiveOnes(new int[] {1,0,1,1,0}));
	}

	/**	
	 * An efficient solution is to walk through the bits in binary representation of given number. We keep track of current 1’s sequence length and the previous 1’s sequence length. When we see a zero, update previous Length:

    If the next bit is a 1, previous Length should be set to current Length.
    If the next bit is a 0, then we can’t merge these sequences together. So, set previous Length to 0.

We update max length by comparing following two:

    Current value of max-length
    Current-Length + Previous-Length .

result = return max-length+1 (// add 1 for flip bit count ) 
	 */
	public int findMaxConsecutiveOnes(int[] a) {

		int c = 0, p = 0;
		int n = a.length;

		int j = 0, maxCount = 0;
		while (j < n) {
			if (a[j] == 1) {
				c++;

			} else if (a[j] == 0) {
				// join '0' such that the previous becomes one more than current.
				p = c + 1; 
				c = 0; // reset the current so that it becomes prev
			}

			maxCount = Math.max(maxCount, p + c);
			j++;
		}
		return maxCount;

	}
}
