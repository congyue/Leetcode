//O(N)
public class Solution {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;

		return isSymmetric(root.left, root.right);
	}

	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null || right == null)
			return left == right;

		if (left.val == right.val) {
			boolean outerPair = isSymmetric(left.left, right.right);
			boolean innerPair = isSymmetric(left.right, right.left);
			return outerPair && innerPair;
		}
		else
			return false;
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);

		System.out.println(solution.isSymmetric(root));
	}
}
