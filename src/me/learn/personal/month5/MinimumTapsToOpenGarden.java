/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title :
 * 
 * Date : Dec 23, 2020
 * 
 * @author bramanarayan
 *
 */
public class MinimumTapsToOpenGarden {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Minimum number of taps to open such that you can water the full garden. i tap
	// can water i + a[i] and i - a[i]
	public int minTaps(int n, int[] ranges) {

		// Transform the array to integers, basically as jump game input
		int[] a = new int[n+1];
		for (int i = 0; i < ranges.length; i++) {
			if(ranges[i] == 0) continue;
			int left = Math.max(0, i - ranges[i]);
			int right = Math.min(n, i+ranges[i]);
			a[left] = Math.max(a[left], right);
		}
		
		// After transformation its basically jump game 2
		int cur=0, next=0, step=0;
        for(int i=0;i<=cur;++i){
            next=Math.max(next, a[i]);
            if(i==cur){
                cur=next;
                step++;
                if(cur>=n) return step;
            }
        }
        return -1;
	}
	

	// minimum number of jumps to reach end of array
	public int jump(int[] a) {
		int steps = a[0];
		int count = 1;
		int n = a.length;
		int maxReach = a[0];

		if (n == 1)
			return 0;
		for (int i = 1; i < n; i++) {
			if (i > maxReach)
				return -1;
			if (i == n - 1)
				return count;

			steps--;
			if (maxReach < i + a[i]) {
				maxReach = i + a[i];
			}

			if (steps == 0) {
				count++;
				steps = maxReach - i;
			}

		}

		return count;
	}

}
