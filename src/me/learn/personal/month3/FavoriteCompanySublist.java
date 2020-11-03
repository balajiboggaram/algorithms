/**
 * 
 */
package me.learn.personal.month3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Title 1452 :
 * 
 * Given the array favoriteCompanies where favoriteCompanies[i] is the list of
 * favorites companies for the ith person (indexed from 0).
 * 
 * Return the indices of people whose list of favorite companies is not a subset
 * of any other list of favorites companies. You must return the indices in
 * increasing order.
 * 
 * Example 1:
 * 
 * Input: favoriteCompanies =
 * [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
 * Output: [0,1,4] Explanation: Person with index=2 has
 * favoriteCompanies[2]=["google","facebook"] which is a subset of
 * favoriteCompanies[0]=["leetcode","google","facebook"] corresponding to the
 * person with index 0. Person with index=3 has favoriteCompanies[3]=["google"]
 * which is a subset of favoriteCompanies[0]=["leetcode","google","facebook"]
 * and favoriteCompanies[1]=["google","microsoft"]. Other lists of favorite
 * companies are not a subset of another list, therefore, the answer is [0,1,4].
 * 
 * 
 * @author bramanarayan
 * @date Jul 15, 2020
 */
public class FavoriteCompanySublist {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	// tip : set1.containsAll(set2)
	public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {

		List<Set<String>> input = new ArrayList<Set<String>>();
		int n = favoriteCompanies.size();

		// convert the inner list to set
		for (List<String> comp : favoriteCompanies) {
			Set<String> set = new HashSet<String>(comp);
			input.add(set);
		}

		List<Integer> result = new ArrayList<Integer>();
		// BRUTE FORCE
		for (int i = 0; i < n; i++) {
			boolean isSubset = false;
			for (int j =0; j < n; j++) {
				
				Set<String> set1 = input.get(i);
				Set<String> set2 = input.get(j);

				if (i != j && set1.size() > set2.size() && set1.containsAll(set2)) {
					isSubset = true;
					break;
				}
				
			}
			if(!isSubset)
				result.add(i);
		}
		return result;
	}

}
