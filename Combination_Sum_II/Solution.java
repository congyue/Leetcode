import java.util.*;
public class Solution {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
				if (i > start && candidates[i] == candidates[i - 1])
					continue;  //When there are duplicated entries, only choose first one as starting point
				item.add(candidates[i]);  //Try to add current number to combination
				helper(candidates, target - candidates[i], i + 1, item, result);  //Recursively looking for valid combination
				item.remove(item.size() - 1);  //Backtracking to the state before recursive call
			}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] candidates = {10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		List<List<Integer>> result = solution.combinationSum2(candidates, target);
		System.out.println(result);
	}
}
