public class Solution {
	//Majority vote algorithm
	public int majorityElement(int[] num) {
		int result = 0, counter = 0;
		if (num == null || num.length < 1)
			return 0;
		for (int i : num) {
			if (counter == 0) {
				result = i;
				counter++;
			}
			else {
				if (i == result)
					counter ++;
				else
					counter --;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] num = {3,1,2,3,3,3,2,5,7,1,3,9,3,3};
		Solution solution = new Solution();
		System.out.print("The majority element of [");
		for (int i : num)
			System.out.print(i + ", ");
		System.out.println("] is " + solution.majorityElement(num));
	}
}
