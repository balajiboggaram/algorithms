/**
 * 
 */
package me.learn.personal.month7;

import java.util.TreeSet;

/**
 * Title 1385 : not a good problem
 * 
 * Date : Feb 25, 2021
 * 
 * @author bramanarayan
 *
 */
public class FindDistanceValueBetweenTwoArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;
        TreeSet<Integer> ts = new TreeSet<>();
        for(int n : arr2)
            ts.add(n);
        
        for(int n : arr1){
            Integer higher = ts.ceiling(n);
            Integer lower = ts.floor(n);
            int diff = 0;
            if(higher == null){
                diff = Math.abs(lower - n);
            }else if(lower == null){
                diff = Math.abs(higher - n);
            }else{
                diff = Math.min(higher - n, n - lower);
            }
            if(diff > d)
                res++;
        }
        return res;
    }
}
