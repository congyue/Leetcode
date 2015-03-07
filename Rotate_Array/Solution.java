public class Solution {
	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length <= 1)
			return;

		k %= nums.length; //Make rotation steps k is within 1 cycle
		//3-step rotation. If we need arr1arr2 -> arr2arr1, then
		//1. Array = arr1'arr2
		//2. Array = arr1'arr2'
		//3. Array = (arr1'arr2')' = arr2arr1
		reverse(nums, 0, nums.length - k - 1);
		reverse(nums, nums.length - k, nums.length - 1);
		reverse(nums, 0, nums.length - 1);
	}

	public void reverse(int[] nums, int start, int end) {
		while(start < end) {
			int temp = nums[start];
			nums[start++] = nums[end];
			nums[end--] = temp;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		int k = 3;
		solution.rotate(nums, k);
		for (int i : nums)
			System.out.print(i + ", ");
		System.out.println();
	}
}
