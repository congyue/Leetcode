import java.util.*;
public class Solution {
	public List<String> findRepeatedDnaSequences(String s) {
		int len = s.length();
		List<String> result = new LinkedList<String>();
		HashMap<Integer,Boolean> hash = new HashMap<Integer, Boolean>();

		if (len < 10)
			return result;

		for (int i = 0; i < len - 9; i++) {
			String seq = s.substring(i, i + 10);
			int code = encode(seq);
			if (!hash.containsKey(code)) { //sequence appears first time
				hash.put(code, false); //Add new sequence to HashMap, false indicates this sequence not in result list.
			}
			else if (!hash.get(code)){ //sequence appears before, but it still not in result list
				result.add(seq);
				hash.put(code, true); //true indicates this sequence already in result list.
			}
		}
		return result;
	}

	public int encode(String s) {
		int len = s.length();
		char[] sArray = s.toCharArray();
		int result = 0;

		for (char c : sArray) {
			switch (c) {
				case 'A': result |= 0; break;
				case 'C': result |= 1; break;
				case 'G': result |= 2; break;
				case 'T': result |= 3; break;
			}
			result <<= 2;
		}
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "AAAAAAAAAAAAA";
		System.out.println(solution.findRepeatedDnaSequences(s));
	}
}
