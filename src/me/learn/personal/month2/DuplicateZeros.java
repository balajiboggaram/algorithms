/**
 * 
 */
package me.learn.personal.month2;

/**
 * Title 1089 :
 * 
 *  Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.

Do the above modifications to the input array in place, do not return anything from your function.

Example 1:

Input: [1,0,2,3,0,4,5,0]
Output: null
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]

Example 2:

Input: [1,2,3]
Output: null
Explanation: After calling your function, the input array is modified to: [1,2,3]

 * 
 * @author bramanarayan
 * @date Jun 10, 2020
 */
public class DuplicateZeros {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void duplicateZeros(int[] arr) {
        int count = 0;
        int n = arr.length - 1;

        // Find the number of zeros to be duplicated
        // Stopping when left points beyond the last element in the original array
        // which would be part of the modified array
        for (int i = 0; i <= n - count; i++) {

            // Count the zeros
            if (arr[i] == 0) {

                // Edge case: This zero can't be duplicated. We have no more space,
                // as left is pointing to the last element which could be included  
                if (i == n - count) {
                    // For this zero we just copy it without duplication.
                    arr[n] = 0;
                    n -= 1;
                    break;
                }
                count++;
            }
        }

        // Start backwards from the last element which would be part of new array.
        int last = n - count;

        // Copy zero twice, and non zero once.
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + count] = 0;
                count--;
                arr[i + count] = 0;
            } else {
                arr[i + count] = arr[i];
            }
        }
    }

}
