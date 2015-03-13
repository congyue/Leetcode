import java.util.*;
public class Solution {
	public String largestNumber(int[] num) {
		if (num == null || num.length < 1)
			return "";

		String[] numStr = new String[num.length]; //Convert input to String array
		for (int i = 0; i < num.length; i++)
			numStr[i] = num[i] + "";

		Comparator<String> comp = new Comparator<String>() { //Customized comparator
			@Override
			public int compare(String str1, String str2) {
				String s1 = str1 + str2;
				String s2 = str2 + str1;
				return s2.compareTo(s1); //Used to generate decending order
			}
		};

		Arrays.sort(numStr, comp); //Sort array to descending order
		if (numStr[0].charAt(0) == '0') //If sorted array starts with '0', then it must be all 0.
			return "0";

		StringBuilder result = new StringBuilder();
		for (String s : numStr)
			result.append(s);

		return result.toString();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] num = {3, 30, 34, 5, 9};
		System.out.println("Largest number is: " + solution.largestNumber(num));
	}
}
