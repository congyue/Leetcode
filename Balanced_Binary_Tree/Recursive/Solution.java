//O(NlogN)
public class Solution {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;

		int left = depth(root.left);
		int right = depth(root.right);
		return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}

	private int depth(TreeNode root) {
		if (root == null)
			return 0;
		else
			return 1 + Math.max(depth(root.left), depth(root.right));
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
		//root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		//root.right.left = new TreeNode(6);
		//root.right.right = new TreeNode(7);

		System.out.println(solution.isBalanced(root));
	}
}
