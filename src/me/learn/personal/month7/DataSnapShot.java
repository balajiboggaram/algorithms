/**
 * 
 */
package me.learn.personal.month7;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Title :
 * 
 * Date : Feb 17, 2021
 * 
 * @author bramanarayan
 *
 */
public class DataSnapShot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

interface Shot {
	String takeSnapshot();

	Snapshot getSnapshot(String snapshot_id);

	boolean deleteSnapshot(String snapshot_id);

	void add(String key, String value);

	void print();
}

class Snapshot implements Shot, Serializable {
	private Map<String, String> data = new HashMap<>();

	@Override
	public boolean deleteSnapshot(String snapshot_id) {
		try {
			FileOutputStream file = new FileOutputStream(snapshot_id);
			file.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public String takeSnapshot() {
		try {
			FileOutputStream file = new FileOutputStream("snapshot"); // generate some unique id for the file and return
																		// that , hardcoded for explaination
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(this);
			out.close();
			file.close();
			return "snapshot";
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Snapshot getSnapshot(String snapshot_id) {
		try {
			FileInputStream file = new FileInputStream(snapshot_id);
			ObjectInputStream inp = new ObjectInputStream(file);
			return (Snapshot) inp.readObject();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public void add(String key, String value) {
		data.put(key, value);
	}

	@Override
	public void print() {
		for (Map.Entry<String, String> iter : data.entrySet()) {
			System.out.println("Key -> " + iter.getKey() + " :: value -> " + iter.getValue());
		}
	}

	public static void main(String[] args) {
		Snapshot s1 = new Snapshot();
		s1.add("Anwar", "Shaana");
		s1.print();
		String id = s1.takeSnapshot();
		if (id != null) {
			System.out.println("Snapshot taken with id " + id);
		}
		s1 = null; // nullify the object
		Snapshot s2 = new Snapshot();
		s2.deleteSnapshot(id);
		Snapshot myOldSnapshot = s2.getSnapshot(id);
		if (myOldSnapshot != null)
			myOldSnapshot.print();
	}
}