// f[k, ii] represents the max profit up until prices[ii] (Note: NOT ending with prices[ii]) using at most k transactions. 
// f[k, ii] = max(f[k, ii-1], prices[ii] - prices[jj] + f[k-1, jj]) { jj in range of [0, ii-1] }
//          = max(f[k, ii-1], prices[ii] + max(f[k-1, jj] - prices[jj]))
//			= max(f[k, ii-1], prices[ii] + tmpMax)
// Thus, need to maintain int tmpMax = max(f(f[k-1], jj) - prices[jj])
// f[0, ii] = 0; 0 times transation makes 0 profit
// f[k, 0] = 0; if there is only one price data point you can't make any money no matter how many times you can trade
public class Solution {
	public int maxProfit(int k, int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;

		int len = prices.length;
		if (k >= len)
			return quickSolve(prices);

		int[][] dp = new int[k + 1][len];
		for (int kk = 1; kk < k + 1; kk++) {
			int tmpMax = dp[kk - 1][0] - prices[0];
			for (int ii = 1; ii < len; ii++) {
				dp[kk][ii] = Math.max(dp[kk][ii - 1], prices[ii] + tmpMax);
				tmpMax = Math.max(tmpMax, dp[kk - 1][ii] - prices[ii]);
			}
		}
		return dp[k][len - 1];
	}

	private int quickSolve(int[] prices) {
		int len = prices.length, profit = 0;
		for (int i = 1; i < len; i++)
			// as long as there is a price gap, we gain a profit.
			if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
		return profit;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] prices = {20, 18, 15, 17, 19, 14, 16, 21, 30, 27};
		System.out.println(solution.maxProfit(3, prices));
	}
}
