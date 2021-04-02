package me.learn.personal.month2;


/**
 * Title :
 * 
 * Date : Mar 18, 2021
 * 
 * @author bramanarayan
 *
 */
public class MaxKK {

	public static void main(String args[]) {
		MaxKK solution = new MaxKK();
		System.out.println(solution.maxValueKInArray(new int[] {3,0,6,9,1}));
	}
	
	
	public static int maxValueKInArray(int[] arr) {
		
		int possibleMaxValue = arr.length;
		
		for (int i = 0; i < (arr.length); i++) {
			if (possibleMaxValue > arr[i]) {
				possibleMaxValue--;
			}
		}
		return possibleMaxValue;
	}

}
