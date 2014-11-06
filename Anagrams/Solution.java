import java.util.*;
public class Solution {
	public List<String> anagrams(String[] strs) {
		//Use linked list to store results
		List<String> result = new LinkedList<String>();
		//Anagram string will become same after sorting
		//Key: sorted string; Value: strings share the same key.
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		for (String str : strs) {
			char[] strArray = str.toCharArray();
			Arrays.sort(strArray);
			String sortedStr = new String(strArray);

			//If entry not exist, create an empty entry
			if (!map.containsKey(sortedStr))
				map.put(sortedStr, new ArrayList<String>());

			//If entry exist, add current string to hashmap
			map.get(sortedStr).add(str);
		}

		for (List<String> strList : map.values())
			//If strList.size() > 1, means at least 2 strings are anagrams.
			if (strList.size() > 1)
				result.addAll(strList);

		return result;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] strs = {"earth", "light", "team", "program", "meat", "tight", "heart"};
		System.out.println("All groups of anagrams strings are: " + solution.anagrams(strs));
	}
}
