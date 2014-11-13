public class Solution {
	public int strStr(String haystack, String needle) {
		int len1 = haystack.length();
		int len2 = needle.length();
		if (len1 < len2)
			return -1;
		if (len2 == 0)
			return 0;

		for (int index = 0; index <= len1 - len2; index++)
			if (haystack.substring(index, index + len2).equals(needle))
				return index;

		return -1;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String haystack = "abcdefghij 1234567890";
		String needle = "fgh";
		System.out.println("The index of \"" + needle + "\" in \"" +
				haystack + "\" is " +solution.strStr(haystack, needle));
	}
}
