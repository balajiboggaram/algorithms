/**
 * 
 */
package me.learn.personal.month4;

/**
 * Title 1011 :
 * 
 *  A conveyor belt has packages that must be shipped from one port to another within D days.

The i-th package on the conveyor belt has a weight of weights[i].  Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within D days.

Example 1:

Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
Output: 15
Explanation: 
A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed. 

 * 
 * @author bramanarayan
 * @date Aug 2, 2020
 */
public class CapacityToShipInDdays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CapacityToShipInDdays solution = new CapacityToShipInDdays();
		System.out.println(solution.shipWithinDays(new int[] {11,2,44,300,315,48,491,240,9,480,491,29,145,155,453,170,24,147,337,231,95,200,281,296,497,343,369,283,145,278,38,59,437,213,71,195,356,167,263,383,461,434,169,52,458,67,302,250,62,371,250,349,36,421,439,385,73,25,469,313,293,422,4,289,155,89,74,428,105,476,430,91,153,480,158,496,70,280,494,396,8,104,190,257,275,382,236,116,228,348,428,60,333,272,194,205,240,302,272,470,204,155,173,241,388,500,138,225,106,274,469,430,328,430,258,386,183,401,176,304,87,24,170,400,276,147,171,71,452,65,152,126,499,150,111,475,158,33,150,488,404,34,412,346,164,173,16,160,413,201,72,169,93,178,467,325,374,220,179,377,88,193,313,291,21,215,412,327,59,467,361,500,334,283,314,232,488,178,46,455,91,250,163,180,26,269,104,352,156,93,487,265,419,350,120,281,102,84,500,56}, 10));	

		//System.out.println(solution.shipWithinDays(new int[] {1,2,3,1,1}, 4));

		//System.out.println(solution.shipWithinDays(new int[] {1,2,3,4,5,6,7,8,9,10}, 5));
	}

	// Keep picking the length as binary search. so we can eliminate half of chances
    public int shipWithinDays(int[] a, int D) {
        
    	// a -> weights
    	int avg = 0, max = 0, sum = 0;
    	for(int i = 0;i< a.length;i++) {
    		sum += a[i];
    		max = Math.max(max, a[i]);
    	}
    	
    	if(D ==1) return sum; // send all in just one day
    	
    	avg = sum/a.length;
    	int worstSend = Math.max(max, avg); // on worst case how many to send in a day
    	// depends on Max of( single day max vs average )
    	
    	int capacity = 0; // this is the result we need
    	
    	int l = 0;
    	int h = worstSend * a.length;
    	while( l <= h) {
    		int mid = l + (h -l)/2;
    		if(canSend(a, mid, D)) {
    			capacity = mid;
    			h = mid -1;
    		} else {
    			l = mid + 1;
    		}
    	}
    	return capacity;	
    }

    // Can I send all packages in d days, by sending each day - cap
	private boolean canSend(int[] a, int cap, int d) {

		int i = 0; // package identifier
		int[] ship = new int[d];
		
		// try to fill every ship
		for (int j = 0; j < d; j++) {

			// fill ship j
			while( i < a.length && ship[j] + a[i] <= cap) {
				ship[j] += a[i];
				i++;
			}
			
			if(i == a.length) {
				return true;
			}
		}
		return false;

	}
}
