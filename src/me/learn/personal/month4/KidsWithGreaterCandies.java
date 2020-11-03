/**
 * 
 */
package me.learn.personal.month4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title 1431 :
 * 
 * Given the array candies and the integer extraCandies, where candies[i]
 * represents the number of candies that the ith kid has.
 * 
 * For each kid check if there is a way to distribute extraCandies among the
 * kids such that he or she can have the greatest number of candies among them.
 * Notice that multiple kids can have the greatest number of candies.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: candies = [2,3,5,1,3], extraCandies = 3 Output:
 * [true,true,true,false,true] Explanation: Kid 1 has 2 candies and if he or she
 * receives all extra candies (3) will have 5 candies --- the greatest number of
 * candies among the kids. Kid 2 has 3 candies and if he or she receives at
 * least 2 extra candies will have the greatest number of candies among the
 * kids. Kid 3 has 5 candies and this is already the greatest number of candies
 * among the kids. Kid 4 has 1 candy and even if he or she receives all extra
 * candies will only have 4 candies. Kid 5 has 3 candies and if he or she
 * receives at least 2 extra candies will have the greatest number of candies
 * among the kids.
 * 
 * Example 2:
 * 
 * Input: candies = [4,2,1,1,2], extraCandies = 1 Output:
 * [true,false,false,false,false] Explanation: There is only 1 extra candy,
 * therefore only kid 1 will have the greatest number of candies among the kids
 * regardless of who takes the extra candy.
 * 
 * 
 * @author bramanarayan
 * @date Jul 24, 2020
 */
public class KidsWithGreaterCandies {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KidsWithGreaterCandies solution = new KidsWithGreaterCandies();
		System.out.println(solution.kidsWithCandies(new int[] {2,3,5,1,3}, 3));
		
	}

	// FIND THE GREATEST
	// ITERATE AND SEE IF ADDING EXTRA GIVES MAX CANDY
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

		int max = Integer.MIN_VALUE;
		int n = candies.length;
		for (int i = 0; i < n; i++) {
			max = Math.max(candies[i], max);
		}

		// check if you add that extra becomes greater.
		List<Boolean> result = new ArrayList<Boolean>();
		for (int i = 0; i < n; i++) {
			if(candies[i] + extraCandies >= max) {
				result.add(true);
			} else {
				result.add(false);
			}
		}
		return result;
	}

}
