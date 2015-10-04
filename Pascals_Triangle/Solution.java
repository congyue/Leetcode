import java.util.*;
public class Solution {
	public List<List<Integer>> generate(int numRows) {
		if (numRows < 1)
			return new ArrayList<List<Integer>>();
		List<List<Integer>> result = new ArrayList<List<Integer>>(numRows);
		List<Integer> lastElem = new ArrayList<Integer>(1);
		lastElem.add(1); //Manually create first line, and point lastElem to it.
		result.add(lastElem);
		for (int i = 2; i <= numRows; i++) { //Processing second line and more
			List<Integer> elem = new ArrayList<Integer>(i);
			elem.add(1);  //First digit is always 1
			for (int j = 1; j < i - 1; j++) {  //Middle digits calculated by lastElem
				elem.add(lastElem.get(j - 1) + lastElem.get(j));
			}
			elem.add(1);  //Last digit is always 1
			result.add(elem);
			lastElem = elem;  //Update lastElem
		}
		return result;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int numRows = 5;
		System.out.println(solution.generate(numRows));
	}
}
