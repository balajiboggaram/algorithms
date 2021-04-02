/**
 * 
 */
package me.learn.personal.month7;

import java.util.Arrays;

/**
 * Title 805 :
 * 
 * Date : Mar 6, 2021
 * 
 * @author bramanarayan
 *
 */

/**
 * We need to split A into B and C, the length of B can be [1, A.length / 2], we
 * consider them one by one:
 * 
 * 
 * B should have the same mean value as A, so sumB / lenOfB = sumA / lenOfA,
 * which is equavalent to sumB = sumA * lenOfB / lenOfA. 
 * 
 * All elements here are
 * integers, so sumB must be an integer, this gives our first criteria (sumA *
 * lenOfB) % A.length == 0.
 * 
 * 
 * 
 * 
 * Then further in function check(int[] A, int leftSum, int leftNum, int
 * startIndex), we recursicely check if we can find lenOfB elements in A who sum
 * up to sumB.
 * 
 * 
 * 
 * 
 */
public class SplitArrayWithSameAverage {

	// see if you can find A such that sumA == sumB
	
	public boolean check(int[] A, int targetSum, int elementCount, int startIndex) {
		
	
		if (elementCount == 0) // you can choose only elementCount number of elements and target should be zero.
			return targetSum == 0; // if targetSum is zero, Viola we got it.
		
		if ((A[startIndex]) > targetSum / elementCount)
			return false;
		
		for (int i = startIndex; i < A.length - elementCount + 1; i++) {
			
			if (i > startIndex && A[i] == A[i - 1])
				continue;
			
			if (check(A, targetSum - A[i], elementCount - 1, i + 1))
				return true;
		}
		
		return false;
	}


	public boolean splitArraySameAverage(int[] A) {

		if (A.length == 1)
			return false;
		
		// compute sum of all elements in the array
		int sumA = 0;
		for (int a : A)
			sumA += a;
		
		// Sort all the elements in the array
		Arrays.sort(A);
		
		// Try to increase the length of B array. 
		for (int lenOfB = 1; lenOfB <= A.length / 2; lenOfB++) { /// Alength shouold be equal to BLength
			
			// THIS CONDITION SHOULD MEET. 
			if ((sumA * lenOfB) % A.length == 0) {
				
				if (check(A, (sumA * lenOfB) / A.length, lenOfB, 0))
					return true;
			}
		}
		return false;

	}

}
