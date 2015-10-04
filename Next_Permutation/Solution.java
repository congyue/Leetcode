public class Solution {
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0)
			return;

		int index1 = nums.length - 2;
		while (index1 >= 0 && nums[index1] >= nums[index1 + 1]) {
			index1--;
		}
		if (index1 >= 0) {
			int index2 = index1 + 1;
			while(index2 < nums.length && nums[index2] > nums[index1])
				index2++;
			index2--;
			swap(nums, index1, index2);
		}
		reverse(nums, index1 + 1, nums.length - 1);
	}
	private void swap(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}
	private void reverse(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		//Start from last number to left, find first disorder number: 3 -> index1
		//Start from 3 to right, find last number larger than 3 which is: 4 -> index2
		//Swap 3 and 4 -> swap(nums, index1, index2)
		//Reverse (Sort) subarray at right side of 4: [6, 5, 3, 1] to [1, 3, 5, 6] -> reverse(nums, index1 + 1, nums.length - 1 )
		int[] nums = {2, 3, 6, 5, 4, 1};
		solution.nextPermutation(nums);
		for (int i : nums)
			System.out.print(i + ", ");
		System.out.println();
	}
}
