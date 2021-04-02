/**
 * 
 */
package me.learn.personal.month6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title : https://www.geeksforgeeks.org/closest-pair-of-points-using-divide-and-conquer-algorithm/
 * 
 * Date : Feb 15, 2021
 * 
 * @author bramanarayan
 *
 */
public class ClosestPairofPointsInPlane {

	public static void main(String[] args) {
		Point P[] = { new Point(2, 3), new Point(12, 30), new Point(40, 50), new Point(5, 1), new Point(12, 10),
				new Point(3, 4) };
		//System.out.println(closest(P));
	}
}

class MinDistanceBetweenPoints {

	public static double closest(Point[] p) {
		Arrays.sort(p, (p1, p2) -> p1.x - p2.x);
		return closestUtil(p, 0, p.length - 1);
	}

	private static double closestUtil(Point[] p, int i, int j) {
		if (j - i + 1 <= 3)
			return bruteForce(p, i, j);
		int n = j - i + 1;
		int mid = i + (j - i) / 2;
		Point midPoint = p[mid];
		double dl = closestUtil(p, i, mid);
		double dr = closestUtil(p, mid + 1, j);
		double d = Math.min(dl, dr);
		List<Point> list = new ArrayList<>();
		for (int k = 0; k < n; k++) {
			if (Math.abs(p[k].x - midPoint.x) < d)
				list.add(p[k]);
		}
		return Math.min(d, stripClosest(list.toArray(new Point[0]), d));
	}

	private static double bruteForce(Point[] p, int start, int end) {
		double min = Double.MAX_VALUE;
		if (p != null && end - start > 0) {
			for (int i = start; i < end - 1; i++) {
				for (int j = i + 1; j < end; j++) {
					min = Math.min(min, dist(p[i], p[j]));
				}
			}
		}
		return min;
	}

	private static double dist(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}

	private static double stripClosest(Point[] strip, double d) {
		double min = d;
		Arrays.sort(strip, (p1, p2) -> p1.y - p2.y);
		for (int i = 0; i < strip.length; i++) {
			for (int j = i + 1; j < strip.length && (strip[j].y - strip[i].y) < min; j++) {
				double distance = dist(strip[i], strip[j]);
				if (distance < min)
					min = distance;
			}
		}
		return min;
	}

}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}
