/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 371 :
 * 
 * Date : Jan 6, 2021
 * 
 * @author bramanarayan
 *
 */
public class AddNumbersWithoutPlus {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AddNumbersWithoutPlus solution = new AddNumbersWithoutPlus();
		System.out.println(solution.getSum(-3, 5));
	}

	// piece of shit problem for interviews - facebook fav
	public int getSum(int a, int b) {

		int x = Math.abs(a);
		int y = Math.abs(b);

		if (x < y)
			return getSum(b, a);// ensure always a is greater than b
		
	
		int sign = a > 0? 1 : -1;
		
		// both and a and b are positive, like 5 + 3 = 8
		if(a * b >= 0) {
			
			// SUM OF TWO POSITIVE NUMBERS
			while(y!= 0) { // if y is 0, then there is nothing to add to x. x -> is the final answer
				int answer = x ^ y;
				int carry = (x & y) << 1;
				x = answer;
				y = carry;
			}
		} else {
			
			// SUM if ONE OF THEM IS NEGATIVE
			while(y!= 0) { // if y is 0, then there is nothing to add to x. x -> is the final answer
				int answer = x ^ y;
				int carry = ((-x) & y) << 1;
				x = answer;
				y = carry;
			}
		}
		
		return x * sign;
		
		
	}
	
	// OR 
	// short form of above program
	 public int getSumBEST(int a, int b) {
	        while (b != 0) {
	            int answer = a ^ b;
	            int carry = (a & b) << 1;
	            a = answer;
	            b = carry;
	        }
	        
	        return a;
	    }
}
