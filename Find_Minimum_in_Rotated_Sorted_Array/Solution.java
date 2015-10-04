public class Solution {
	public int findMin(int[] nums) {
		if (nums == null)
			return -1;
		int l = 0, r = nums.length - 1;
		int result = nums[0];
		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[l] <= nums[mid]) {
				result = Math.min(result, nums[l]);
				l = mid + 1;
			}
			else if (nums[mid] < nums[r]) {
				result = Math.min(result, nums[mid]);
				r = mid - 1;
			}
		}
		return result;
	}
	public static void main (String[] args) {
		Solution solution = new Solution();
		int[] nums = {2, 1};
		System.out.println(solution.findMin(nums));
	}
}
