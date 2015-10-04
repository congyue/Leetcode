public class Solution {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int l = 0, r = nums.length - 1;
		while (l <= r) {    //Regular binary search
			int mid = (l + r) / 2;
			if (nums[mid] == target)  //Return if found target
				return mid;
			else if (nums[mid] < nums[r]) {  //Check if right part is sorted
				if (target > nums[mid] && target <= nums[r])  //Check if target in right range
					l = mid + 1;
				else
					r = mid - 1;
			}
			else {  //Check if left part is sorted
				if (target >= nums[l] && target < nums[mid])  //Check if target in left range
					r = mid - 1;
				else
					l = mid + 1;
			}
		}
		return -1;
	}
	public static void main (String[] args) {
		Solution solution = new Solution();
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		int target = 1;
		System.out.println(solution.search(nums, target));
	}
}
