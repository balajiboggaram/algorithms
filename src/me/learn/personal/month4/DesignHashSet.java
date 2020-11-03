/**
 * 
 */
package me.learn.personal.month4;

import java.util.ArrayList;
import java.util.List;

/**
 * Title 705 :
 * 
 *  Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

    add(value): Insert a value into the HashSet. 
    contains(value) : Return whether the value exists in the HashSet or not.
    remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.


Example:

MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    // returns true
hashSet.remove(2);          
hashSet.contains(2);    // returns false (already removed)



 * 
 * @author bramanarayan
 * @date Jul 28, 2020
 */
public class DesignHashSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyHashSet hashSet = new MyHashSet();
		hashSet.add(1);         
		hashSet.add(2);         
		hashSet.contains(1);    // returns true
		hashSet.contains(3);    // returns false (not found)
		hashSet.add(2);          
		hashSet.contains(2);    // returns true
		hashSet.remove(2);          
		System.out.println(hashSet.contains(2));    // returns false (already removed)
	}

}

class MyHashSet {
	
	int size = 3;
	BucketSet[] dict = new BucketSet[size];

    /** Initialize your data structure here. */
    public MyHashSet() {
    	// init
        for(int i =0;i<size;i++) {
        	dict[i] = new BucketSet();
        }
    }
    
    public void add(int key) {
        int hash = hashCode(key);
        if(!contains(key))
        dict[hash].insert(key);
    }
    
    public void remove(int key) {
    	int hash = hashCode(key);
    	if(contains(key))
    	dict[hash].remove(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
    	int hash = hashCode(key);
    	return dict[hash].list.contains(key);
    }
    
    public int hashCode(int key) {
    	return key % size;
    }
}

class BucketSet {
	
	List<Integer> list = new ArrayList<Integer>();
	
	void insert(int key) {
		list.add(key);
	}

	public void remove(Integer key) {
		
		if(list.contains(key))
		list.remove(key);
	}
	
}
