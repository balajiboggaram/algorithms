/**
 * 
 */
package me.learn.personal.month7;

import java.util.ArrayList;
import java.util.List;

/**
 * Title :
 * 
 * Date : Feb 25, 2021
 * 
 * @author bramanarayan
 *
 */
public class PackCakeSorting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * 
	 * Find the current max within [0, curEndIndex]. 
	 * Do a flip (from 0 to
	 * curMaxIndex) to put it to the front.
	 *  Flip again to put it to endIndex.
	 * endIndex--.
	 * 
	 * 
	 */
	public List<Integer> pancakeSort(int[] A) {
        List<Integer> list = new ArrayList<>();
        for(int end = A.length - 1; end >= 0; end--){
            int largest = findLargest(A, end);
            if(largest == end) continue;
            swap(A, 0, largest);
            swap(A, 0, end);
            list.add(largest + 1);
            list.add(end + 1);
        }
        return list;
    }
    private int findLargest(int[]A, int lastIdx){
        int max = Integer.MIN_VALUE, index = 0;
        for(int i = 0; i <= lastIdx; i++){
            if(A[i] > max){
                max = A[i];
                index = i;
            }
        }
        return index;
    }
    private void swap(int[]A, int start, int end){
        while(start < end){
            int tmp = A[start];
            A[start++] = A[end];
            A[end--] = tmp;
        }
    }

}
