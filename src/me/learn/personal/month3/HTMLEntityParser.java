/**
 * 
 */
package me.learn.personal.month3;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Title 1410 :
 * 
 * HTML entity parser is the parser that takes HTML code as input and replace
 * all the entities of the special characters by the characters itself.
 * 
 * The special characters and their entities for HTML are:
 * 
 * Quotation Mark: the entity is &quot; and symbol character is ". Single Quote
 * Mark: the entity is &apos; and symbol character is '. Ampersand: the entity
 * is &amp; and symbol character is &. Greater Than Sign: the entity is &gt; and
 * symbol character is >. Less Than Sign: the entity is &lt; and symbol
 * character is <. Slash: the entity is &frasl; and symbol character is /.
 * 
 * Given the input text string to the HTML parser, you have to implement the
 * entity parser.
 * 
 * Return the text after replacing the entities by the special characters.
 * 
 * Example 1:
 * 
 * Input: text = "&amp; is an HTML entity but &ambassador; is not." Output: "&
 * is an HTML entity but &ambassador; is not." Explanation: The parser will
 * replace the &amp; entity by &
 * 
 * Example 2:
 * 
 * Input: text = "and I quote: &quot;...&quot;" Output: "and I quote: \"...\""
 * 
 * 
 * @author bramanarayan
 * @date Jul 15, 2020
 */
public class HTMLEntityParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HTMLEntityParser solution = new HTMLEntityParser();
		System.out.println(solution.entityParser("&amp; is an HTML entity but &ambassador; is not."));
	}

	public String entityParser(String text) {
		Map<String, String> m = new HashMap<String, String>();
		m.put("&quot;", "\"");
		m.put("&apos;", "'");
		m.put("&gt;", ">");
		m.put("&lt;", "<");
		m.put("&frasl;", "/");

		for (Entry<String, String> e : m.entrySet()) {
			text = text.replaceAll(e.getKey(), e.getValue());
		}

		// replace & in the last step
		text = text.replaceAll("&amp;", "&");

		return text;

	}

}
