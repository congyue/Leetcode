import java.util.*;
public class Solution {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<Integer>();
		if (rowIndex < 0)
			return result;
		
		result.add(1);	//Initialize row[0]
		for (int i = 1; i <= rowIndex; i++) {  //Process row[i], which has length of i + 1
			for (int j = i - 1; j > 0; j--)  //Traverse backwards and update value from index 1 ~ i - 1
				result.set(j, result.get(j - 1) + result.get(j));  //get new value in j by adding old value in j and j - 1
			result.add(1);  //Append postfix 1
		}
		return result;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int rowIndex = 5;
		System.out.println(solution.getRow(rowIndex));
	}
}
