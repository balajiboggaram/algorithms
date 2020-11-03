/**
 * 
 */
package me.learn.personal.month2;

/**
 * Title 1184 :
 * 
 * A bus has n stops numbered from 0 to n - 1 that form a circle. We know the
 * distance between all pairs of neighboring stops where distance[i] is the
 * distance between the stops number i and (i + 1) % n.
 * 
 * The bus goes along both directions i.e. clockwise and counterclockwise.
 * 
 * Return the shortest distance between the given start and destination stops.
 * 
 * Example 1:
 * 
 * Input: distance = [1,2,3,4], start = 0, destination = 1 Output: 1
 * Explanation: Distance between 0 and 1 is 1 or 9, minimum is 1.
 * 
 * @author bramanarayan
 * @date Jun 8, 2020
 */
public class DistanceBetweenBusStops {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DistanceBetweenBusStops solution = new DistanceBetweenBusStops();
		System.out.println(solution.distanceBetweenBusStops(new int[] { 1, 2, 3, 4 }, 0, 1));
		System.out.println(solution.distanceBetweenBusStops(new int[] { 1, 2, 3, 4 }, 0, 2));
		System.out.println(solution.distanceBetweenBusStops(new int[] { 1, 2, 3, 4 }, 0, 3));
		System.out.println(solution.distanceBetweenBusStops(new int[] { 3, 6, 7, 2, 9, 10, 7, 16, 11 }, 6, 2));

	}

	// Awesome thought process :) same but nice way to present
	public int distanceBetweenBusStops(int[] distance, int src, int dst) {
		// source to destination -> clockwise
		// destination to source -> clock wise 
		return Math.min(getDist(distance, src, dst), getDist(distance, dst, src));
	}

	private int getDist(int[] distance, int src, int dst) {
		int d = 0, n = distance.length;
		for (int i = src; i != dst; i = (i + 1) % n) {
			d += distance[i];
		}
		return d;
	}

	public int distanceBetweenBusStopsMy(int[] distance, int start, int destination) {

		int forwardDistance = 0;
		for (int i = start; i != destination; i = (i + 1) % distance.length) {
			forwardDistance += distance[i];
		}

		int backwardDistance = 0;
		int i = start;
		while (i != destination) {
			i = i == 0 ? distance.length - 1 : i - 1;
			backwardDistance += distance[i];
		}
		System.out.println(forwardDistance + " --> " + backwardDistance);
		return Math.min(forwardDistance, backwardDistance);
	}

}
