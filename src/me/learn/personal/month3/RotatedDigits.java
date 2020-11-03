/**
 * 
 */
package me.learn.personal.month3;

import java.util.Arrays;
import java.util.List;

/**
 * Title 788 :
 * 
 * X is a good number if after rotating each digit individually by 180 degrees,
 * we get a valid number that is different from X. Each digit must be rotated -
 * we cannot choose to leave it alone.
 * 
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8
 * rotate to themselves; 2 and 5 rotate to each other (on this case they are
 * rotated in a different direction, in other words 2 or 5 gets mirrored); 6 and
 * 9 rotate to each other, and the rest of the numbers do not rotate to any
 * other number and become invalid.
 * 
 * Now given a positive number N, how many numbers X from 1 to N are good?
 * 
 * Example: Input: 10 Output: 4 Explanation: There are four good numbers in the
 * range [1, 10] : 2, 5, 6, 9. Note that 1 and 10 are not good numbers, since
 * they remain unchanged after rotating.
 * 
 * 
 * @author bramanarayan
 * @date Jul 6, 2020
 */
public class RotatedDigits {

	List<Integer> valid = Arrays.asList(2, 5, 6, 9);
	List<Integer> inValid = Arrays.asList(3, 4, 7);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RotatedDigits solution = new RotatedDigits();
		System.out.println(solution.rotatedDigits(10));
		System.out.println(solution.rotatedDigits(857));

	}


    
    public boolean isValid(int N) {
        /*
         Valid if N contains ATLEAST ONE 2, 5, 6, 9
         AND NO 3, 4 or 7s
         */
        boolean validFound = false;
        while (N > 0) {
            if (N % 10 == 2) validFound = true;
            if (N % 10 == 5) validFound = true;
            if (N % 10 == 6) validFound = true;
            if (N % 10 == 9) validFound = true;
        
            if (N % 10 == 3) return false;
            if (N % 10 == 4) return false;
            if (N % 10 == 7) return false;
            N = N / 10;
        }
        return validFound;
    }
	
	

	public int rotatedDigits(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (isValid(i)) {
				count++;
			}
		}
		return count;
	}


}
