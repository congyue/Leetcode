public class Solution {
	    public int minDistance(String word1, String word2) {
			int len1 = word1.length();
			int len2 = word2.length();

			//DP state matrix, index range from 0 ~ len
			//dp[i][j] stands for steps needed from first i letters of word1, to first j letters of word2
			int[][] dp = new int[len1 + 1][len2 + 1];

			//Initialize the base condition, "" to str must need str.length() steps, and vice versa.
			for (int i = 0; i <= len1; i++)
				dp[i][0] = i;
			for (int j = 0; j <= len2; j++)
				dp[0][j] = j;

			//Iterate from dp[1][1] to dp[len1][len2]
			for (int i = 1; i <= len1; i++)
				for (int j = 1; j <= len2; j++) {
					//If last letters are same, e.g. str1x and str2x, then degrade to str1 and str2 problem 
					if (word1.charAt(i-1) == word2.charAt(j-1))
						dp[i][j] = dp[i-1][j-1];

					//If last letters are different, e.g. str1x and str2y choose the minimum steps from following options:
					//-Match letter by str1x -> str1y, steps is 1 + (str1 and str2 problem).
					//-Match letter by str1x -> str1xy, steps is 1 + (str1x and str2 problem).
					//-Match letter by str1x -> str1, steps is 1 + (str1 and str2y problem).
					else
						dp[i][j] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));

					//Debug command to print out each iteration result
					//System.out.println(word1.substring(0,i) + " to " + word2.substring(0,j) + " need " + dp[i][j]  + " steps.");
				}
			return dp[len1][len2];
		}
		public static void main (String[] args) {
			Solution solution = new Solution();
			String word1 = "abcd";
			String word2 = "3a4def";
			System.out.println("Edit distance between \"" + word1 + "\" and \"" + word2 + "\" is: " + solution.minDistance(word1, word2));
		}
}
