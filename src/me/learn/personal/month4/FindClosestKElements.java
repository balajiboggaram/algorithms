/**
 * 
 */
package me.learn.personal.month4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Title 658 :
 * 
 * Given a sorted array arr, two integers k and x, find the k closest elements
 * to x in the array. The result should also be sorted in ascending order. If
 * there is a tie, the smaller elements are always preferred.
 * 
 * Example 1:
 * 
 * Input: arr = [1,2,3,4,5], k = 4, x = 3 Output: [1,2,3,4]
 * 
 * @author bramanarayan
 * @date Aug 2, 2020
 */
public class FindClosestKElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindClosestKElements solution = new FindClosestKElements();
		System.out.println(solution.findClosestElements(new int[] { 1,3 }, 1, 2));

		System.out.println(solution.findBSIndex(new int[] { 0, 0, 1, 2, 3, 3, 4, 7, 7, 8 }, 5));
		System.out.println(solution.findClosestElements(new int[] { 0, 0, 1, 2, 3, 3, 4, 7, 7, 8 }, 3, 5));
		// System.out.println(solution.testBinary(new int[] { 1, 3, 4, 8, 10 }, 5));
		System.out.println(solution.findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, 3));
		System.out.println(solution.findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, -1));
		System.out.println(solution.findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, 6));
		System.out.println(solution.findClosestElements(new int[] { 1, 1, 1, 10, 10, 10 }, 1, 9));
		System.out.println(solution.findClosestElements(new int[] { 1 }, 1, 1));

	}
	
	
public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        //find the cloest element, r is the index of the cloest element
        int l = 0, r = arr.length-1;
        while(l < r) {
            int mid = (l + r)/2;
            if(arr[mid] == x) {r = mid; break;}
            else if(arr[mid] > x) r = mid-1;
            else l = mid+1;
        }
        
        //ensure the range
        l = r;
        r++;
        while(k>0) {
            if( r >= arr.length || (l >= 0 && x-arr[l] <= arr[r] - x) ) {
                l--;
            } else {
                r++;
            }
            
            k--;
        }
        
        List<Integer> list =new ArrayList<>();
        for(int i = l+1; i < r; i++) {
            list.add(arr[i]);
        }
        return list;
    }

	public List<Integer> findClosestElementsMy(int[] arr, int k, int x) {

		int n = arr.length;
		List<Integer> result = new ArrayList<Integer>();
		

		// if the x is less than start of array, then first k elements is the answer
		if (x < arr[0]) {
			for (int i = 0; i < k; i++) {
				result.add(arr[i]);
			}
			return result;
		}

		// last k is the answer
		if (x > arr[n - 1]) {
			for (int i = n - 1; i >= n - k; i--) {
				result.add(arr[i]);
			}
			return result;
		}

		// if in between, then search both left and right side directions
		int index = findBSIndex(arr,x);
		int left = index - 1;
		int right = index + 1;
		int count = 1;
		result.add(arr[index]);
		while (count < k) {
			if (left >= 0 && right <= n - 1) {
				if (Math.abs(x - arr[left]) <= Math.abs(x - arr[right])) {
					result.add(arr[left]);
					left--;
				} else {
					result.add(arr[right]);
					right++;
				}

			} else if (left >= 0) {
				result.add(arr[left]);
				left--;
			} else if (right <= n - 1) {
				result.add(arr[right]);
				right++;
			} else {
				return new ArrayList<Integer>();
			}

			count++;
		}

		Collections.sort(result);
		return result;

	}

	// Find the closest element lesser than or equal to x
		private int findBSIndex(int[] preSum, int x) {

			int low = 0;
			int high = preSum.length - 1;
			int mid = 0;
			while (low < high) {
				mid = low + (high - low) / 2;
				
				if (preSum[mid] == x ) {
					return mid;
				} else if ( x < preSum[mid]) {
					//max = mid - 1;
					high = mid - 1;
				} else {
					//max = mid + 1;
					low = mid + 1;
				}
			}
			return mid;
		}


	public int testBinary(int[] a, int key) {
		return Arrays.binarySearch(a, key);
	}

}
