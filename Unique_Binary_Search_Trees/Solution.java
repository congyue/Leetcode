public class Solution {
	public int numTrees(int n) {
		int[] dp = new int[n + 1]; // dp[i]: number of binary search trees with i nodes
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < n + 1; i ++)
			for (int j = 0; j < i; j++)	//Number of left nodes j = root - 1, while root from 1 ~ i
				dp[i] += dp[j] * dp[i - j - 1];

		return dp[n];
	}
	public static void main (String[] args) {
		Solution solution = new Solution();
		int n = 4;
		System.out.println(solution.numTrees(n));
	}
}
