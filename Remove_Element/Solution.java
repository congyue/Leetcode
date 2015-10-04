public class Solution {
	public int removeElement(int[] A, int elem) {
		if (A == null)
			return 0;
		int lastIndex = A.length - 1;
		for (int i = 0; i <= lastIndex; i++) {
			if (A[i] == elem)
				A[i--] = A[lastIndex--];
		}
		return lastIndex + 1;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {4, 5, 3, 1, 1, 7, 8, 9, 6, 1, 3, 5};
		int elem = 1;
		System.out.println(solution.removeElement(A, elem));
	}
}
