import java.util.*;
public class Solution {
	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (S == null || S.length == 0)
			return result;
		Arrays.sort(S);

		//Using bit i of current binaryCounter to decide whether add S[i] to current subsets
		int binaryCounter = 0;
		//The limit of binaryCounter is (2^S.length - 1)
		while (binaryCounter < (1 << S.length)) {
			List<Integer> newElem = new ArrayList<Integer>();
			//For each binaryCounter value, check each bit and get current subset combination
			for (int i = 0; i < S.length; i++) {
				if (((binaryCounter >> i) & 1) > 0)
					newElem.add(S[i]);
			}
			result.add(newElem);
			binaryCounter++;
		}
		return result;
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
