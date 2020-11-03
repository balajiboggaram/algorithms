/**
 * 
 */
package me.learn.personal.month4;

/**
 * Title 434 :
 * 
 * Count the number of segments in a string, where a segment is defined to be a
 * contiguous sequence of non-space characters.
 * 
 * Please note that the string does not contain any non-printable characters.
 * 
 * Example:
 * 
 * Input: "Hello, my name is John" Output: 5
 * 
 * 
 * @author bramanarayan
 * @date Jul 23, 2020
 */
public class NumberOfSegmentsInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NumberOfSegmentsInString solution = new NumberOfSegmentsInString();
		System.out.println(solution.countSegments("Hello, MY name is Balaji"));
		System.out.println(solution.countSegments(""));
		System.out.println(solution.countSegments(""));
		System.out.println(solution.countSegments("	foo  bar"));
	}

	public int countSegments(String s) {
		
		if (s == null )
			return 0;
		s = s.trim();
		if(s.length() == 0) return 0;
		return s.split("\\s+").length;
	}

}
