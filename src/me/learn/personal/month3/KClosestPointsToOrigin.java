/**
 * 
 */
package me.learn.personal.month3;

import java.util.PriorityQueue;

/**
 * Title 973 :
 * 
 * We have a list of points on the plane. Find the K closest points to the
 * origin (0, 0).
 * 
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * 
 * You may return the answer in any order. The answer is guaranteed to be unique
 * (except for the order that it is in.)
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: points = [[1,3],[-2,2]], K = 1 Output: [[-2,2]] Explanation: The
 * distance between (1, 3) and the origin is sqrt(10). The distance between (-2,
 * 2) and the origin is sqrt(8). Since sqrt(8) < sqrt(10), (-2, 2) is closer to
 * the origin. We only want the closest K = 1 points from the origin, so the
 * answer is just [[-2,2]].
 * 
 * 
 * @author bramanarayan
 * @date Jul 19, 2020
 */
public class KClosestPointsToOrigin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

			KClosestPointsToOrigin solution = new KClosestPointsToOrigin();
			System.out.println(solution.kClosest(new int[][] {{1,3},{-2,2}}, 1));
	}

	// MIN HEAP + kk
	public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<CKEntryPoint> pq = new PriorityQueue<>();
		for (int i = 0; i < points.length; i++) {
			int distanceFromOrigin = compute(0, 0, points[i][0], points[i][1]); // x1, y1, x2, y2
			pq.add(new CKEntryPoint(points[i][0], points[i][1], distanceFromOrigin));
			if(pq.size() > k)
				pq.remove();
		}
		
		int[][] result = new int[k][2];
		for(int i = k-1;i>=0;i--) {
			CKEntryPoint p = pq.poll();
			result[i][0] = p.x;
			result[i][1] = p.y;
		}
		return result;
	}

	private int compute(int x1, int y1, int x2, int y2) {
		
		int dist = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1); // vomiting square and square root as their progression is linear/exponential.
										// doesnt help for comparision
		System.out.println(dist);
		return dist;
	}

}

// MAX heap
class CKEntryPoint implements Comparable<CKEntryPoint> {

	int x;
	int y;
	int distance;

	public CKEntryPoint(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}

	@Override
	public int compareTo(CKEntryPoint o) {
		return o.distance - this.distance;
	}

}