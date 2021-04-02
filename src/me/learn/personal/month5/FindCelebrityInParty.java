/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 277 :
 * 
 * Date : Jan 4, 2021
 * 
 * @author bramanarayan
 *
 */
public class FindCelebrityInParty {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// claim one of them as celebrity
	// now, keep checking for the rest
	public int findCelebrity(int n) {

		int candidate = 0;
		for (int i = 0; i < n; i++) {
			if (knows(candidate, i)) {
				candidate = i;
			}
		}

		// after you claim the candidate, check if indeed he is a celebirty.
		// the reason is - in the problem - there might or might not exist a celebrity.
		// hence...
		for (int j = 0; j < n; j++) {
			if(candidate == j) continue; // no sense to compare the candidate itself
			if(knows(candidate,j) || !knows(j,candidate)) return -1; // violating conditions
		}
		
		return candidate;

	}

	// MOCk method
	private boolean knows(int candidate, int i) {
		return false;
	}

}
