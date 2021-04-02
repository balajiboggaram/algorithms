/**
 * 
 */
package me.learn.personal.month3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * Title 1146 :
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class SnapshotArray {

	List<TreeMap<Integer, Integer>> snapshots;
	int curSnapId = 0;

	// At every element, maintain a snapshotId -> value in it
	public SnapshotArray(int length) {
		snapshots = new ArrayList();

		for (int i = 0; i < length; i++) {
			snapshots.add(i, new TreeMap<Integer, Integer>());
			snapshots.get(i).put(0, 0); // at snapshot 0, every element value is 0 itself init
		}
	}

	// Add the curSnapId -> val to index position
	public void set(int index, int val) {
		snapshots.get(index).put(curSnapId, val);
	}

	// increment snap
	public int snap() {
		return curSnapId++;
	}

	// go to that index in list, and then do lower/floorEntry based on snap_id
	public int get(int index, int snap_id) {
		return snapshots.get(index).floorEntry(snap_id).getValue();
	}
}
