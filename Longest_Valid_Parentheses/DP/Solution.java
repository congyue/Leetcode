public class Solution {
	public int longestValidParentheses(String s) {
		int len = s.length();
		int result = 0;

		char[] sArray = s.toCharArray();
		//dp[i]: Longest valid sequence starting from s[i]
		int[] dp = new int[len];
		//dp[len -1] is always 0, starting from dp[len - 2]
		for (int i = len - 2; i >=0; i--) {
			//A sequence starting with ')' must be invalid
			if (sArray[i] == ')')
				dp[i] = 0;
			else if (sArray[i] == '(') {
				//Jump over valid sequence in the middle,
				//find s[j], the first unpair letter after them (may also be the next one)
				int j = i + dp[i + 1] + 1;
				//Add current sequence length by 2 if s[j] == ')'
				//e.g. '(())' = 2 + 2
				//      i  j
				if (j < len && sArray[j] == ')')
					dp[i] = dp[i + 1] + 2;
				//Add current sequence length with next adjacent valid sequence length
				//e.g. '(())()' = 4 + 2
				//      i  j
				if (dp[i] != 0 && j+1 < len)
					dp[i] += dp[j + 1];
			}
			result = Math.max(dp[i], result);
		}
		return result;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "))()()(";
		System.out.println("Longest valid parentheses length of \"" + s + "\" is " +
				solution.longestValidParentheses(s));
	}
}
