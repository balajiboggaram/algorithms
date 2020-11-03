/**
 * 
 */
package me.learn.personal.month4;

/**
 * Title 1150 : 
 * 
 * 
 * Given an array nums sorted in non-decreasing order, and a number target, return True if and only if target is a majority element.

A majority element is an element that appears more than N/2 times in an array of length N.

 

Example 1:

Input: nums = [2,4,5,5,5,5,5,6,6], target = 5
Output: true
Explanation: 
The value 5 appears 5 times and the length of the array is 9.
Thus, 5 is a majority element because 5 > 9/2 is true.

Example 2:

Input: nums = [10,100,101,101], target = 101
Output: false
Explanation: 
The value 101 appears 2 times and the length of the array is 4.
Thus, 101 is not a majority element because 2 > 4/2 is false.

 * @author bramanarayan
 * @date Aug 6, 2020
 */
public class CheckIfMajorityElementSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CheckIfMajorityElementSortedArray solution = new CheckIfMajorityElementSortedArray();
		System.out.println(solution.isMajorityElement(new int[] {2,4,5,5,5,5,5, 6,6}, 5));
	}

	// find first index
	// find last index
	// result = lastIndex - firstIndex
	// if element do not exist, return -1
	public boolean isMajorityElement(int[] a, int target) {
			int n = a.length;
			
			int firstIndex = findFirstIndex(a, target);
			if(firstIndex == -1) return false;
			int lastIndex = findLastIndex(a, target);
			return (lastIndex  - firstIndex +1) > n/2;
	}

	private int findFirstIndex(int[] a, int target) {
		int l =0;
		int h = a.length-1;
		int index = -1;
		while(l <= h) {
			int m = l + (h-l)/2;
			if(target == a[m])  {
				index = m;
				h = m-1;
			}else if(target < a[m])  {
				h = m-1;
			} else {
				l = m +1;
			}
		}
		
		return index;
	}

	private int findLastIndex(int[] a, int target) {
		int l =0;
		int h = a.length-1;
		int index = -1;
		while(l <= h) {
			int m = l + (h-l)/2;
			if(target == a[m]) index = m;
			if(target >= a[m])  {
				l = m + 1;
			} else {
				h = m -1;
			}
		}
		
		return index;
	}

}
