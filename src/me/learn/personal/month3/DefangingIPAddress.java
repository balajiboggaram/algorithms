/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 1108:
 * 
 * Given a valid (IPv4) IP address, return a defanged version of that IP
 * address.
 * 
 * A defanged IP address replaces every period "." with "[.]".

 * Example 1:
 * 
 * Input: address = "1.1.1.1" Output: "1[.]1[.]1[.]1"
 * 
 * @author bramanarayan
 * @date Jul 15, 2020
 */
public class DefangingIPAddress {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DefangingIPAddress solution = new DefangingIPAddress();
		System.out.println(solution.defangIPaddr("1.1.1.1"));
	}

	// \\. is key
	public String defangIPaddr(String address) {
		address = address.replaceAll("\\.", "[.]");
		return address;
	}

}
