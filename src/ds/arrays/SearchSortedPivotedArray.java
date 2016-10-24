package ds.arrays;

/**
 * Given an array with n integers which are sorted and rotated with some pivot 't' less than n. 
 * 
 * Given a key, Can you search for the key in the above pivoted array in O(log n) ? 
 * 
 * @author bboggaramrama
 *
 */
public class SearchSortedPivotedArray {
	
	public static void main(String args[]) {
		SearchSortedPivotedArray driver = new SearchSortedPivotedArray();
		
		// Tests
		driver.searchKeyInPivotedArray(new int[] {1,3,5}, 3, 0, 2);
		driver.searchKeyInPivotedArray(new int[] {1,3,5,6,8},6, 0, 4);
		driver.searchKeyInPivotedArray(new int[] {1,3,5},5, 0 , 2);
		driver.searchKeyInPivotedArray(new int[] {1,3,5},8,0,2);

	}
	
	/**
	 * In this method, I use the binary search on sorted array to find the key in O(log n)
	 * 
	 * Basically, the important property to notice is that, In a rotated sorted array with any pivot,
	 * one half of the array is always sorted. We can take advantage of this to search key.
	 * 
	 * 1. Find the mid
	 * 2. If mid element is key, then return found
	 * 3. If first element is less than mid element (first half of array is sorted)
	 *      if key is less than mid, then search first half(till mid-1), else second half (from mid+1)
	 * 4. If mid element is smaller than last element (then second half of array is sorted)
	 *      If key is less than mid, then search first hald, else second half.
	 *      
	 *  NOTE : The one good optimization is that we can search the key in just one pass of the array rather two (simple solution)
	 */
	public int searchKeyInPivotedArray(int[] a, int key, int low, int high) {

		int mid = low + (high-low) /2;
		
		if(low > high) {
			System.out.println("Key not found !! ");
			return -1;
		}
		
		if(a[mid] == key) {
			System.out.println(String.format("Key %d found", key ));
			return mid;
		}
		
		// Lets see if first half of array is sorted
		if(a[low] <= a[mid]){
			if(a[mid] >= key) {
				return searchKeyInPivotedArray(a, key, low, mid-1); // Search left half now...
			} else {
				return searchKeyInPivotedArray(a, key, mid+1, high); // Search right half now...
			}
		}
		
		// second half of array is sorted
		if(a[mid] <= key) {
				return searchKeyInPivotedArray(a, key, mid+1, high); // Search right half now...
			} else {
				return searchKeyInPivotedArray(a, key, low, mid-1); // Search left half now...
			}
		}
}
