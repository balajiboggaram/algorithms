/**
 * 
 */
package me.learn.personal.month5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Title 646 : 
 * 
 * Date : Dec 21, 2020
 * 
 * @author bramanarayan
 *
 */
public class MaxLengthOfChainPairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
    public int findLongestChain(int[][] pairs) {
        
    	
    	Arrays.sort(pairs, (a,b) -> Integer.compare(a[0], b[0])); // sort based on start
    	
    	
    	int n = pairs.length;
    	
    	int[] dp = new int[n];
    	Arrays.fill(dp, 1);

    	int result =0;
    	
    	for(int i = 0;i < n;i++) {
    		for(int j = 0;j<i;j++) {
    			int[] iPair = pairs[i];
    			int[] jPair = pairs[j];
    			if(iPair[0] > jPair[1]) {
    				dp[i] = Math.max(dp[i], dp[j]+1);
    				result = Math.max(result, dp[i]);
    			}
    		}
    	}
    	
    	return dp[n-1];
    	
    	
    }
    
    
	
}

class Tuple1 implements Comparable<Tuple1>{
	int start;
	int end;
	@Override
	public int compareTo(Tuple1 o) {
		// TODO Auto-generated method stub
		return this.start = o.start;
	}
}
