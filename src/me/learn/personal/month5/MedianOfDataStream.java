/**
 * 
 */
package me.learn.personal.month5;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Title 295 :
 * 
 * Date : Dec 23, 2020
 * 
 * @author bramanarayan
 *
 */
public class MedianOfDataStream {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

class MedianFinder {

	PriorityQueue<Double> maxHeap = new PriorityQueue<Double>(Collections.reverseOrder());
	PriorityQueue<Double> minHeap = new PriorityQueue<Double>();

	double median;

	/** initialize your data structure here. */
	public MedianFinder() {

	}

	public void addNum(int num) {

		int m = maxHeap.size();
		int n = minHeap.size();

		double x = (double) num;

		// both heaps of equal size
		if (m == n) {
			if (num < median) {
				maxHeap.offer(x);
				median = maxHeap.peek();
			} else {
				minHeap.offer(x);
				median = minHeap.isEmpty() ? 0 : minHeap.peek();
			}
			
			
		} else if (m > n) { // left heap has more elements
			// left is more and also num needs a place in left heap, so we need to pop to
			// make place for it
			if (num < median) {
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(x);
			} else {
				minHeap.offer(x);
			}
			median = ((minHeap.isEmpty() ? 0 : minHeap.peek()) + (maxHeap.isEmpty() ? 0 : maxHeap.peek())) / 2.0;
			
			
			
		} else { // here right has more elements
			if (num > median) {
				maxHeap.offer(minHeap.poll());
				minHeap.offer(x);
			} else {
				maxHeap.offer(x);
			}
			median = ((minHeap.isEmpty() ? 0 : minHeap.peek()) + (maxHeap.isEmpty() ? 0 : maxHeap.peek())) / 2.0;
		}
	}

	public double findMedian() {
		return median;
	}
}