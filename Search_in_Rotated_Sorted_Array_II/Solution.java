public class Solution {
	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return false;
		}

		int l = 0, r = nums.length - 1;
		while (l <= r) {    //Regular binary search
			int mid = (l + r) / 2;
			System.out.println("mid = " + mid);
			if (nums[mid] == target)  //If found target, return true
				return true;
			else if (nums[mid] < nums[l]) {  //If left unordered, means right side is in order, try to find target in which half
				if (target <= nums[r] && target > nums[mid])
					l = mid + 1;
				else
					r = mid - 1;
			}
			else if (nums[mid] > nums[l]) {  //If left side ordered, try to find target in which half
				if (target < nums[mid] && target >= nums[l])
					r = mid - 1;
				else
					l = mid + 1;
			}
			else  //If nums[l] == nums[mid] == nums[r], no clue from current loop. Let l++ until different digit is found
				l++;
		}
		return false;
	}
	public static void main (String[] args) {
		Solution solution = new Solution();
		int[] nums = {3, 1, 1};
		int target = 3;
		System.out.println(solution.search(nums, target));
	}
}
