import java.util.*;
public class Solution {
	public List<Integer> findSubstring(String S, String[] L) {
		int lenS = S.length(), lenL = L.length, lenLElement = 0;
		if (lenL > 0)
			lenLElement = L[0].length();
		int lenResult = lenL*lenLElement;
		if (lenS < lenResult)
			return new LinkedList<Integer>();

		List<Integer> result = new LinkedList<Integer>();
		HashMap<String, Integer> refMap = new HashMap<String, Integer>();
		HashMap<String, Integer> findMap = new HashMap<String, Integer>();

		//Process strings in L, put <string, quantity> to refMap, then L is useless
		for (String s : L) {
			if (!refMap.containsKey(s))
				refMap.put(s, 1);
			else
				refMap.put(s, refMap.get(s) + 1);
		}

		//Compare window from S[i] <-> s[j]
		for (int i = 0; i < lenS - lenResult + 1; i++) {
			int j = i;
			//Each time changed to new window, reset findMap
			findMap.clear();
			//Extend the window if s[j] can be found and still available
			for (j = i; j < i + lenResult; j += lenLElement) {
				String word = S.substring(j, j + lenLElement);
				//System.out.println("i = " + i + ", j = " + j +" Lookup " + word + "...");

				//Check if this word come from L
				if (!refMap.containsKey(word)) break;

				//If L contains current word, add it to findMap
				if (!findMap.containsKey(word))
					findMap.put(word, 1);
				else
					findMap.put(word, findMap.get(word) + 1);

				//This word is already used more times than its appearance in L, abort
				if (findMap.get(word) > refMap.get(word)) break;

				//System.out.println("Found it in refMap and still available, start next loop...");
			}
			if (j - i == lenResult) {
				result.add(i);
				//System.out.println("i = " + i + ", j = " + j + " Index " + i + " added.");
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String S = "barfoothefoobarman";
		String[] L = {"foo", "bar"};
		List<Integer> result = solution.findSubstring(S, L);
		System.out.println("S = " + S);
		System.out.print("L = ");
		for (String s : L) {
			System.out.print("\"" + s + "\" ");
		}
		System.out.println("\nResult is: " + result);
	}
}
