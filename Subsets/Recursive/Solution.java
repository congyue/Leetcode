import java.util.*;
public class Solution {
	public List<List<Integer>> subsets(int[] S) {
		if (S == null || S.length == 0)
			return new LinkedList<List<Integer>>();
		Arrays.sort(S);
		return subsetsHelper(S);
	}

	public List<List<Integer>> subsetsHelper(int[] S) {
		if (S.length == 0) {
			List<List<Integer>> result = new LinkedList<List<Integer>>();
			result.add(new ArrayList<Integer>());
			return result;
		}
		else {
			List<List<Integer>> result = subsetsHelper(Arrays.copyOfRange(S, 0, S.length - 1));
			int len = result.size();
			for (int i = 0; i < len; i++) {
				List<Integer> newElem = new ArrayList<Integer>(result.get(i));
				newElem.add(S[S.length - 1]);
				result.add(newElem);
			}
			return result;
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] S = {1,2,3};
		List<List<Integer>> result = solution.subsets(S);
		System.out.println("[");
		for (List<Integer> elem : result)
			System.out.println("	" + elem);
		System.out.println("]");
	}
}
