/**
 * 
 */
package me.learn.personal.month5;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Title 480 :
 * 
 * Date : Jan 3, 2021
 * 
 * @author bramanarayan
 *
 */
public class SlidingWindowMedian {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// USE SAME TECHNIQUE FOR MEDIAN OF DATA STREAM. the only thing is there is no concept of remove method in there.
	// stream problem needs only add and get median methods.
	
	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

	public double[] medianSlidingWindow(int[] nums, int k) {

		int n = nums.length - k + 1;
		if (n <= 0)
			return new double[0];
		
		
		double[] result = new double[n];

		for (int i = 0; i <= nums.length; i++) {
			
			// copute the median once you find the first window onwards
			if (i >= k) {
				result[i - k] = getMedian();
				remove(nums[i - k]);
			}
			
			// add the number to  heaps
			if (i < nums.length) {
				add(nums[i]);
			}
		}

		return result;

	}

	private void remove(int num) {

		// remove the element first
		if (num < getMedian()) {
			maxHeap.remove(num); // the num to remove exists in left heap
		} else {
			minHeap.remove(num); // the num to remove exists in right heap
		}

		// Lets re-adjust the heaps.
		if (maxHeap.size() > minHeap.size()) {
			Integer temp = maxHeap.poll(); // add an element from left heap to right heap
			minHeap.add(temp);
		}

		if (minHeap.size() - maxHeap.size() > 1) { // this case will occur when right heap has 2 more elements than left
													// heap.
			Integer temp = minHeap.poll();
			maxHeap.add(temp); // add one element from rightheap to leftheap.
		}
	}

	private double getMedian() {

		if (maxHeap.isEmpty() && minHeap.isEmpty())
			return 0;

		if (maxHeap.size() == minHeap.size()) {
			return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2.0;
		} else {
			return (double) minHeap.peek(); // ALWAYS return from right heap
		}
	}

	private void add(int num) {

		// add element to heap
		if (num < getMedian()) {
			maxHeap.add(num);
		} else {
			minHeap.add(num);
		}

		// Lets readjust the heaps now, same logic as remove
		if (maxHeap.size() > minHeap.size()) {
			minHeap.add(maxHeap.poll());
		}
		if (minHeap.size() - maxHeap.size() > 1) {
			maxHeap.add(minHeap.poll());
		}
	}

}
