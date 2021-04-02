/**
 * 
 */
package me.learn.personal.month7;

/**
 * Title 1640 : 
 * 
 * Date : Feb 25, 2021
 * 
 * @author bramanarayan
 *
 */
public class CheckArrayFormationThroughConcatenation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 
	 * Input: arr = [49,18,16], pieces = [[16,18,49]]
Output: false
Explanation: Even though the numbers match, we cannot reorder pieces[0].
	 */
	
	public boolean canFormArray(int[] arr, int[][] pieces) {
		
		// FORM A #NUM# of given input
        StringBuilder sb = new StringBuilder();
        for(int x : arr){
			sb.append("#");
            sb.append(x);
            sb.append("#");
        }
        for(int i = 0; i < pieces.length; i++){
            
        	StringBuilder res = new StringBuilder();
            for(int j = 0; j < pieces[i].length; j++){
				res.append("#");
                res.append(pieces[i][j]);
                res.append("#");
            }
            
            if(!sb.toString().contains(res.toString())){
                return false;
            }
        }
        return true;
    }

}
