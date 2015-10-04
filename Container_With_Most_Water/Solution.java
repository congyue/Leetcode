public class Solution {
	public int maxArea(int[] height) {
		if (height == null || height.length < 2)
			return 0;

		int low = 0, high = height.length - 1;
		int result = 0;
		while(low < high) {
			result = Math.max(result, (high - low) * Math.min(height[low], height[high]));  //Update result
			if (height[low] < height[high])
				low++;
			else
				high--;
		}
		return result;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] height = {4, 2, 3, 5, 7, 4, 2, 8, 1, 1};
		System.out.println(solution.maxArea(height));
	}
}
