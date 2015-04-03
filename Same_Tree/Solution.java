//O(N)
public class Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == q)		//Both refer to same node or Both are null.
			return true;
		else if (p == null || q == null || p.val != q.val)
			return false;
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(2);
		root1.left.left = new TreeNode(3);
		root1.left.right = new TreeNode(4);
		root1.right.left = new TreeNode(4);
		root1.right.right = new TreeNode(3);

		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(2);
		root2.left.left = new TreeNode(3);
		root2.left.right = new TreeNode(4);
		root2.right.left = new TreeNode(4);
		root2.right.right = new TreeNode(3);

		System.out.println(solution.isSameTree(root1, root2));
	}
}
