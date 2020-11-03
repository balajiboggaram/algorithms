/**
 * 
 */
package me.learn.personal.month4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Title : 
 * 
 * @author bramanarayan
 * @date Jul 30, 2020
 */
public class ShortestSubArraySumAtleastK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ShortestSubArraySumAtleastK solution = new ShortestSubArraySumAtleastK();
		System.out.println(solution.shortestSubarray(new int[] { 2, -1, 2, 3 }, 5));
	}

	
	
	
	// take example : 1,2,2,3,6
	// psum : 1, 3, 5, 8, 14
	// HEAD MAP - Key 
	public int shortestSubarray(int[] A, int K) {
        int ans = Integer.MAX_VALUE;
        
        TreeMap<Integer,Integer> sumToIdx = new TreeMap<>();
        int sum =0;
        
        int i=-1; // nothing but y  x ------> y >= k
        while(i<A.length){
            
        	sum += ( i == -1) ? 0: A[i];
            //sum+=i==-1?0: A[i];
            
            int presum = sum-K; // indicates is there any presum with less than or equal to this value;
            
            // Give me all the entries which are less than or equal to presum
            Map<Integer,Integer> headMap = sumToIdx.headMap(presum, true);
            
            List<Integer> todelete = new ArrayList<>();
            
            // if there is any entry in the headMap, then you have a valid y and x. but now its your turn to pick the min difference 
            // between x and y.
            for(Map.Entry<Integer,Integer> entry: headMap.entrySet()){
                int idx = entry.getValue(); // value of x here
                ans = Math.min(ans, i-idx); // difference between x and y
                todelete.add(entry.getKey()); // this is already computed, so no use - delete from map
            }
            
            for(int key:todelete){
                sumToIdx.remove(key);
            }
            
            // you put every prefix sum and its index to map.
            sumToIdx.put(sum, i);
            i++;
        }
        return ans==Integer.MAX_VALUE?-1: ans;
    }

}
