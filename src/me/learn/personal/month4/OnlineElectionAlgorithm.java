/**
 * 
 */
package me.learn.personal.month4;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Title 911 : 
 * 
 * In an election, the i-th vote was cast for persons[i] at time times[i].

Now, we would like to implement the following query function: TopVotedCandidate.q(int t) will return the number of the person that was leading the election at time t.  

Votes cast at time t will count towards our query.  In the case of a tie, the most recent vote (among tied candidates) wins.

 

Example 1:

Input: ["TopVotedCandidate","q","q","q","q","q","q"], [[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]]
Output: [null,0,1,1,0,0,1]
Explanation: 
At time 3, the votes are [0], and 0 is leading.
At time 12, the votes are [0,1,1], and 1 is leading.
At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
This continues for 3 more queries at time 15, 24, and 8.

 * 
 * @author bramanarayan
 * @date Aug 3, 2020
 */
public class OnlineElectionAlgorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}

class TopVotedCandidate {

	Map<Integer, Integer> m = new HashMap<>();
	TreeMap<Integer, Integer> tm = new TreeMap<>();
	int leader = -1;
	int lCount = 0;

	public TopVotedCandidate(int[] persons, int[] times) {

		for (int i = 0; i < persons.length; i++) {
			m.put(persons[i], m.getOrDefault(persons[i], 0) + 1);
			// below = is for most recent
			if (lCount <= m.get(persons[i])) {
				lCount = m.get(persons[i]);
				leader = persons[i];
			}
			tm.put(times[i], leader);
		}
	}

	public int q(int t) {
		return tm.floorEntry(t).getValue();
	}
}
