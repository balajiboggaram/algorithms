/**
 * 
 */
package me.learn.personal.month4;

/**
 * Title 704 :
 * 
 * @author bramanarayan
 * @date Aug 3, 2020
 */
public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BinarySearch solution = new BinarySearch();
		System.out.println(solution.search(new int[] {-1,0,3,5,9,12}, 13));
	}

	public int search(int[] nums, int target) {
		int l = 0;
		int h = nums.length;
		if(nums[h-1] < target || nums[0] > target) return -1;
		
		while(l <= h) {
			int mid = l + (h-l)/2;
			if(nums[mid] == target) return mid;
			else if(target > nums[mid]) l = mid +1;
			else h = mid -1;
		}
		return -1;
	}
}
