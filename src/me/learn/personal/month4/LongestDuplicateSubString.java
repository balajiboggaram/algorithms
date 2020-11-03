/**
 * 
 */
package me.learn.personal.month4;

import java.util.HashSet;

/**
 * Title 1044 :
 * 
 * Given a string S, consider all duplicated substrings: (contiguous) substrings
 * of S that occur 2 or more times. (The occurrences may overlap.)
 * 
 * Return any duplicated substring that has the longest possible length. (If S
 * does not have a duplicated substring, the answer is "".)
 * 
 * 
 * Example 1:
 * 
 * Input: "banana" Output: "ana"
 * 
 * Example 2:
 * 
 * Input: "abcd" Output: ""
 * 
 * 
 * 
 * @author bramanarayan
 * @date Aug 2, 2020
 */
public class LongestDuplicateSubString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestDuplicateSubString solution = new LongestDuplicateSubString();
		//System.out.println(solution.search("Govindvind",4 ));
		//System.out.println(solution.search("banana",3 ));
		System.out.println(solution.longestDupSubstring("abcd"));

		System.out.println(solution.longestDupSubstring("banana"));
	}

	/**
	 * WORKING
	 */
	
	 public int search(int L, int a, long modulus, int n, int[] nums) {
		    // compute the hash of string S[:L]
		    long h = 0;
		    for(int i = 0; i < L; ++i) h = (h * a + nums[i]) % modulus;

		    // already seen hashes of strings of length L
		    HashSet<Long> seen = new HashSet();
		    seen.add(h);
		    // const value to be used often : a**L % modulus
		    long aL = 1;
		    for (int i = 1; i <= L; ++i) aL = (aL * a) % modulus;

		    for(int start = 1; start < n - L + 1; ++start) {
		      // compute rolling hash in O(1) time
		      h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
		      h = (h + nums[start + L - 1]) % modulus;
		      if (seen.contains(h)) return start;
		      seen.add(h);
		    }
		    return -1;
		  }

		  public String longestDupSubstring(String S) {
		    int n = S.length();
		    // convert string to array of integers
		    // to implement constant time slice
		    int[] nums = new int[n];
		    for(int i = 0; i < n; ++i) nums[i] = (int)S.charAt(i) - (int)'a';
		    // base value for the rolling hash function
		    int a = 26;
		    // modulus value for the rolling hash function to avoid overflow
		    long modulus = (long)Math.pow(2, 32);

		    // binary search, L = repeating string length
		    int left = 1, right = n;
		    int L;
		    while (left <= right) {
		      L = left + (right - left) / 2;
		      if (search(L, a, modulus, n, nums) != -1) left = L + 1;
		      else right = L - 1;
		    }

		    int start = search(left - 1, a, modulus, n, nums);
		    return S.substring(start, start + left - 1);
		  }
	
	// Use RabinKarp algorithm
	// Just grab the idea.
	public String longestDupSubstringMy(String s) {

		int n = s.length();
		int l = 0;
		int h = n - 1;
		int start = -1;
		int maxLength = 0;// the length will be adjusted as we proceed in the algorithm
		while (l <= h) {
			// this is the length on which pattern will be checked.
			int mid = l + (h - l) / 2;
			if(mid > 1) {
				int sIndex = search(s, mid);
				if ( sIndex != -1) {
					if(maxLength < mid) {
						maxLength = mid;
						start = sIndex;
					}
					l = mid + 1;
				} else {
					h = mid - 1;
				}				
			} else {
				break;
			}
		}

		System.out.println(start);
		System.out.println(maxLength);
		
		
		return (start != -1) ? s.substring(start+1, start + maxLength-1) : "";

	}

	int search(String txt, int M)  { 
		int q = 101; // a prime number
		int d = 26;
        int N = txt.length(); 
        int i; 
        int t = 0; // hash value for txt 
        int h = 1; 
      
        // The value of h would be "pow(d, M-1)%q" 
        for (i = 0; i < M-1; i++) 
            h = (h*d)%q; 
      
        // Calculate the hash value of pattern and first  window of text 
        for (i = 0; i < M; i++) 
        { 
            t = (d*t + txt.charAt(i))%q; 
        } 
      
        HashSet<Integer> hashes = new HashSet<Integer>();
        hashes.add(t);
        
        // Slide the pattern over text one by one 
        for (i = 0; i <= N - M; i++) 
        { 
            
            // Calculate hash value for next window of text: Remove 
            // leading digit, add trailing digit 
            if ( i < N-M ) 
            { 
                t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+M))%q; 
      
                // We might get negative value of t, converting it 
                // to positive 
                if (t < 0) 
                t = (t + q); 
            } 
        	
            if(hashes.contains(t)) {
            	// duplicate found 
            	return i+1;
            } else {
                
            	hashes.add(t);
    
            }
        	
        	
        }
        
        return -1;
    } 

}
