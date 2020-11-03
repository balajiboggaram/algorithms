/**
 * 
 */
package me.learn.personal.month2;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 535 :
 * 
 * Note: This is a companion problem to the System Design problem: Design
 * TinyURL.
 * 
 * TinyURL is a URL shortening service where you enter a URL such as
 * https://leetcode.com/problems/design-tinyurl and it returns a short URL such
 * as http://tinyurl.com/4e9iAk.
 * 
 * Design the encode and decode methods for the TinyURL service. There is no
 * restriction on how your encode/decode algorithm should work. You just need to
 * ensure that a URL can be encoded to a tiny URL and the tiny URL can be
 * decoded to the original URL.
 * 
 * 
 * @author bramanarayan
 * @date Aug 17, 2020
 */
public class EncodeAndDecodeTinyURL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	Codec solution = new Codec();
	System.out.println(solution.encode("https://google.com"));
	System.out.println(solution.decode("b"));
	
	System.out.println(solution.encode("https://facebook.com"));
	System.out.println(solution.decode("c"));
	
	System.out.println(solution.encode("https://linkedin.com"));
	System.out.println(solution.decode("d"));
	}

}

class Codec {

	String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	Map<Integer, Tuple> map = new HashMap<>();
	int count = 0;

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		count++;
		String hash = generateHash(count);
		map.put(count, new Tuple(hash, longUrl));
		return hash;
	}

	private String generateHash(int count) {
		StringBuilder sb = new StringBuilder();
		while(count > 0) {
			int remainder = count % 62;
			sb.append(alphabet.charAt(remainder));
			count = count / 62;
		}
		if(count > 0) sb.append(alphabet.charAt(count));
		return sb.reverse().toString();
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		int hash = generateHash(shortUrl);
		return map.get(hash).longUrl;
	}

	private int generateHash(String shortUrl) {
		int result = 0;
		for(int i = 0; i < shortUrl.length(); i++) {
			result = result * 62 + alphabet.indexOf(shortUrl.charAt(i));
		}
		return result;
	}
}

class Tuple {
	String longUrl;
	String shortUrl;

	public Tuple(String shortUrl, String longUrl) {
		this.longUrl = longUrl;
		this.shortUrl = shortUrl;
	}
}