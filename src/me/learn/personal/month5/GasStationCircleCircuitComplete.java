/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 134 :
 * 
 * Date : Jan 5, 2021
 * 
 * @author bramanarayan
 *
 */
public class GasStationCircleCircuitComplete {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int n = gas.length;
		int totalTank = 0;
		int curTank = 0;
		int start = 0;
		
		for(int i = 0;i<n;i++) {
			totalTank = totalTank + gas[i] - cost[i];
			curTank = curTank + gas[i]  - cost[i];
			
			if(curTank < 0) {
				start = i+1;
				curTank=0;
			}
			
		}
		
		if(totalTank >= 0) {
			return start; 
		} else {
			return -1;
		}
	}
}
