/**
 * 
 */
package me.learn.personal.month2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Title 187 :
 * 
 *  Repeated DNA sequence
 * 
 * @author bramanarayan
 * @date Aug 19, 2020
 */
public class RepeatedDNASequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Lame version of rolling window. 
	// please use rabin karp - I am lazy to implement it.
	public List<String> findRepeatedDnaSequences(String s) {
		int n = s.length();
		
		Set<String> set = new HashSet<>();
		Set<String> result = new HashSet<>();
		for(int i = 0;i< n -9;i++) {
			String temp = s.substring(i,i+10);
			if(set.contains(temp)) {
				result.add(temp);
			} else {
				set.add(temp);
			}
		}
		return new ArrayList<String>(result);
		
		
		
	}

}
