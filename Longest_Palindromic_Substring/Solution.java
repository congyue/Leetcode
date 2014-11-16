public class Solution {
	public String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;

		char[] sArray = s.toCharArray();
		int max_len = 1, index = 0;

		//dp[i][j]: substring s[i ... j] is palindrome or not
		boolean[][] dp = new boolean[len][len];

		for (int end = 0; end < len; end ++) {
			dp[end][end] = true;
			for (int start = 0; start < end; start ++) {
				//When length = 2, etc. xy, then x=y -> palindrome
				//When length > 2, etc. xSTRy, then x=y and STR is palindrome -> palindrome
				if (sArray[start] == sArray[end] && (end - start < 2 || dp[start+1][end-1])) {
					dp[start][end] = true;

					if (end - start + 1 > max_len) {
						max_len = end - start + 1;
						index = start;
					}
				}
				//System.out.println(s.substring(start, end+1) + "? " + dp[start][end]);
			}
		}
		return s.substring(index, index + max_len);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "wefjisoabccbacjndls";
		System.out.println("The longest palindrome substring of \"" +
				s + "\" is \"" + solution.longestPalindrome(s) + "\"" );
	}
}
