/**
 * 
 */
package me.learn.personal.month4;

import java.util.Arrays;

/**
 * Title 556 :
 * 
 * Given a positive 32-bit integer n, you need to find the smallest 32-bit
 * integer which has exactly the same digits existing in the integer n and is
 * greater in value than n. If no such positive 32-bit integer exists, you need
 * to return -1.
 * 
 * Example 1:
 * 
 * Input: 12 Output: 21
 * 
 * 
 * @author bramanarayan
 * @date Jul 22, 2020
 */
public class NextGreaterElementThree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		NextGreaterElementThree solution = new NextGreaterElementThree();
		//System.out.println(solution.nextGreaterElement(124651));

		System.out.println(solution.nextGreaterElement(12));

	}

	// SHITTY ALGORITHM
	// No way you can get this straight in interview, unless you belong to Einstein
	// family or something :)
	public int nextGreaterElement(int num) {

		// convert to char array
		char[] c = String.valueOf(num).toCharArray();

		int n = c.length;
		int smallest = -1;
		int biggest = Integer.MAX_VALUE;

		// find smallest
		int i = n - 2;
		for (; i >= 0; i--) {
			if (c[i] < c[i + 1]) {
				smallest = i;
				break;
			}
		}
		System.out.println(smallest);

		// edge case
		if(smallest == -1) return -1;
		
		// find bigger smallest
		for (int j = i + 1; j < n; j++) {
			if(c[j] > c[smallest] ) {
				if(biggest == Integer.MAX_VALUE) {
					biggest = j;
				}else if(biggest != Integer.MAX_VALUE && c[biggest] > c[j]) {
					biggest = j;					
				}
			}
		}
		
		System.out.println(biggest);
		
		// swap the small and big
		char temp = c[smallest];
		c[smallest] = c[biggest];
		c[biggest] = temp;
		
		reverse(c, smallest+1);
		
		return Integer.parseInt(String.valueOf(c));
		
	}
	
	private void reverse(char[] a, int start) {
        int i = start, j = a.length - 1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }
	
	private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
