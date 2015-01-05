public class Solution {
	public int singleNumber(int[] A) {
		if (A == null || A.length < 1)
			return -1;
		int result = 0;
		//Using XOR to eliminate duplicate items
		//e.g. 0 ^ A ^ B ^ C ^ B ^ A = C
		for (int i = 0; i < A.length; i++)
			result ^= A[i];
		return result;
	}
	public static void main(String[] args) {
		int[] A = {23,56,87,23,65,56,99,87,99};
		Solution solution = new Solution();
		System.out.print("The single number in Array [");
		for (int i : A)
			System.out.print(i + ", ");
		System.out.println("] is " + solution.singleNumber(A));
	}
}
