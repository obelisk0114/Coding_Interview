package amazon;

/*
 * http://note-whu.rhcloud.com/2015/09/29/常見map的特色及用法/
 */

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class FindFirstDuplicated {
	// Find first duplicated element
	int findFirstDuplicated(int[] arr) {
		Map<Integer, Integer> pair = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (pair.containsKey(arr[i])) {
				return arr[i];
			}
			pair.put(arr[i], 1);
		}
		throw new IllegalArgumentException("No duplicated numbers");
	}
	
	// find first element that appears twice
	int findFirst2(int[] arr) {
		Map<Integer, Integer> pair = new LinkedHashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (pair.containsKey(arr[i])) {
				int value = pair.get(arr[i]) + 1;
				pair.put(arr[i], value);
			}
			else {				
				pair.put(arr[i], 1);
			}
		}
		
		for (Map.Entry<Integer, Integer> entry : pair.entrySet()) {
			//System.out.println(entry.getKey() + "   " + entry.getValue());
			if (entry.getValue() == 2) {
				return entry.getKey();
			}
		}
		
		throw new IllegalArgumentException("No duplicated numbers");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindFirstDuplicated find = new FindFirstDuplicated();
		int[] arr = {1, 2, 3, 4, 5, 2, 6, 3, 7, 8, 9, 10, 11, 12, 13};
		int[] arr2 = {1, 2, 3, 4, 5, 4, 6, 3, 7, 8, 9, 2, 11, 2, 13};
		System.out.println(find.findFirstDuplicated(arr));
		System.out.println(find.findFirst2(arr));
		System.out.println(find.findFirstDuplicated(arr2));
		System.out.println(find.findFirst2(arr2));

	}

}
