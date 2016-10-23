package ds.arrays;


/**
 * 
 * Given an array of 'n-1' elements that are in range from 0 to n-1 except one missing number.
 * 
 *  Note that there arent any duplicates
 * 
 * @author bboggaramrama
 */
public class MissingNumber {

	public static void main(String args[]) {
		MissingNumber driver = new MissingNumber();
		driver.findMissingNumber(new int[] {1,2,3,5});
		driver.findMissingNumber(new int[] {1,2,3,4,5,7});
		driver.findMissingNumber(new int[] {1,2,4});
		driver.findMissingNumber(new int[] {1,2,3,4,5,6,7,8,9,11});
	}
	
	/**
	 * In this method, I use standard sigma (n) formula to find sum of elements from 1 to n
	 * 
	 *  sigma(n) = n*(n+1)/2
	 */
	public void findMissingNumber(int[] a) {
		int n = a.length + 1;
		int sigmaSum = n * (n + 1) / 2;
		int actualSum = 0;
		for (int i = 0; i < a.length; i++) {
			actualSum = actualSum + a[i];
		}
		System.out.println("The missing number is : " + (sigmaSum - actualSum));
	}
	
}
