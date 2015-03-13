public class Solution {
	public void sortColors(int[] A) {
		if (A == null || A.length < 2)
			return;

		int red = 0, blue = A.length - 1, i = 0;
		while (i <= blue) {
			if (A[i] == 0) {
				A[i++] = A[red]; //If found 0, swap(A[red], A[i]) and increase both red and i.
				A[red++] = 0;
			}
			else if (A[i] == 2) {
				A[i] = A[blue]; //If found 2, swap(A[blue, A[i]]) and only decrease blue.
				A[blue--] = 2;
			}
			else
				i++;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {2, 0, 1, 1, 2, 0, 2, 1, 0};
		solution.sortColors(A);
		for (int i : A)
			System.out.print(i + ", ");
		System.out.println();
	}
}
