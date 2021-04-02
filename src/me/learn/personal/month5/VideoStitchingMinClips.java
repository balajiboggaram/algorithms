/**
 * 
 */
package me.learn.personal.month5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Title 1024 : 
 * 
 * Date : Dec 23, 2020
 * 
 * @author bramanarayan
 *
 */
public class VideoStitchingMinClips {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });    
        int count = 0;
        int end = 0;
        int n = clips.length;
        if(n ==1) return 0;
        
        for(int i = 0; i < n; ) {
            if(clips[i][0] > end) {
                return -1;
            }
            int newend = end;
            // keep sucking all of them which start falls in my range (i.e end)
            while(i < n && clips[i][0] <= end) { // while one clip's start is before or equal to current end
                newend = Math.max(newend, clips[i][1]); // find out the one with the max possible end
                i++;
            }
            count++;
            end = newend;
            if(end >= T) {
                return count;    
            }
        }
        return -1;        
    }
	

}
