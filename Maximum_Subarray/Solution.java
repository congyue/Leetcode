public class Solution {
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int globalMax = nums[0];  //Max continuous sum value we can get so far 
		int localMax = nums[0];   //Max sum value we can get with current element
		for (int i = 1; i < nums.length; i++) {
			localMax = Math.max(localMax + nums[i], nums[i]);  //Compare which one is larger: nums[i] + previous max sum or nums[i] along
			globalMax = Math.max(globalMax, localMax);
		}
		return globalMax;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(solution.maxSubArray(nums));
	}
}
