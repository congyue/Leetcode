//O(N)
import java.util.*;
public class Solution {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode left = root.left;
		TreeNode right = root.right;
		stack.push(left);
		stack.push(right);
		while(!stack.isEmpty()) {
			right = stack.pop();
			left = stack.pop();
			if (left == null && right == null)	//Both nodes are null
				continue;
			else if (left == null || right == null)	//One of node is null
				return false;

			if (left.val != right.val)	//Two nodes are different
				return false;

			stack.push(left.left);
			stack.push(right.right);
			stack.push(left.right);
			stack.push(right.left);
		}
		return true;
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
