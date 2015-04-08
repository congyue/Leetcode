import java.util.*;
public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length < 2)
			return null;

		int len = numbers.length;
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < len; i++) {
			if (map.containsKey(numbers[i])) {
				result[0] = map.get(numbers[i]) + 1;
				result[1] = i + 1;
				return result;
			}
			map.put(target - numbers[i], i);
		}
		return null;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] numbers = {2, 7, 11, 15};
		int target = 9;
		for (int i : solution.twoSum(numbers, target))
			System.out.println(i);
	}
}
