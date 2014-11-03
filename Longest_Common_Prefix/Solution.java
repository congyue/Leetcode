public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";

		String result = "";
		//Get each letter of first string
		for (int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			//Compare the letter with each string at same index
			for (String str : strs) {
				//Abort if meet end of string or letter mismatch
				if (str.length() <= i || str.charAt(i) != c)
					return result;
			}

			//Add letter to result if letter match all strings
			result += c;
		}
		return result;
	}

	public static void main(String[] args) {
		String[] strs = {"abc", "abcdefg", "abc12345"};
		Solution solution = new Solution();
		System.out.println("Common prefix is: " + solution.longestCommonPrefix(strs));
	}
}
