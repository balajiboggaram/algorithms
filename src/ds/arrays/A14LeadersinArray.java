package ds.arrays;

import java.util.Arrays;

/**
 * Find all the leaders in a given array. A leader (a[i]) is an element in which 
 * a[i]> a[j], and j>i.
 * 
 * @author bboggaramrama
 *
 */
public class A14LeadersinArray {
	
	public static void main(String args[]) {
		A14LeadersinArray driver = new A14LeadersinArray();
		driver.findLeader(new int[] {16,17,4,3,5,2});
	}
	
	/**
	 * The idea here is that you iterate from right side of the array. 
	 * Keep a max so far you have seen till now. 
	 * @param a
	 */
	public void findLeader(int[] a) {
		int n = a.length - 1;
		int max = a[n];
		int[] leaders = new int[n];
		int k =0;
		leaders[k++] = a[n];
		for (int i = n; i >= 0; i--) {
			if(max < a[i]) {
				leaders[k++] = a[i];
				max = a[i];
			}
		}
		System.out.println("Leaders : " + Arrays.toString(leaders));
	}

}
