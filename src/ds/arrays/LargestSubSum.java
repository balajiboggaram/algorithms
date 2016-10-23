package ds.arrays;

/**
 * This algorithm finds the largest sub sum of contiguous array. This also present indicies of
 * the largest sub sum array. Its known as famous Kadane Algorithm 
 * 
 * @author bboggaramrama
 *
 */
public class LargestSubSum {
	
	public static void main(String args[]) {
		
		LargestSubSum driver = new LargestSubSum();
		driver.computeLargestSubsum(new int[] {1,2,4,6});
		driver.computeLargestSubsum(new int[] {1,2,4,-6});
		driver.computeLargestSubsum(new int[] {1,-3,4,-6});
		driver.computeLargestSubsum(new int[] {-1,-2,-4,-6});
	}
	
	public void computeLargestSubsum(int[] a) {
		int maxSoFar = a[0];
		int currentMax = a[0];
		int maxStartIndex = 0;
		int maxEndIndex = 0;
		int currentStartIndex = 0;

		for (int i = 1; i < a.length; i++) {
			// Add the element to currentMax
			currentMax = currentMax + a[i];
			
			// Check if adding a new element brought to sum to be negative
			if (currentMax < 0) {
				currentMax = 0;
				currentStartIndex = i+1;
			} else if (currentMax > maxSoFar) {
				maxSoFar = currentMax;
				maxStartIndex = currentStartIndex;
				maxEndIndex = i;
			}

		}
		System.out.println("Largest sub sum of array is :" + maxSoFar);
		System.out.println(String.format("StartIndex : %d, EndIndex : %d", maxStartIndex, maxEndIndex));
	}

}
