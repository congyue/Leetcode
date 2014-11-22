public class Solution {
	public boolean isMatch(String s, String p) {
		int lenS = s.length();
		int lenP = p.length();
		if (lenS == 0 && lenP == 0)
			return true;
		else if (lenP == 0)
			return false;

		boolean[][] dp = new boolean[lenP + 1][lenS + 1];
		//Define "" and "" as match.
		dp[0][0] = true;

		for (int i = 1; i < lenP + 1; i++) {
			char letterP = p.charAt(i - 1);
			//Result of "" and "StrPx*" is equavalent to "" and "StrP"
			if (letterP == '*' && i > 1)
				dp[i][0] = dp[i - 2][0];

			for (int j = 1; j < lenS + 1; j++) {
				char letterS = s.charAt(j - 1);

				if (letterP == '*') {
					char letterP_last = p.charAt(i - 2);
					//"StrSy" and "StrPx*"
					//If x matches y, -> compare "StrS" and "StrPx*"
					//if x does not match y, -> compare "StrS" and "StrP"
					dp[i][j] = (((letterP_last == letterS || letterP_last == '.') && dp[i][j - 1])|| dp[i - 2][j]);
				}
				else
					//"StrSy" and "StrPx"
					//If x matches y, compare "StrS" and "StrP"
					dp[i][j] = ((letterP == letterS || letterP == '.') && dp[i - 1][j - 1]);

				//System.out.print("dp[" + i + ", "+ j +  "] Comparing \"" + s.substring(0, j) + "\" and \"" + p.substring(1, i) + "\"... ");
				//System.out.println(dp[i][j] ? "Match!" : "Not Match!");
			}
		}
		return dp[lenP][lenS];
	}

	public static void main (String[] args) {
		Solution solution = new Solution();
		String s = "ab";
		String p = ".*";
		System.out.println("\"" + p + "\" and \"" + s + "\" match? -- " + solution.isMatch(s, p));
	}
}
