/**
 * 
 */
package me.learn.personal.month4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title 346 :
 * 
 *  Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3

 * 
 * @author bramanarayan
 * @date Jul 29, 2020
 */
public class MovingAverageFromDataStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}

class MovingAverage {
	
	double sum = 0;
	Queue<Integer> q = new LinkedList<Integer>();
    int size;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        q.add(val);
        
        int removed = 0;
        if(q.size() > size) 
        	removed = q.remove();
        
        sum = sum + val - removed;
        return (double) sum/q.size();
    }
}