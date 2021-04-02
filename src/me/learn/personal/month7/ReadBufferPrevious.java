/**
 * 
 */
package me.learn.personal.month7;

/**
 * Title 158 :
 * 
 * Date : Mar 6, 2021
 * 
 * @author bramanarayan
 *
 */
public class ReadBufferPrevious {

}

/**
 * The read4 API is defined in the parent class Reader4. int read4(char[] buf4);
 */
class Solution extends Reader4 {
	/**
	 * @param buf Destination buffer
	 * @param n   Number of characters to read
	 * @return The number of actual characters read
	 */
	/**
	 * @param buf Destination buffer
	 * @param n   Maximum number of characters to read
	 * @return The number of characters read
	 */
	char[] prevBuf = new char[4];
	int prevSize = 0;
	int prevIndex = 0;

	public int read(char[] buf, int n) {
		int counter = 0;

		while (counter < n) {
			if (prevIndex < prevSize) {
				buf[counter++] = prevBuf[prevIndex++];
			} else {
				prevSize = read4(prevBuf);
				prevIndex = 0;
				if (prevSize == 0) {
					// no more data to consume from stream
					break;
				}
			}
		}
		return counter;
	}

	// MOCK METHOD
	private int read4(char[] prevBuf2) {
		// TODO Auto-generated method stub
		return 0;
	}
}

class Reader4 {

}