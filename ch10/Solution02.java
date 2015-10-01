package chapter10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution02 {
	//Sort the char array of each string and put anagrams into a list
	//Output the list one by one
	public static String sortString(String str) {
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < charArray.length; i++) {
			sb.append(charArray[i]);
		}
		return sb.toString();
	}
	
	public static void sortAnagram(String[] array) {
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < array.length; i++) {
			String sortedString = sortString(array[i]);
			if (map.containsKey(sortedString)) {
				ArrayList<String> list = map.get(sortedString);
				list.add(array[i]);
				map.put(sortedString, list);
			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(array[i]);
				map.put(array[i], list);
			}
		}
		int i = 0;
		Iterator it = map.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        ArrayList<String> list = (ArrayList<String>) pair.getValue();
	        for (String word : list) {
	        	array[i] = word;
	        	i++;
	        }
	    }
	}
	
	public static void main(String[] args) {
		String[] array = {"dog", "act", "god", "cat", "test"};
		sortAnagram(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
