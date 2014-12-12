public class Solution {
	public boolean isMatch(String s, String p) {
		int lenS = s.length(), lenP = p.length(), starCount = 0, firstMatch = 0;
		for(int i = 0; i < lenP; i++) starCount += (p.charAt(i) == '*' ? 1 : 0);
		if (lenP - starCount > lenS)
			return false;

		boolean[][] dp = new boolean[lenP + 1][lenS + 1];
		dp[0][0] = true;

		for (int i = 1; i < lenP + 1; i++ ) {
			char letterP = p.charAt(i - 1);
			if (letterP == '*') {
				//When detects '*', find first match position last round. Then dp[i][firstMatch]~dp[i][lenS] must all be true.
				for (int j = firstMatch; j < lenS + 1; j++) {
					dp[i][j] = true;
					//System.out.println("Matching " + p.substring(0, i) + " and " + s.substring(0, j) + "... " + dp[i][j]);
				}
				continue;
			}

			//Reset first match position
			firstMatch = 0;
			for (int j = 1; j < lenS + 1; j++) {
				char letterS = s.charAt(j - 1);
				if ((letterP == '?' || letterP == letterS) && dp[i - 1][j - 1]) {
					dp[i][j] = true;
					if (firstMatch == 0)
						firstMatch = j;
				}
				//System.out.println("Matching " + p.substring(0, i) + " and " + s.substring(0, j) + "... " + dp[i][j]);
			}
			//If nothing match in this round, then final result must be false.
			if (firstMatch == 0)
				return false;
		}
		return dp[lenP][lenS];
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "mississippi", p = "m*issi*iss*";
		boolean result = solution.isMatch(s, p);
		System.out.println("\"" + p + "\"" + (result ? " matches " : " does not match ") + "\"" + s + "\"");
	}
}
