package me.learn.personal.month1;

import me.learn.utli.Utils;

/**
 * 
 * Title : Find all the permutation of a string
 * 
 * @author bramanarayan
 * @date May 13, 2020
 */
public class PermutationString {
	
	public static void main(String args[]) {
		PermutationString solution = new PermutationString();
		solution.permute("ABC".toCharArray(), 0, 3);
	}
	
	public void permute(char[] input, int i , int n) {
		if(i ==n) {
			System.out.println(input);
		} else {
			for(int j = i; j < n;j++) {
				Utils.swap(input, i, j);
				permute(input, i+1, n);
				Utils.swap(input, i, j);
			}
		}
		
	}

}
