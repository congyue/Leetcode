public class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();
		if (len1 + len2 != len3)
			return false;

		char[] s1Array = s1.toCharArray();
		char[] s2Array = s2.toCharArray();
		char[] s3Array = s3.toCharArray();

		//dp[i][j]: Compare result of s1[0 - i], s2[0 - j], s3[0 - (i+j)]
		boolean[][] dp = new boolean[len1 + 1][len2 + 1];
		dp[0][0] = true;

		for (int i = 0; i < len1 + 1; i++) {
			for (int j = 0; j < len2 + 1; j++) {
				//System.out.println("Evaluating \"" + s1.substring(0, i) + "\", \"" + s2.substring(0, j) + "\", \"" + s3.substring(0, i+j) + "\"");
				if (i > 0) {
					char letterS1 = s1Array[i - 1];
					char letterS3 = s3Array[i + j - 1];
					dp[i][j] |= (letterS1 == letterS3 && dp[i - 1][j]);
				}
				if (j > 0) {
					char letterS2 = s2Array[j - 1];
					char letterS3 = s3Array[i + j - 1];
					dp[i][j] |= (letterS2 == letterS3 && dp[i][j - 1]);
				}
				//System.out.println("Result is: " + dp[i][j]);
			}
		}
		return dp[len1][len2];
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
		System.out.print(s3 + " is ");
		System.out.print(solution.isInterleave(s1, s2, s3) ? "" : "not ");
		System.out.println("the interleaving of " + s1 + " and " + s2);
	}
}
