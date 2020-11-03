package me.learn.personal.month1;

import java.util.Arrays;

public class HeapSort {

	int heapSize;
	int[] a;

	public static void main(String args[]) {
		HeapSort solution = new HeapSort(new int[] { 4, 10, 3, 5, 1 });
		solution.heapSort();
		System.out.println(Arrays.toString(solution.a));
	}

	public HeapSort(int[] array) {
		this.a = array;
		this.heapSize = a.length-1;
	}

	/**
	 * Fix the location of element at position 'i'
	 */
	public void heapify(int i) {

		int left = (2 * i) + 1;
		int right = (2 * i) + 2;
		int largest = i;
		if (left <= heapSize && a[left] > a[i]) {
			largest = left;
		}

		if (right <= heapSize && a[right] > a[largest]) {
			largest = right;
		}

		if (largest <= heapSize && largest != i) {
			swap(i, largest);
			heapify(largest);
		}
	}

	/**
	 * Starts from n/2 to 0 position. This ensures each element from n/2 to 0 positino is set at right location.
	 */
	public void buildHeap() {
		for (int i = a.length / 2; i >= 0; i--) {
			heapify(i);
		}
	}

	public void heapSort() {
		buildHeap();
		for (int i = heapSize; i > 0; i--) {
			swap(0, i);
			heapSize--;
			heapify(0);
		}
	}

	private void swap(int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

}
