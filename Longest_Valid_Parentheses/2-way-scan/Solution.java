public class Solution {
	public int longestValidParentheses(String s) {
		int len = s.length();

		char[] sArray = s.toCharArray();
		int index = 0, count = 0,  unpair = 0, result = 0;
		//Forward scan, pair right parentheses but can't deal with redundant left one
		for (; index < len; index++) {
			if (sArray[index] == '(')
				unpair ++;
			else if (sArray[index] == ')')
				unpair --;

			count++;
			//Update result when valid parentheses sequence found
			//But keep count unchanged to try to match longer sequence
			if (unpair == 0)
				result = count > result ? count : result;
			//Invalid sequence found, clear unpair and count
			else if (unpair < 0) {
				unpair = 0;
				count = 0;
			}
		}

		//Reverse scan, to deal with situation like "(()"
		count = 0;
		unpair = 0;
		for (index = len - 1; index >= 0; index--) {
			if (sArray[index] == ')')
				unpair ++;
			else if (sArray[index] == '(')
				unpair --;

			count++;
			if (unpair == 0)
				result = count > result ? count : result;
			else if (unpair < 0) {
				unpair = 0;
				count = 0;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "(()";
		System.out.println("Longest valid parentheses length of \"" + s + "\" is " +
				solution.longestValidParentheses(s));
	}
}
