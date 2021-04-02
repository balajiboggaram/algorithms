/**
 * 
 */
package me.learn.personal.month7;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Title :
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class ExamRoom {
//IDEA :
	/**
	Idea is to Use a TreeSet to store the current seat index in use. Whenever we want to add a seat, check the max distance adjacent indices in the treeset, whichever is the max that is our answer.
	For edge cases :
	When zero student: return 0;
	When there is one student., return 0 if the student is in second half or return N - 1 if the student is in first half.
	Otherwise, apply the idea,
	*/
	
	TreeSet<Integer> set = new TreeSet<>();
	int N;

	public ExamRoom(int N) {
		this.N = N;
	}

	public int seat() {
		
		// When no student
		if (set.isEmpty()) {
			set.add(0);
			return 0;
		}
		
		// When One student
		if (set.size() == 1) {
			int num = set.first();
			if (num < (N / 2)) { // if the only student is present in first half, the new one will be sitting at last
				set.add(N - 1);
				return N - 1;
			} else {
				set.add(0); // and vice-versa here
				return 0;
			}
		}
		
		// When more than one student
		Iterator<Integer> it = set.iterator();
		int dist = -1;
		int position = -1;
		int left = it.next();
		
		//  Init : check the distance between 0 and first student
		if (left > 0) {
			position = 0;
			dist = left;
		}
		
		int right = -1;
		// Check the distance between adjacent indices,(already sorted cos of tree set)
		while (it.hasNext()) {
			
			// left , right , ....
			right = it.next();
			
			// pick the widest interval
			if ((right - left) / 2 > dist) {
				dist = (right - left) / 2; // place the element in mid of (left.....mid ......right)
				position = left + dist;
			}
			left = right; // keep on moving, the right becomes left now..
		}
		
		// check the distance between last student and (N - 1)
		if ((N - 1) - left > dist) {
			position = N - 1;
		}
		
		set.add(position); // this is the position where the student shall sit.
		
		return position;
	}

	public void leave(int p) {
		set.remove(p);
	}
}