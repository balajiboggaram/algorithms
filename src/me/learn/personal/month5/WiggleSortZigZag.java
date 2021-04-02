/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Title 324 :
 * 
 * Date : Jan 8, 2021
 * 
 * @author bramanarayan
 *
 */
public class WiggleSortZigZag {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// a[i-1] < a[i] > a[i+1] < a[i+2] > a[i+3]

	// just ensure the even indexed element is always greater than its neighboring
	// odd elements.
	// if not swap them
	// Does not work for duplicates
	public void wiggleSortNoDuplicates(int[] nums) {

		int n = nums.length;
		for (int i = 0; i < nums.length; i += 2) {
			if (i > 0 && nums[i - 1] > nums[i]) // if left odd is greater than my current(even)
				swap(nums, i, i - 1);

			if (i < n && nums[i + 1] > nums[i]) {
				swap(nums, i, i + 1);
			}

		}
	}

	private void swap(int[] nums, int i, int j) {

		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	
	// Works With duplicates
	// get the median - kth largest (depending on odd or even)
	// put the elements in to parts (lesss than median) and (greater than median)
	// now do a merge from right to left
	public void wiggleSort(int[] nums) {
		int n = nums.length;

		// int median = selectKth(nums, 0, nums.length - 1, nums.length % 2 == 0 ?
		// nums.length / 2 : nums.length / 2 + 1);

		int K = n % 2 == 0 ? (n / 2) : (n / 2 + 1);
		int median = KthLargest(K, nums);

		List<Integer> leftArr = new ArrayList();
		for (int i = 0; i <= median; i++)
			leftArr.add(nums[i]);

		List<Integer> rightArr = new ArrayList();
		for (int i = median + 1; i < nums.length; i++)
			rightArr.add(nums[i]);

		int left = leftArr.size() - 1;
		int right = rightArr.size() - 1;
		int kindex = 0;
		while (left >= 0 && right >= 0) {
			nums[kindex] = leftArr.get(left);
			nums[kindex + 1] = rightArr.get(right);
			left--;
			right--;
			kindex = kindex + 2;
		}

		if (nums.length % 2 != 0)
			nums[nums.length - 1] = leftArr.get(0);
	}

	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

	private int KthLargest(int k, int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			pq.add(nums[i]);
			if (pq.size() > k) {
				pq.remove();
			}
		}
		int element = pq.peek();
		return element;
	}

	private int selectKth(int[] nums, int start, int end, int k) {
		int[] res = partition(nums, start, end);
		int lb = res[0];
		int hb = res[1];
		if (k - 1 < lb)
			return selectKth(nums, start, lb - 1, k);
		else if (k - 1 > hb)
			return selectKth(nums, hb + 1, end, k);
		else
			return k - 1;
	}

	private int[] partition(int[] nums, int lb, int hb) {
		int pVal = nums[lb]; // use random genarater is better in performance
		int i = lb;
		while (i <= hb) {
			if (nums[i] == pVal)
				i++;
			else if (nums[i] < pVal)
				swap(nums, i++, lb++);
			else
				swap(nums, i, hb--);
		}
		int[] res = new int[2];
		res[0] = lb;
		res[1] = hb;
		return res;
	}

}
