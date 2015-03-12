public class Solution {
	public void merge(int A[], int m, int B[], int n) {
		if (n < 1)
			return;

		int i = m - 1;
		int j = n - 1;
		int index = m + n - 1;

		while(i >= 0 && j >= 0) {
			A[index] = (A[i] <= B[j] ? B[j--] : A[i--]);
			index--;
		}

		while(j >= 0)
			A[index--] = B[j--];
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {24, 56, 91, 128, 0, 0, 0 , 0, 0};
		int[] B = {3, 44, 74, 77, 108};
		int m = 4, n = 5;
		solution.merge(A, m, B, n);
		for (int i : A)
			System.out.print(i + ", ");
		System.out.println();
	}
}
