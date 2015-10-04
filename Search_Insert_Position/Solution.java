public class Solution {
	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return 0;
		int start = 0, end = nums.length - 1;
		while(start <= end) {  //This Binary search only for arrays without duplicates
			int mid = (start + end) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < target) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		//If not found, start will points to element larger than target
		//End will points to element smaller than target
		return start;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1, 3, 5, 6};
		int target = 2;
		System.out.println(solution.searchInsert(nums, target));
	}
}
