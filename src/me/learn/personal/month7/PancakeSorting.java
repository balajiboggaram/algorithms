/**
 * 
 */
package me.learn.personal.month7;
import java.util.*;

/**
 * Title 969 : 
 * 
 * Date : Feb 27, 2021
 * 
 * @author bramanarayan
 *
 */
public class PancakeSorting {
	
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

    
    
    
    // or 
    

    /* Reverses arr[0..i] */
    static void flip(int arr[], int i)
    {
        int temp, start = 0;
        while (start < i)
        {
            temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            start++;
            i--;
        }
    }
 
    // Returns index of the 
    // maximum element in 
    // arr[0..n-1] 
    static int findMax(int arr[], int n)
    {
        int mi, i;
        for (mi = 0, i = 0; i < n; ++i)
            if (arr[i] > arr[mi])
                mi = i;
        return mi;
    }
 
    // The main function that
    // sorts given array using 
    // flip operations
    static int pancakeSort(int arr[], int n)
    {
        // Start from the complete
        // array and one by one
        // reduce current size by one
        for (int curr_size = n; curr_size > 1; 
                                 --curr_size)
        {
            // Find index of the
            // maximum element in
            // arr[0..curr_size-1]
            int mi = findMax(arr, curr_size);
 
            // Move the maximum element
            // to end of current array
            // if it's not already at 
            // the end
            if (mi != curr_size-1)
            {
                // To move at the end,
                // first move maximum
                // number to beginning
                flip(arr, mi);
 
                // Now move the maximum 
                // number to end by
                // reversing current array
                flip(arr, curr_size-1);
            }
        }
        return 0;
    }
    
}
