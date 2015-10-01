package chapter10;

import java.util.ArrayList;

public class Listy {
	private ArrayList<Integer> list = new ArrayList<Integer>();
	
	public Listy(ArrayList<Integer> list) {
		this.list.addAll(list);
	}
	
	public int elementAt(int index) {
		if (index >= list.size() || index < 0) {
			return -1;
		} else {
			return list.get(index);
		}
	}
}
