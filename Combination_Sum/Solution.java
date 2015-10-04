import java.util.*;
public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0)
			return result;
		Arrays.sort(candidates);
		helper(candidates, target, 0, new ArrayList<Integer>(), result);
		return result;
	}
	private void helper(int[] candidates, int target, int start, List<Integer> item, List<List<Integer>> result) {
			if (target < 0)
				return;
			if (target == 0) {
				result.add(new ArrayList<Integer> (item));  //Create a deep copy of item then add to result
				return;
			}

			for (int i = start; i < candidates.length; i++) {
				if (i + 1 < candidates.length && candidates[i] == candidates[i + 1])
					continue;  //Ignore duplicates entry
				item.add(candidates[i]);  //Try to add current number to combination
				helper(candidates, target - candidates[i], i, item, result);  //Recursively looking for valid combination
				item.remove(item.size() - 1);  //Backtracking to the state before recursive call
			}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] candidates = {2, 3, 2, 6, 7};
		int target = 7;
		List<List<Integer>> result = solution.combinationSum(candidates, target);
		System.out.println(result);
	}
}
