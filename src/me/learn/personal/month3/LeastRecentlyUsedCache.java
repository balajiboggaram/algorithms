/**
 * 
 */
package me.learn.personal.month3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Title :
 * 
 * @author bramanarayan
 * @date Jul 13, 2020
 */
public class LeastRecentlyUsedCache {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LRUCache cache = new LRUCache(2);
		cache.put(1,1);
		cache.put(2,2);
		System.out.println(cache.get(1));
		cache.put(3,3);
		System.out.println(cache.get(2));
		
		cache.put(4,4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));

	}

}

class LRUCache {

	int capacity;
	Map<Integer, CEntry> map;
	Deque<CEntry> q;

	LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<Integer, CEntry>();
		q = new ArrayDeque<CEntry>();
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}

		CEntry temp = map.get(key);
		q.remove(temp);
		q.addLast(temp);
		return temp.value;
	}

	public void put(int key, int value) {
		CEntry temp = new CEntry(key, value);
		
		// remove the old entry if it exists
		if (map.containsKey(key)) {
			CEntry exist = map.remove(key);
			q.remove(exist);
		}
		
		if (map.size() >= capacity) {
			CEntry delete = q.removeFirst();
			map.remove(delete.key);
		} 
		
		map.put(key, temp);
		q.addLast(temp);
	}
}

class CEntry {

	public int key;
	public int value;

	public CEntry(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */