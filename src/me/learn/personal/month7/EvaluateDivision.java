/**
 * 
 */
package me.learn.personal.month7;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 399 :
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class EvaluateDivision {

	/**
	 *    a/b = 2.0 --> b is the root of a; the distance from a to b is 1/2.0
            - if two nums have the same root, we can get the result; a/b=2.0, b/c=3.0
            index   a   b   c
            root    b   c   c 
            dist    2   3   1
            - if we want to know a/c = ?: a = 2 * b = 2 * 3 * c => a/c = 6.0
	 */
	// UNIO FIND PROBLEM
	public double[] calcEquation(String[][] e, double[] values, String[][] q) {
		
		double[] res = new double[q.length];
		
		Map<String, String> parent = new HashMap<>();
		Map<String, Double> dist = new HashMap<>();
		
		// e has equations 0the element is a, 1st element is b a/b
		for (int i = 0; i < e.length; i++) {
			
			String a = e[i][0];
			String b = e[i][1];
			
			String root1 = find(parent, dist, a);
			
			String root2 = find(parent, dist, b);
			
			parent.put(root1, root2);
			
			dist.put(root1, dist.get(b) * values[i] / dist.get(a));
		}
		
		
		for (int i = 0; i < q.length; i++) {
			
			String a = q[i][0];
			String b = q[i][1];
			
			if (!parent.containsKey(a) || !parent.containsKey(b)) {
				res[i] = -1.0;
				continue;
			}
			
			String root1 = find(parent, dist, a);
			String root2 = find(parent, dist, b);
			
			if (!root1.equals(root2)) {
				res[i] = -1.0;
				continue;
			}
			
			res[i] = (double) dist.get(a) / dist.get(b);
		}
		return res;
	}

	private String find(Map<String, String> parent, Map<String, Double> dist, String s) {
		
		// if I dont have the child yet.
		if (!parent.containsKey(s)) {
			parent.put(s, s);
			dist.put(s, 1.0);
			return s;
		}
		
		// return the factor of parent in the chain
		if (parent.get(s).equals(s))
			return s;
		
		String lastParent = parent.get(s);
		String p = find(parent, dist, lastParent);
		
		parent.put(s, p);
		
		dist.put(s, dist.get(s) * dist.get(lastParent));
		
		return p;
	}

}
