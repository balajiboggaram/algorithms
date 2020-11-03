/**
 * 
 */
package me.learn.personal.month3;

import java.util.List;

/**
 * Title 1268 :
 * 
 * Given an array of strings products and a string searchWord. We want to design
 * a system that suggests at most three product names from products after each
 * character of searchWord is typed. Suggested products should have common
 * prefix with the searchWord. If there are more than three products with a
 * common prefix return the three lexicographically minimums products.
 * 
 * Return list of lists of the suggested products after each character of
 * searchWord is typed.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"],
 * searchWord = "mouse"
 * 
 *  Output: [ ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"], 
 * ["mouse","mousepad"], 
 * ["mouse","mousepad"],
 * ["mouse","mousepad"] ] 
 * 
 * Explanation: products sorted lexicographically =
 * ["mobile","moneypot","monitor","mouse","mousepad"] After typing m and mo all
 * products match and we show user ["mobile","moneypot","monitor"] After typing
 * mou, mous and mouse the system suggests ["mouse","mousepad"]
 * 
 * 
 * @author bramanarayan
 * @date Jun 25, 2020
 */
public class SearchSuggestionSystem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<String>> suggestedProducts(String[] products, String searchWord) {

	}

}
