public class Solution {
	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Arrays.sort(S);
		result.add(new ArrayList<Integer>());
		for(int list : S) {
			int len = result.size();
			for(int i = 0; i < len; i++) {
				List<Integer> newElem = new ArrayList<Integer>(result.get(i));
				newElem.add(list);
				result.add(newElem);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] S = {1,2,3};
		List<List<Integer>> result = solution.subsets(S);
		System.out.println("[");
		for (List<Integer> elem : result)
			System.out.println("    " + elem);
		System.out.println("]");
	}
}
