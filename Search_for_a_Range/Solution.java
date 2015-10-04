public class Solution {
	public int[] searchRange(int[] nums, int target) {
		int[] result = {-1, -1};
		if (nums == null || nums.length == 0)
			return result;
		
		int start = firstGreaterEqual(nums, target);
		if (start == nums.length || nums[start] != target)
			return result;
		
		result[0] = start;
		result[1] = firstGreaterEqual(nums, target + 1) - 1;
		return result;
	}
	private int firstGreaterEqual(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < target) {
				start = mid + 1;  //number less than target won't be result, jump over
			}
			else {  //number equal or greater than target may be result, update end index to mid, cannot jump over
				end = mid - 1;
			}
		}
		return start;  //Return when start == end
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1, 1, 2};
		int target = 1;
		int[] result = solution.searchRange(nums, target);
		System.out.println("[" + result[0] + ", " + result[1] + "]");
	}
}
