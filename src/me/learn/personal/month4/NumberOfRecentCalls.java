/**
 * 
 */
package me.learn.personal.month4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title 933 : Write a class RecentCounter to count recent requests.
 * 
 * It has only one method: ping(int t), where t represents some time in
 * milliseconds.
 * 
 * Return the number of pings that have been made from 3000 milliseconds ago
 * until now.
 * 
 * Any ping with time in [t - 3000, t] will count, including the current ping.
 * 
 * It is guaranteed that every call to ping uses a strictly larger value of t
 * than before.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: inputs = ["RecentCounter","ping","ping","ping","ping"], inputs =
 * [[],[1],[100],[3001],[3002]] Output: [null,1,2,3,3]
 * 
 * 
 * @author bramanarayan
 * @date Jul 29, 2020
 */
public class NumberOfRecentCalls {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class RecentCounter {

	Queue<Integer> q = new LinkedList<Integer>();
	
    public RecentCounter() {
        
    }
    
    public int ping(int t) {
        
    	q.offer(t);
    	
    	// remove all the elements greater than 3000 window past
    	while(!q.isEmpty() && t - q.peek() > 3000) {
    		q.remove();
    	}
    	
    	return q.size();
    	
    }
}
