public class Solution {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0 || s < 0)
			return 0;

		int start = 0, end = 0, sum = 0, result = Integer.MAX_VALUE;
		while (end < nums.length) {  //end++ in each outer loop
			sum += nums[end]; //Add new number to result

			while(sum >= s) {  //start++ in each inner loop
				result = Math.min(result, end - start + 1);  //Update result	
				sum -= nums[start];  //Try to shrink window
				start++;
			}
			end++;
		}
		return result == Integer.MAX_VALUE ? 0 : result;  //Check result valid or not
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {2, 3, 1, 2, 4, 3};
		int s = 7;
		System.out.println(solution.minSubArrayLen(s, nums));
	}
}
