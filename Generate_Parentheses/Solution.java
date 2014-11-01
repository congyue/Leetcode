import java.util.*;
class Solution {

	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		StringBuilder combination = new StringBuilder();
		getCombination(n, 0, "", result);
		return result;
	}
	//n: How many "(" left currently
	//unpair: How many ")" needed currently
	public void getCombination(int n, int unpair, String combination, List<String> result) {

		//Get a complete combination when no "(" left and no ")" needed
		if (n <= 0 && unpair == 0) {
			result.add(combination);
			return;
		}

		//If n > 0, append "(" and do recursive call
		if (n > 0)
			getCombination(n - 1, unpair + 1, combination + "(", result);

		//If unpair > 0, append ")" and do recursive call
		if (unpair > 0)
			getCombination(n, unpair - 1, combination + ")", result);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		for (String combination :solution.generateParenthesis(3))
			System.out.println(combination);
	}
}
