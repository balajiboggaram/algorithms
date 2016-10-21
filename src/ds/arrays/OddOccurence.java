package ds.arrays;

/**
 * 
 * In a given array, all elements occur even number of times except one number. can you find that one number in array ?
 * 
 * @author bboggaramrama
 *
 */
public class OddOccurence {

	public static void main(String args[]) {
		OddOccurence driver = new OddOccurence();
/*		
 * Output :
        The odd element is :2
		The odd element is :3
		The odd element is :4
		The odd element is :7
*/
		driver.findOddOccurence(new int[] {1,1,2});
		driver.findOddOccurence(new int[] {1,1,2,2,2,2,3});
		driver.findOddOccurence(new int[] {1,1,2,4,5,2,5});
		driver.findOddOccurence(new int[] {6,6,7,7,7,7,7});

	}
	
	public void findOddOccurence(int[] a){
		
		int res = 0;
		// METHOD :  XOR operation (Beauty of XOR, You see :) )
		for(int i=0;i<a.length;i++) {
			res = res ^ a[i];
		}
		System.out.println("The odd element is :" + res);
	}
	
}
