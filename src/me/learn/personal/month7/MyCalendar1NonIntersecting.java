/**
 * 
 */
package me.learn.personal.month7;

import java.util.TreeMap;

/**
 * Title 729 :
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class MyCalendar1NonIntersecting {

}

class MyCalendar {
	// ENTRY : start -> end
	TreeMap<Integer, Integer> map;

	public MyCalendar() {
		map = new TreeMap<>();
	}

	public boolean book(int start, int end) {
		
		// Try to retrieve the lowest of end
		Integer low = map.lowerKey(end);

		// case 1 :  if I do not have any interval lesser than end or 
		// case 2 : if I have an interval which do not collide with this my new meeting, then we are good.
		if (low == null || map.get(low) <= start) {
			map.put(start, end);
			return true;
		}
		return false;
	}
}
