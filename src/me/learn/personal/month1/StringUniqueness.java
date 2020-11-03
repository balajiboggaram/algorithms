package me.learn.personal.month1;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Title : Verify if all the characters in a given string are unique or not
 * 
 * @author bramanarayan
 * @date Apr 21, 2020
 */
public class StringUniqueness {
	
	public static void main(String args[]) {
		
		System.out.println(" Malayalam uniqueness is : " + isUnique("malayalam"));
		System.out.println(" english uniqueness is : " + isUnique("english"));
		System.out.println(" India uniqueness is : " + isUnique("India"));
		System.out.println(" America uniqueness is : " + isUnique("america"));
		System.out.println(" EmptyString uniqueness is : " + isUnique(""));
	}
	
	/**
	 * Using additional data structure - hashset.
	 * 
	 * The space complexity is O(1) constant space.
	 */
	public static boolean isUnique(String str) {
		
		if(str == null) return true;
		
		if(str.isEmpty()) return true;
		
		Set<Character> s = new HashSet<Character>();
		for( char c : str.toCharArray()) {
			if(s.contains(c)) return false;
			s.add(c);
		}
		return true;
	}
	
	/**
	 * More effective due to constant space via an 'int'
	 */
		
}
