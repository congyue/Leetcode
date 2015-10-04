public class Solution {
	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		
		int index = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] != A[i - 1])
				A[index++] = A[i];
		}
		return index;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {2, 3, 3, 3, 5, 7, 7, 8, 9};
		System.out.println(solution.removeDuplicates(A));
		for (int i : A)
			System.out.print(i + ", ");
		System.out.println();
	}
}
