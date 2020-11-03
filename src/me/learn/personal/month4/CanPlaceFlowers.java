/**
 * 
 */
package me.learn.personal.month4;

/**
 * Title 605 :
 * 
 * Suppose you have a long flowerbed in which some of the plots are planted and
 * some are not. However, flowers cannot be planted in adjacent plots - they
 * would compete for water and both would die.
 * 
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means
 * empty and 1 means not empty), and a number n, return if n new flowers can be
 * planted in it without violating the no-adjacent-flowers rule.
 * 
 * Example 1:
 * 
 * Input: flowerbed = [1,0,0,0,1], n = 1 Output: True
 * 
 * Example 2:
 * 
 * Input: flowerbed = [1,0,0,0,1], n = 2 Output: False
 * 
 * Note:
 * 
 * The input array won't violate no-adjacent-flowers rule. The input array size
 * is in the range of [1, 20000]. n is a non-negative integer which won't exceed
 * the input array size.
 * 
 * 
 * @author bramanarayan
 * @date Jul 29, 2020
 */
public class CanPlaceFlowers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canPlaceFlowerMy(int[] flowerbed, int n) {
		int count = 0;
		for(int i=0;i<flowerbed.length;i++) {
			if(flowerbed[i] ==0 && (i ==0 || flowerbed[i-1] ==0) && ( i == flowerbed.length-1 || flowerbed[i+1] == 0)) {
				count++;
				flowerbed[i] =1;				
			}
		}
		
		return count >= n;
	
	}
	
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        return count >= n;
    }

}
