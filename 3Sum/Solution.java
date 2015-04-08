import java.util.*;
public class Solution {
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (num == null || num.length < 3)
			return result;

		int len = num.length;
		Arrays.sort(num);
		for (int i = 0; i < len - 2 && num[i] <= 0; i++) {
			int j = i + 1, k = len - 1;
			while(j < k) {
				int sum = num[i] + num[j] + num[k];
				if (sum == 0) {
					result.add(Arrays.asList(num[i], num[j], num[k]));
					while (j < k && num[j] == num[j + 1]) j++; //Skipping duplicate j and k
					while (j < k && num[k] == num[j - 1]) k--;
					j++;
					k--;
				}
				else if (sum > 0)
					k--;
				else
					j++;
			}
			while (i < len - 2 && num[i] == num[i + 1]) i++; //Skipping dulicate i
		}
		return result;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] num = {0, 0, 0};
		System.out.println(solution.threeSum(num));
	}
}
