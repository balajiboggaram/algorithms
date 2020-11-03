/**
 * 
 */
package me.learn.personal.month4;

/**
 * Title 42 :
 * 
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * @author bramanarayan
 * @date Jul 26, 2020
 */
public class TrappingRainWater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	
	// My approach: 
	// compute leftMax array 
	// compute rightMax array
	// then try : min(l[i],r[i]) - a[i], compute max of this equation.
	// above TC : o(n), sc : o(n)
	
	// proceed towards always the minimum side cos we need bigger width
	// TWO POINTER
	public int trap(int[] a) {
		int l = 0;
		int h = a.length-1;
		int result = 0;
		int leftMax = 0, rightMax = 0;
		while (l < h) {
		
			if(a[l] < a[h]) {
				
				// proceed to left
				if(a[l]  > leftMax) {
					leftMax = a[l];
				}else {
					result += leftMax - a[l];
				}
				
				l++;
			} else {
				
				if(a[h] > rightMax) {
					rightMax = a[h];
				} else {
					result += rightMax - a[h];
				}
				h--;
			}
		}
		return result;
	}
	
	//Easy to understand, More intuitive.
	public int trapAwesome(int[] height) {
        // time : O(n)
        // space : O(1)
        if (height.length==0) return 0; 
        int left = 0, right = height.length-1; 
        int leftMax=0, rightMax=0; 
        int ans = 0; 
        while (left < right) {
            if (height[left] > leftMax) leftMax = height[left]; 
            if (height[right] > rightMax) rightMax = height[right];
            if (leftMax < rightMax) {
                ans += Math.max(0, leftMax-height[left]); 
                left++; 
            } else {
                ans += Math.max(0, rightMax-height[right]); 
                right--; 
            }
        }
        return ans; 
    }
}
