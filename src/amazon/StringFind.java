package amazon;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

/*
 * Input two string array and return a string array that contains the elements that
 * are in both arrays.
 */

public class StringFind {
	private String[] FindtheSame(String[] s1, String[] s2) {
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < s1.length; i++) {
			set.add(s1[i]);
		}
		List<String> common = new ArrayList<String>();
		for (int i = 0; i < s2.length; i++) {
			if (set.contains(s2[i])) {
				common.add(s2[i]);
			}
		}
		String[] commonString = common.toArray(new String[common.size()]);
		return commonString;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringFind stringfinder = new StringFind();
		String[] a = {"red", "orange", "kkbox", "banana"};
		String[] b = {"apple", "orange", "pineapple", "red"};
		String[] ans = stringfinder.FindtheSame(a, b);
		for (String element : ans) {
			System.out.println(element);
		}

	}

}
