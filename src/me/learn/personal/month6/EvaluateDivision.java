/**
 * 
 */
package me.learn.personal.month6;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 399 :
 * 
 * Date : Jan 15, 2021
 * 
 * @author bramanarayan
 *
 */
public class EvaluateDivision {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0],
	queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]] Output:
	 * [6.00000,0.50000,-1.00000,1.00000,-1.00000] Explanation: Given: a / b = 2.0,
	 * b / c = 3.0 queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x =
	 * ? return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
	 */
	public double[] calcEquation(String[][] e, double[] values, String[][] q) {
		double[] res = new double[q.length];

		Map<String, String> parentMap = new HashMap<>();
		Map<String, Double> dist = new HashMap<>();

		for (int i = 0; i < e.length; i++) {
			
			String x = e[i][0];
			String y = e[i][1];
			
			String r1 = findParent(parentMap, dist, x);
			String r2 = findParent(parentMap, dist, y);
			
			parentMap.put(r1, r2);
			dist.put(r1, dist.get(y) * values[i] / dist.get(x));
		}

		for (int i = 0; i < q.length; i++) {
			if (!parentMap.containsKey(q[i][0]) || !parentMap.containsKey(q[i][1])) {
				res[i] = -1.0;
				continue;
			}
			String r1 = findParent(parentMap, dist, q[i][0]);
			String r2 = findParent(parentMap, dist, q[i][1]);
			if (!r1.equals(r2)) {
				res[i] = -1.0;
				continue;
			}
			res[i] = (double) dist.get(q[i][0]) / dist.get(q[i][1]);
		}
		return res;
	}

	private String findParent(Map<String, String> root, Map<String, Double> dist, String s) {
		if (!root.containsKey(s)) {
			root.put(s, s);
			dist.put(s, 1.0);
			return s;
		}
		if (root.get(s).equals(s))
			return s;
		String lastP = root.get(s);
		String p = findParent(root, dist, lastP);
		root.put(s, p);
		dist.put(s, dist.get(s) * dist.get(lastP));
		return p;
	}

}
