import java.util.*;
public class Solution {
	public int threeSumClosest(int[] num, int target) {
		if (num == null || num.length < 3)
			throw new IllegalArgumentException("num[] must have at least 3 elements.");

		int len = num.length;
		int diff = Integer.MAX_VALUE;
		int result = 0;
		Arrays.sort(num);
		for(int i = 0; i < len - 2; i ++) {
			int j = i + 1, k = len - 1;
			while(j < k) {
				int sum = num[i] + num[j] + num[k];
				int localDiff = Math.abs(target - sum);

				if (localDiff < diff) {
					diff = localDiff;
					result = sum;
				}

				if (sum == target)
					return result;
				else if (sum < target)
					j++;
				else
					k--;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] num = {-1, 2, 1, -4};
		System.out.println(solution.threeSumClosest(num, 1));
	}
}
