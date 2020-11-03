package me.learn.personal.month1;

/**
 * 
 * Title : ZigZag Conversion. 
 * 
 * @author bramanarayan
 * @date Apr 24, 2020
 */
public class ZigZaggConversion {

	public static void main(String[] args) {
		
		ZigZaggConversion solution = new ZigZaggConversion();
		//solution.convert("PAYPALISHIRING", 3);
		solution.convert("AB", 1);

	}

	/**
	 * FINAL SOLUTION - Very Nicely and compactly written program.
	 */
	public String convert(String s, int nRows) {
	    char[] c = s.toCharArray();
	    int len = c.length;
	    StringBuffer[] sb = new StringBuffer[nRows];
	    for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
	    
	    int i = 0;
	    while (i < len) {
	        for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
	            sb[idx].append(c[i++]);
	        for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
	            sb[idx].append(c[i++]);
	    }
	    for (int idx = 1; idx < sb.length; idx++)
	        sb[0].append(sb[idx]);
	    return sb[0].toString();
	}
	
	public String convertMy(String s, int numRows) {
		if(s == null) {
			return null;
		}
		if (s.equals("")) {
			return "";
		}
		
		if(s.length() <= numRows) {
			return s;
		}
		
		int i =0,j =0;
		char[][] result = new char[numRows][s.length()];
		int k =0;

		while(k < s.length()) {
			System.out.println(k);
			while ( i <  numRows && k < s.length() ) {
				System.out.println(s.charAt(k) + " at position " + i + " " + j);
				result[i][j] = s.charAt(k);
				k++;
				i++;
			}
			i--;
			
			while ( i > 0 && k < s.length()  ) {
				System.out.println(s.charAt(k));
				i--;
				j++;
				System.out.println(s.charAt(k) + " at position " + i + " " + j);
				result[i][j] = s.charAt(k);
				k++;
			}
			i++;
		}
		
		return printResult(result, numRows, j);
		
	}
	
	String printResult(char[][] result, int rows, int columns) {
		System.out.println("Print result");
		StringBuilder sb = new StringBuilder();
		for(int i=0;i< rows; i++) {
			for(int j =0;j<=columns; j++) {
				if(Character.isAlphabetic(result[i][j])) {
					sb.append(result[i][j]);
				}
				
			}
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
}
