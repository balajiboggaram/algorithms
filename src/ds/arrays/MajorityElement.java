package ds.arrays;

/**
 * This algorithm finds the majority element in a given array of integers. A majority element is defined as something
 * which repeats more than n/2 number of times in a array of length n. 
 * 
 * Note : This called as Moores Voting Algorithm
 * 
 * @author bboggaramrama
 *
 */

public class MajorityElement {
	
	public static void main(String args[]) {
		
		MajorityElement driver = new MajorityElement();
		
		driver.findMajorityElement(new int[] {1,1,1,3});
		driver.findMajorityElement(new int[] {1,3});
		driver.findMajorityElement(new int[] {6,5,5,5,3});
		driver.findMajorityElement(new int[] {6,6,6,5,7,7,7,7,7,7});

	}
		
	public void findMajorityElement(int[] a) {
		
		// FIND THE PROBABLE CANDIDATE THROUGH VOTING PROCESS
		
		int majorityElement = a[0]; // Assume that first element is the majority element
		int count = 1; // Count is one here based on above assumption
		for (int i = 1; i < a.length-1; i++) {
			if (a[i] == majorityElement) {
				count++;
			} else {
				count--;
			}

			// reset counter
			if (count == 0) {
				count = 1;
				majorityElement = a[i];
			}
		}
		
		// lets see if the majorityElement is actually present more than n/2 times
		int num = 0;
		for( int i=0;i<a.length;i++) {
			if(a[i] == majorityElement) {
				num++;
			}			
		}
		if( num> (a.length/2)) {
			System.out.println("Majority Element in the given array is:" + majorityElement);
			return;
		}  
		// Exit condition
		System.out.println("There is no majority element in the given array");
	}
}
