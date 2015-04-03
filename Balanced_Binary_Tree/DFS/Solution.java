//O(N)
public class Solution {
	public boolean isBalanced(TreeNode root) {
		return getBalancedHeight(root) != -1;
	}

	//If the tree is balanced, return height
	//Otherwise, return -1
	private int getBalancedHeight(TreeNode root) {
		if (root == null)
			return 0;

		//left sub tree not balanced
		int leftHeight = getBalancedHeight(root.left);
		if (leftHeight == -1) return -1;

		//right sub tree not balanced
		int rightHeight = getBalancedHeight(root.right);
		if (rightHeight == -1) return -1;

		//current tree not balanced
		if (Math.abs(leftHeight - rightHeight) > 1)
			return -1;

		return Math.max(leftHeight, rightHeight) + 1;

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
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println(solution.isBalanced(root));
	}
}
