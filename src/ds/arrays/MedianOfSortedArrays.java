package ds.arrays;

/**
 * 
 * Given two sorted arrays, then find the median betwen them.
 * 
 * A median of an array is obtained as middle element when they are arranged in increasing order.
 * Suppose if the number of elements in the given array are even, then the median is taken as average of middle one's 
 * 
 * @author bboggaramrama
 */

public class MedianOfSortedArrays {
	
	
	public static void main(String args[]) {
		
		MedianOfSortedArrays driver = new MedianOfSortedArrays();
		driver.findMedian(new int[] {1,5,7}, new int[] {2,4,8});
		driver.findMedian(new int[] {1, 12, 15, 26, 38}, new int[] {2, 13, 17, 30, 45});	
	}
	
	/**
	 * In this method, I will use the merge step, start comparing one by one. 
	 * Keep a counter, increment the counter up to n (since there are 2n elements) and then element when count=n is the median
	 * Keep two pointers in a and b arrays, increment/decrement pointers accordingly with lowest.
	 * 
	 * Note : assume the number of elements in each array are n only
	 */
	public void findMedian(int[] a, int[] b) {
		
		int n = a.length;
		int count = 0, i =0, j=0;
		int median1 = 0;
		int median2 = 0;
		int smallest = 0;
		while (count <= n && i<n && j<n) {			
			if(a[i] > b[j]) {
				smallest = b[j]; 
				j++;
			} else if (b[j] > a[i]) {
				smallest = a[i];
				i++;
			} else {
				smallest = a[i];
				i++;
				j++;
				count++;
			}
			if(count == n-1) {
				median1 = smallest;
			}
			if(count == n) {
				median2 = smallest;
			}

			count++;			
		}		
		System.out.println("Median is :" + (median1 + median2)/2);
	}
	
	/**
	 * IN other way, we can compute median of first array = m1, 
	 * median of second array = m2.
	 * 
	 * now, if m1 == m2, then return m1 or m2 as median of two arrays
	 * if m2> m1, then median lies between second half of first array and first half of second array
	 * if m1 > m2, then median lies between first half of first array and second half of second array.
	 * 
	 * We can simple write a recursive program to achieve this. Note : we need to handle odd/even cases too here.
	 */
	

}
