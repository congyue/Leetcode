public class Solution {
	public int climbStairs(int n) {
		if (n == 0)
			return 0;
		if (n < 2)
			return 1;

		int[] dp = new int[n + 1]; //It's better to reduce size to int[3]
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < n + 1; i++)
			dp[i] = dp[i - 1] + dp[i - 2]; //It's better to replace dp[f(i)] to dp [f(i) % 3]

		return dp[n];
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 10;
		System.out.println(solution.climbStairs(n));
	}
}
