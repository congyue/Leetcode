import java.util.*;
public class Solution {  //Bottom-up solution
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return -1;
		int[] dp = new int[triangle.size()];
		for (int i = 0; i < triangle.size(); i++) {  //Initialize dp[] with numbers at bottom
			dp[i] = triangle.get(triangle.size() - 1).get(i);
		}
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {  //The length of triangle[i] must be i + 1
				dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);  //In-place update dp[]
			}
		}
		return dp[0];
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3, 4));
		triangle.add(Arrays.asList(6, 5, 7));
		triangle.add(Arrays.asList(4, 1, 8, 3));
		System.out.println(solution.minimumTotal(triangle));
	}
}
