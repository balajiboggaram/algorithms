/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Title 997 :
 * 
 * Date : Jan 4, 2021
 * 
 * @author bramanarayan
 *
 */
public class FindTownJudge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FindTownJudge solution = new FindTownJudge();
		System.out.println(solution.findJudge(2, new int[][] { { 1, 2 } }));
	}

	/**
	 * In a town, there are N people labelled from 1 to N. There is a rumor that one
	 * of these people is secretly the town judge.
	 * 
	 * If the town judge exists, then:
	 * 
	 * The town judge trusts nobody. Everybody (except for the town judge) trusts
	 * the town judge. There is exactly one person that satisfies properties 1 and
	 * 2.
	 * 
	 * You are given trust, an array of pairs trust[i] = [a, b] representing that
	 * the person labelled a trusts the person labelled b.
	 * 
	 * If the town judge exists and can be identified, return the label of the town
	 * judge. Otherwise, return -1.
	 */

	// everybody trusts judge but he nevers trusts anyone, he is called as judge.
	public int findJudge(int N, int[][] trust) {

		if (trust.length < N - 1) {
			return -1;
		}

		int[] indegrees = new int[N + 1];
		int[] outdegrees = new int[N + 1];

		for (int[] relation : trust) {
			outdegrees[relation[0]]++; 
			indegrees[relation[1]]++;
		}

		for (int i = 1; i <= N; i++) {
			if (indegrees[i] == N - 1 && outdegrees[i] == 0) {
				return i;
			}
		}
		return -1;
	}

}
