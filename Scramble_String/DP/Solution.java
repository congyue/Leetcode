import java.util.*;
public class Solution {
	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		if (s1.equals(s2))
			return true;

		//Verify if two string consist of same set of letters
		int len = s1.length();
		int[] alphabet = new int[26];
		for (int i = 0; i < len; i++) {
			alphabet[s1.charAt(i) - 'a']++;
			alphabet[s2.charAt(i) - 'a']--;
		}
		for (int i = 0; i < 26; i++)
			if (alphabet[i] != 0)
				return false;

		//dp[n][i][j]:
		//For a string start from s1[i], with length of n;
		//And another string start from s2[j], with length of n;
		//Whether they are scramble strings or not.
		boolean[][][] dp = new boolean[len+1][len][len];

		//Base case, set n=1, if two letters from s1[i] and s2[j] are equal, these substrings are scamble strings to each other
		for (int i = 0; i < len; i++)
			for (int j = 0; j < len; j++)
				if (s1.charAt(i) == s2.charAt(j))
					dp[1][i][j] = true;

		//DP process, for each combination, calculate dp[n][i][j], e.g. "eat" and "tae"
		for (int n = 2; n <= len; n++) {
			for (int i = 0; i + n - 1 < len; i++)
				for (int j = 0; j + n - 1 < len; j++) {
					for (int breakPoint = 1; breakPoint < n; breakPoint++) {
						//Set same breakPoint and compare each part of strings
						//e.g. compare "e" and "t", "at" and "ae.
						if (dp[breakPoint][i][j] && dp[n-breakPoint][breakPoint+i][breakPoint+j]) {
							dp[n][i][j] = true;
							break;
						}

						//Set breakPoint at s1 and symmetrical breakPoint at s2, then compare, to simulate swap condition
						//e.g. compare "e" and "e", "at" and "ae".
						if (dp[breakPoint][i][n-breakPoint+j] && dp[n-breakPoint][breakPoint+i][j]){
							dp[n][i][j] = true;
							break;
						}
					}
					/*
					System.out.print("(" + n + ", " + i + ", " + j + "): ");
					System.out.println(s1.substring(i, i+n) + " and " + s2.substring(j, j+n) + " are scramble? : " + dp[n][i][j]);*/
				}
		}
		return dp[len][0][0];
	}

	public static void main(String[] args) {
		String s1 = "great";
		String s2 = "rgtae";
		Solution solution = new Solution();
		boolean result = solution.isScramble(s1, s2);

		System.out.print(s1 + " and " + s2 + " are ");
		if (!result)
			System.out.print("not ");
		System.out.println("Scramble Strings to each other.");
	}
}
