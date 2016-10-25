package ds.arrays;

import java.util.Arrays;

/**
 * Reverse a array of integers
 * 
 * @author bboggaramrama
 *
 */
public class A9ReverseArray {

	public static void main(String args[]) {
		A9ReverseArray driver = new A9ReverseArray();
		driver.reverseArray(new int[] {1});
		driver.reverseArray(new int[] {1,2,3,4,5});
		driver.reverseArray(new int[] {10,34,-12});

		
	}
	
	public void reverseArray(int[] a){
		int i =0;
		int j = a.length -1 ;
		while (i <= j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
		System.out.println("Reversed array : " + Arrays.toString(a));
	}
	
}
