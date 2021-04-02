/**
 * 
 */
package me.learn.personal.month7;

/**
 * Title 740 : 
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class DeleteAndEarnPlusMinus {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DeleteAndEarnPlusMinus solution = new DeleteAndEarnPlusMinus();
		System.out.println(solution.deleteAndEarn(new int[] {3,4,2}));
	}
	
	// max number of points you earn
	 public int deleteAndEarn(int[] nums) {
		 
		 	int n = 100;// this should the max of nums. i.e max possible number in range of nums.
	        final int[] dp = new int[n]; 
	        
	        // for the given input numbers, add it
	        for (int num : nums) {
	            dp[num] += num; // you are adding here cos of duplicates in input 2,2,3,4,4,8
	        }
	        
	        int take = 0, skip = 0;
	        for (int i = 0; i < n; i++) {
	        	
	            int takei = skip + dp[i]; // at i step, max obtained is skip + dp[i]
	            int skipi = Math.max(skip, take); // if I skip i, skip, take
	            
	            take = takei;
	            skip = skipi;
	        }
	        return Math.max(take, skip);
	    }

}
