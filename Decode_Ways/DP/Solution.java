public class Solution {
	public int numDecodings(String s) {
		int len = s.length();
		if (len < 1)
			return 0;
		char[] sArray = s.toCharArray();
		//dp[i]: decoding ways of first i letters
		int[] dp = new int[len + 1];
		//Set base case to 1, for further calculation
		dp[0] = 1;

		for (int i = 1; i < len + 1; i++) {
			char letter = sArray[i - 1], lastLetter = ' ';
			if (i > 1)
				lastLetter = sArray[i - 2];

			//When meet '0', last letter must be '1' or '2', and dp[i] = dp[i - 2], otherwise return 0
			if (letter == '0') {
				if (lastLetter != '1' && lastLetter != '2')
					return 0;
				dp[i] = dp[i - 2];
				continue;
			}

			//All non-zero cases
			else {
				//first case, decode this letter individually, has dp[i - 1] decode ways.
				dp[i] += dp[i - 1];

				//second case, decode this letter and last letter together, if possible. It has dp[i - 2] decode ways
				if (lastLetter == '1' || (letter <= '6' && letter >= '1' && lastLetter == '2'))
					dp[i] += dp[i - 2];
			}
			//System.out.println(s.substring(0, i) + " has " + dp[i] + " decoding ways.");
		}

		return dp[len];
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "24110";
		System.out.println("String \"" + s + "\" has " + solution.numDecodings(s) + " decoding ways.");
	}
}
