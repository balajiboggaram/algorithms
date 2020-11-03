package me.learn.utli;

public class Utils {

	/**
	 * Swap given two integer primitives
	 */
	public static void swap(int i, int j) {
		int t = i;
		i = j;
		j = t;
	}

	/**
	 * Swap elements in an array at position1 with position2
	 */
	public static void swap(int[] a, int pos1, int pos2) {
		int t = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] = t;
	}

	/**
	 * Swap elements in a char array at position1 with position2
	 */
	public static void swap(char[] a, int pos1, int pos2) {
		char t = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] = t;
	}
}
