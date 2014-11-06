public class Solution {
	public int numDistinct(String S, String T) {
		int lenS = S.length();
		int lenT = T.length();
		//dp[i][j]: distinct subsequences of T[0...j] in S[0...i]
		int[][] dp = new int[lenS + 1][lenT + 1];

		//Base case, S[0...i] always contains 1 "" (empty string)
		for(int i = 0; i < lenS; i++)
			dp[i][0] = 1;

		for(int i = 1; i <= lenS; i++)
			for (int j = 1; j <= lenT; j++) {
				//If S shorter than T, S will never contain T, break.
				if (i < j)
					break;

				//If last letter is equal, e.g. "bleed" and "bed" then consider following 2 options:
				//-Eliminate both last letter and compare the rest, e.g. "blee" and "be", result = dp[i-1][j-1]
				//-Ignore last letter of S and re-compare, e.g. "blee" and "bed", result = dp[i-1][j]
				if (S.charAt(i-1) == T.charAt(j-1))
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				//If last letter is different, only option is ignore last letter of S, then re-compare
				else
					dp[i][j] = dp[i-1][j];

				//Debug command, enable to print out each iteration:
				//System.out.printf("dp[" + i + ", " + j + "]");
				//System.out.println(S.substring(0, i) + " has " + dp[i][j] + " " + T.substring(0, j));
			}

		return dp[lenS][lenT];
	}
	public static void main(String[] args) {
	Solution solution = new Solution();
	String s = "rabbbit";
	String t = "rabbit";
	System.out.println("There are " + solution.numDistinct(s, t) +
			" distinct subsequences of \"" + t + "\" in \"" + s + "\".");
	}
}
