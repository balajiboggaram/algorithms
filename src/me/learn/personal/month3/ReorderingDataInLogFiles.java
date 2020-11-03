/**
 * 
 */
package me.learn.personal.month3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Title 937 :
 * 
 * You have an array of logs. Each log is a space delimited string of words.
 * 
 * For each log, the first word in each log is an alphanumeric identifier. Then,
 * either:
 * 
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * 
 * We will call these two varieties of logs letter-logs and digit-logs. It is
 * guaranteed that each log has at least one word after its identifier.
 * 
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically ignoring identifier, with the
 * identifier used in case of ties. The digit-logs should be put in their
 * original order.
 * 
 * Return the final order of the logs.
 * 
 * Example 1:
 * 
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit
 * dig","let3 art zero"] Output: ["let1 art can","let3 art zero","let2 own kit
 * dig","dig1 8 1 5 1","dig2 3 6"]
 * 
 * 
 * @author bramanarayan
 * @date Jul 15, 2020
 */
public class ReorderingDataInLogFiles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReorderingDataInLogFiles solution = new ReorderingDataInLogFiles();
		System.out.println(solution.reorderLogFiles(
				new String[] { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" }));
	}

	public String[] reorderLogFiles(String[] logs) {
		Arrays.sort(logs, (log1, log2) -> {
			String[] split1 = log1.split(" ", 2);
			String[] split2 = log2.split(" ", 2);
			boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
			boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
			if (!isDigit1 && !isDigit2) {
				int cmp = split1[1].compareTo(split2[1]);
				if (cmp != 0)
					return cmp;
				return split1[0].compareTo(split2[0]);
			}
			return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
		});
		return logs;
	}

	// BS QUESTION
	// BORING TO SOLVE this :-) TODO : fix it to sort the string excluding index.
	public String[] reorderLogFilesMy(String[] logs) {
		List<String> letters = new ArrayList<String>();
		List<String> lettersIndexes = new ArrayList<String>();

		List<String> digits = new ArrayList<String>();
		List<String> digitIndexes = new ArrayList<String>();

		int n = logs.length;
		for (int i = 0; i < n; i++) {
			String[] temp = logs[i].split("\\s+");
			if (temp[1].matches("\\d+")) {
				digits.add(logs[i].substring(logs[i].indexOf("\\s+")+1));
				digitIndexes.add(temp[0]);
			} else {
				letters.add(logs[i].substring(logs[i].indexOf("\\s+")+1));
				lettersIndexes.add(temp[0]);
			}
		}

		Collections.sort(letters);
		Collections.sort(digits);
	
		List<String> result = new ArrayList<String>();
		// merge the lists now.
		for(int i = 0;i<letters.size();i++) {
			result.add(lettersIndexes.get(i) + " " + letters.get(i));
		}
		for(int i = 0;i<digits.size();i++) {
			result.add(digitIndexes.get(i) + " " + digits.get(i));
		}
		
		return result.stream().toArray(String[]::new);
	}

}
