/**
 * 
 */
package me.learn.personal.month4;

import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Title 362 :
 * 
 *  Design a hit counter which counts the number of hits received in the past 5 minutes.

Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.

It is possible that several hits arrive roughly at the same time.

Example:

HitCounter counter = new HitCounter();

// hit at timestamp 1.
counter.hit(1);

// hit at timestamp 2.
counter.hit(2);

// hit at timestamp 3.
counter.hit(3);

// get hits at timestamp 4, should return 3.
counter.getHits(4);

// hit at timestamp 300.
counter.hit(300);

// get hits at timestamp 300, should return 4.
counter.getHits(300);

// get hits at timestamp 301, should return 3.
counter.getHits(301); 

 * 
 * @author bramanarayan
 * @date Aug 20, 2020
 */
public class DesignHitCounter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HitCounter counter = new HitCounter();

	/*	// hit at timestamp 1.
		counter.hit(1);

		// hit at timestamp 2.
		counter.hit(2);

		// hit at timestamp 3.
		counter.hit(3);

		// get hits at timestamp 4, should return 3.
		counter.getHits(4);

		// hit at timestamp 300.
		counter.hit(300);

		// get hits at timestamp 300, should return 4.
		counter.getHits(300);

		// get hits at timestamp 301, should return 3.
		counter.getHits(301); 	
		*/
		
		counter.hit(2);
		counter.hit(3);
		counter.hit(4);
		counter.getHits(300);
		counter.getHits(301);
		counter.getHits(302);
		counter.getHits(303);
		counter.getHits(304);
		counter.getHits(600);

	
	}

}


class HitCounter {
	
	TreeMap<Integer,Integer> tmap;

	int count = 0;
	int end = 0;

    /** Initialize your data structure here. */
    public HitCounter() {
        tmap = new TreeMap<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
    	
        tmap.put(timestamp, tmap.getOrDefault(timestamp,0) +1 );
        count++;
        end = timestamp;
        
    	
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
    	
    	if(tmap.size() == 0) return 0;
    	
    	//shrink from beginning of map. ideally list is really good for this type of operation.
        if( timestamp - tmap.firstKey() >= 300) {
        	while(!tmap.isEmpty() && timestamp - tmap.firstKey() >= 300) {
        		count = count - tmap.firstEntry().getValue();        		
        		tmap.remove(tmap.firstKey());
        	}
        }
        System.out.println(count);
        return count;
    }
}