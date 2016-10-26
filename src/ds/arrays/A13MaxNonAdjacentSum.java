package ds.arrays;

/**
 * Given a list of integers, Find the maximum non-adjacent sum. i.e sum obtained by adding non-adjacent elements in the array
 * 
 * @author bboggaramrama
 *
 */
public class A13MaxNonAdjacentSum {

	
	public static void main(String args[]){
		A13MaxNonAdjacentSum driver = new A13MaxNonAdjacentSum();
		driver.findMaxNonAdjacentSum(new int[] {5,5,10,100,10,5});
		driver.findMaxNonAdjacentSum(new int[] {-5,5,-10,15,-10,5});

	}
	
	/**
	 * At every element, maintain a max exclusive and max inclusive. 
	 * 
	 *  Init : maxInclusive = first element of array, maxExclusive = 0
	 *  
	 *  at every element of array, do this :
	 *  
	 *  maxExclusiveTemp = max(maxInclusice, maxExclusive) - these are from previous step
	 *  minInclusive = maxExclusive + current element (compute inclusive of current step)
	 *  maxExclusice = maxExclusiveTemp (Compute exclusive of current step)
	 *  
	 */
	public void findMaxNonAdjacentSum(int[] a) {
		
		int maxExclusive= 0;
		int maxInclusive = a[0];
		for (int i =1; i< a.length; i++) {
			int maxExclusiveTemp = maxExclusive > maxInclusive ? maxExclusive : maxInclusive;
			maxInclusive = maxExclusive + a[i];
			maxExclusive = maxExclusiveTemp;
		}
		
		System.out.println("The maximum non-adjacent sum is :" + (maxExclusive > maxInclusive ? maxExclusive : maxInclusive));
		
	}
	
}
