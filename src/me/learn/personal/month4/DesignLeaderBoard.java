/**
 * 
 */
package me.learn.personal.month4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Title 1244 : 
 * 
 * Design a Leaderboard class, which has 3 functions:

    addScore(playerId, score): Update the leaderboard by adding score to the given player's score. If there is no player with such id in the leaderboard, add him to the leaderboard with the given score.
    top(K): Return the score sum of the top K players.
    reset(playerId): Reset the score of the player with the given id to 0 (in other words erase it from the leaderboard). It is guaranteed that the player was added to the leaderboard before calling this function.

Initially, the leaderboard is empty.

 

Example 1:

Input: 
["Leaderboard","addScore","addScore","addScore","addScore","addScore","top","reset","reset","addScore","top"]
[[],[1,73],[2,56],[3,39],[4,51],[5,4],[1],[1],[2],[2,51],[3]]
Output: 
[null,null,null,null,null,null,73,null,null,null,141]

Explanation: 
Leaderboard leaderboard = new Leaderboard ();
leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
leaderboard.top(1);           // returns 73;
leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
leaderboard.top(3);           // returns 141 = 51 + 51 + 39;

 * 
 * @author bramanarayan
 * @date Aug 20, 2020
 */
public class DesignLeaderBoard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Leaderboard solution = new Leaderboard();
		
		solution.addScore(1, 82);
		solution.addScore(2, 84);
		solution.addScore(3,47 );
		solution.addScore(4, 86);
		solution.addScore(5, 92 );
		solution.addScore(6, 74);
		solution.addScore(7, 34);
		solution.addScore(8, 67 );
		solution.addScore(9, 76 );
		solution.addScore(10, 73 );
		solution.top(4);
		
		// 2
		solution.addScore(1, 73);
		solution.addScore(2, 56);
		solution.addScore(3, 39);
		solution.addScore(4, 51);
		solution.addScore(5, 4);
		solution.top(1);
		solution.reset(1);
		solution.reset(2);
		solution.addScore(2, 51);
		solution.top(3);
		
		
		
	}
	//["Leaderboard","addScore","addScore","addScore","addScore","addScore","addScore","addScore","addScore","addScore","addScore","top","top","top","reset","reset"]
		//	[[],[1,82],[2,84],[3,47],[4,86],[5,92],[6,74],[7,34],[8,67],[9,76],[10,73],[4],[4],[8],[1],[2]]

}

class Leaderboard {

	Map<Integer, Integer> playerMap = new HashMap<Integer, Integer>(); // playerId to score
	Map<Integer, Integer> countMap = new TreeMap<>(Collections.reverseOrder()); // score to count i.e number of players who have same score
	
    public Leaderboard() {
        
    }
    
    public void addScore(int playerId, int score) {
    	int prevScore = 0;
    	if(playerMap.get(playerId) == null) {
            playerMap.put(playerId, score);
    		
    	} else {
    		prevScore = playerMap.get(playerId);
    		playerMap.put(playerId, playerMap.get(playerId) + score);
    	}
    	
    	if(prevScore != 0) { 
    		countMap.put(prevScore, countMap.get(prevScore)-1);
    		if(countMap.get(prevScore) == 0)
    			countMap.remove(prevScore);
    	}
    	
    	// the score is here not update in the original problem. You need to CARRY FORWARD THE PREVIOUS SCORE> 
    	// Fix it
        countMap.put(score, countMap.getOrDefault(score, 0) + 1);

    }
    
	public int top(int k) {
		int totalScore = 0;

		int count = 0;

		for (Entry<Integer, Integer> e : countMap.entrySet()) {

			int score = e.getKey();
			int times = e.getValue();

			if (count + times < k) {
				totalScore += (score * times);
				count += times;
			} else {
				for (int i = 0; i < times && count < k; i++, count++) {
					totalScore += score;
				}
			}

			if (count == k)
				break;
		}
		System.out.println(totalScore);
		return totalScore;
	}
    
    public void reset(int playerId) {

    	
    	int score = playerMap.get(playerId);
    	playerMap.remove(playerId);
    	if(countMap.get(score) != null) {
        	countMap.put(score, countMap.get(score)-1);
        	if(countMap.get(score) == 0) 
        		countMap.remove(score);
          		
    	}
  }
}
