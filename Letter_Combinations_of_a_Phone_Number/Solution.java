import java.util.*;
class Solution {
	String[] digit2letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		//StringBuilder variable used to store current letter combination
		StringBuilder combination = new StringBuilder();
		getAllCombination(digits, 0, combination, result);
		return result;
	}

	public void getAllCombination(String digits, int index, StringBuilder combination, List<String> result) {
		//If index out of bound of digits string, then record current combination and return;
		if(index >= digits.length()) {
			result.add(combination.toString());
			return;
		}

		//Get possible letters for current digit
		char[] letters = digit2letters[digits.charAt(index) - '0'].toCharArray();

		//Get each letter for possible letters
		for(char c : letters) {
			//Append current letter to current combination
			combination.append(c);
			//Do recursive call to do same thing for digit at index+1
			getAllCombination(digits, index + 1, combination, result);
			//Backtracking, delete last letter and replace to another one in next loop
			combination.deleteCharAt(combination.length() - 1);
		}
		return;
	}
	public static void main(String[] args) {
		String digits = "23";
		Solution solution = new Solution();
		List<String> result = solution.letterCombinations(digits);
		System.out.println("Digit string is: " + digits);
		System.out.println("Combinations: " + result);
	}
}
