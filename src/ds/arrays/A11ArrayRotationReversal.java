package ds.arrays;

import java.util.Arrays;

public class A11ArrayRotationReversal {
	
	public static void main(String args[]) {
		A11ArrayRotationReversal driver = new A11ArrayRotationReversal();
		driver.rotateArrayViaReversalMethod(new int[] {1,2,3,4,5}, 2);
		driver.rotateArrayViaReversalMethod(new int[] {1,2,3,4,5,6,7}, 3);
		driver.rotateArrayViaReversalMethod(new int[] {1,2,3,4,5}, 5);

	}
	
	/**
	 * Reverse1 : First reverse only elements up to d
	 * Reverse 2 : Second reverse elements from d to n
	 * Reverse 3 : Third reverse elements from 0 to n 
	 */
	public void rotateArrayViaReversalMethod(int[] a, int d) {
		reverseArray(a,0,d-1);
		reverseArray(a, d,a.length-1);
		reverseArray(a, 0, a.length-1);
		System.out.println("Rotated array is :" + Arrays.toString(a));
		
		
	}
	
	public int[] reverseArray(int[] a,int i, int j){
		while (i <= j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
		return a;
	}

}
