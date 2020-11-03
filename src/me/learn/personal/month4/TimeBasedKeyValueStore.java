/**
 * 
 */
package me.learn.personal.month4;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Title 981 :
 * 
 *  Create a timebased key-value store class TimeMap, that supports two operations.

1. set(string key, string value, int timestamp)

    Stores the key and value, along with the given timestamp.

2. get(string key, int timestamp)

    Returns a value such that set(key, value, timestamp_prev) was called previously, with timestamp_prev <= timestamp.
    If there are multiple such values, it returns the one with the largest timestamp_prev.
    If there are no values, it returns the empty string ("").

 

Example 1:

Input: inputs = ["TimeMap","set","get","get","set","get","get"], inputs = [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
Output: [null,null,"bar","bar",null,"bar2","bar2"]
Explanation:   
TimeMap kv;   
kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1   
kv.get("foo", 1);  // output "bar"   
kv.get("foo", 3); // output "bar" since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 ie "bar"   
kv.set("foo", "bar2", 4);   
kv.get("foo", 4); // output "bar2"   
kv.get("foo", 5); //output "bar2"   


 * 
 * @author bramanarayan
 * @date Aug 2, 2020
 */
public class TimeBasedKeyValueStore {
	
		/**
		 * ["TimeMap","set","set","get","get","get","get","get"]
	[[],["love","high",10],["love","low",20],["love",5],
	["love",10],["love",15],["love",20],["love",25]]
		 */
		
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TimeMap solution = new TimeMap();
		solution.set("love", "high", 10);
		solution.set("love", "low", 20);

		System.out.println(solution.get("love", 5));
		System.out.println(solution.get("love", 10));

		solution.set("love", "high", 10);
		solution.set("love", "high", 10);
		solution.set("love", "high", 10);

	}
	
	
}

// Map<String, TreeMap<Integer,String> - key idea
class TimeMap {
	
	Map<String, TreeMap<Integer, String>> m = new HashMap<>();

    /** Initialize your data structure here. */
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        m.computeIfAbsent(key, f -> new TreeMap<Integer, String>()).put(timestamp, value);
    	
    }
    
    public String get(String key, int timestamp) {
    	if(!m.containsKey(key)) {
    		return "";
    	}
    	
    	if(m.get(key).floorEntry(timestamp) != null) {
        	
        	return m.get(key).floorEntry(timestamp).getValue();
    		
    	}
    	return "";
    }
}