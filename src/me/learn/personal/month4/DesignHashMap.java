/**
 * 
 */
package me.learn.personal.month4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Title 706 : 
 * 
 * Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:

    put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
    get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
    remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.


Example:

MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);          
hashMap.put(2, 2);         
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1 
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found) 

 * 
 * @author bramanarayan
 * @date Jul 28, 2020
 */
public class DesignHashMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyHashMap hashMap = new MyHashMap();
		hashMap.put(1, 1);          
		hashMap.put(2, 2);         
		System.out.println(hashMap.get(1));            // returns 1
		System.out.println(hashMap.get(3));            // returns -1 (not found)
		hashMap.put(2, 1);          // update the existing value
		hashMap.get(2);            // returns 1 
		hashMap.remove(2);          // remove the mapping for 2
		hashMap.get(2);            // returns -1 (not found) 
	}

}

class MyHashMap {
	
	int size = 5;
	Bucket[] dict = new Bucket[size];


    /** Initialize your data structure here. */
    public MyHashMap() {
        for(int i = 0;i< size;i++) {
        	dict[i] = new Bucket();
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashCode = hashCode(key);
        
        dict[hashCode].insert(key, value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	public int get(int key) {
		int hashCode = hashCode(key);

		return dict[hashCode].read(key);
	}
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    	int hashCode = hashCode(key);

    	dict[hashCode].delete(key);
    }
    
    public int hashCode(int key) {
    	return key % size;
    }
}

// BUCKET
class Bucket {
	
	List<Pair<Integer,Integer>> list = new ArrayList<Pair<Integer,Integer>>();
	
	// if exists, update
	// if dont exists, then insert
	public void insert(int key, int value) {
		boolean keyFound = false;
		// treat as update if it already exists
			for(Pair<Integer,Integer> p : list) {
				if(p.key == key) {
					keyFound = true;
					p.value = value;
					break;
				}
			}	
			
			
		if(!keyFound) {
			list.add(new Pair(key, value));
		}

	}

	public void delete(Integer key) {
		Iterator<Pair<Integer,Integer>> it = list.iterator();
		while(it.hasNext()) {
			Pair temp = it.next();
			if(temp.key == key)
				it.remove();
		}	
	}

	public int read(Integer key) {
		int value = -1;
			for(Pair<Integer,Integer> p : list) {
				if(p.key == key) {
					value = p.value;
					break;
				}
			}		
		return value;
	}
}

// similar to Entry
class Pair<K,V> {
	K key;
	V value;
	
	public Pair(K key, V val) {
		this.key = key;
		this.value = val;
	}
}
