/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 1344 :
 * 
 * Date : Jan 1, 2021
 * 
 * @author bramanarayan
 *
 */
public class AngleBetweenHourAndMinuteClock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// SMALLER angle between hour and minute handle
	public double angleClock(int hour, int minutes) {

		int minDegree;
		int hourDegree;
		double hourDiffDegree;

		minDegree = minutes == 0 ? 0 : minutes * 6; // 1 minute = 6 degrees
		hourDegree = (hour == 0 || hour == 12 || hour == 24) ? 0 : hour * 30; // 1 hour = 30 degrees

		hourDiffDegree = 0.5 * minutes; // hour handle will move 0.5 degree for every 1 minute movement

		double max1 =  (double) Math.abs(minDegree - hourDegree - hourDiffDegree); // clockwise
		
		
		return Math.min(max1, Math.abs(360-max1)); // anticlock
		
	}

}
