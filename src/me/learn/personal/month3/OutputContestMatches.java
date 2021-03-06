package me.learn.personal.month3;

/**
 * 
 * Title 544 :
 * 
 * During the NBA playoffs, we always arrange the rather strong team to play
 * with the rather weak team, like make the rank 1 team play with the rank nth
 * team, which is a good strategy to make the contest more interesting. Now,
 * you're given n teams, you need to output their final contest matches in the
 * form of a string.
 * 
 * The n teams are given in the form of positive integers from 1 to n, which
 * represents their initial rank. (Rank 1 is the strongest team and Rank n is
 * the weakest team.) We'll use parentheses('(', ')') and commas(',') to
 * represent the contest team pairing - parentheses('(' , ')') for pairing and
 * commas(',') for partition. During the pairing process in each round, you
 * always need to follow the strategy of making the rather strong one pair with
 * the rather weak one.
 * 
 * Example 1:
 * 
 * Input: 2 Output: (1,2) Explanation: Initially, we have the team 1 and the
 * team 2, placed like: 1,2. Then we pair the team (1,2) together with '(', ')'
 * and ',', which is the final answer.
 * 
 * 
 * 
 * @author bramanarayan
 * @date Jun 25, 2020
 */
public class OutputContestMatches {

	public static void main(String args[]) {
		OutputContestMatches solution = new OutputContestMatches();
		System.out.println(solution.findContestMatch(8));
	}

	
	// RECURSION - start with 8, keep collapsing by half every round. So
	// atlast the answer will be at 0th index
	public String findContestMatch(int n) {
		
		// Compute the pre numbers
		String[] pre = new String[n];
		for(int i = 0;i<n;i++) {
			pre[i] = String.valueOf(i+1);
		}
		
		while(n > 0) {
			for(int i = 0; i< n/2;i++) {
				pre[i] = String.format("(%s,%s)", pre[i], pre[n-1-i]);
			}
			n = n/2;
		}
		
		return pre[0];
		
	}

}
