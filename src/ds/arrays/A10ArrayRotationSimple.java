package ds.arrays;

import java.util.Arrays;

/**
 * 
 * Program to rotate a given sorted array with pivot index
 * 
 * @author bboggaramrama
 *
 */
public class A10ArrayRotationSimple {
	
	public static void main(String args[]) {
		A10ArrayRotationSimple driver = new A10ArrayRotationSimple();
		driver.rotateArray(new int[]{1,2,3,4,5}, 2);
		driver.rotateArray(new int[]{1,2,3,4,5,6,7}, 3);

		
	}
	
	public void rotateArray(int[] a, int d) {
		
		// Copy the array up to d to temp array
		int[] temp = new int[d];
		for(int i=0;i<d;i++) {
			temp[i] = a[i];
		}
		
		// Now move all the elements from d to left of the array
		int k =0;
		for(int i=d;i<a.length;i++){
			a[k] = a[i];
			k++;
		}

		// Now lets copy back all the elements in temp array back to its last positions after dth index
		int j = 0;
		for (int i=k;i<a.length;i++) {
			a[i]=temp[j];
			j++;
		}
		
		System.out.println("rotated array :" + Arrays.toString(a));
	}
	
	// There is another intersting reversal solution for this problem

}
