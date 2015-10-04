import java.util.*;
public class Solution {
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	public boolean isValidBST(TreeNode root, long min, long max) {
		if (root == null)
			return true;
		if (root.val <= min || root.val >= max)
			return false;
		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
	}
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; left = null; right = null; }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.right = new TreeNode(10);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(12);
		System.out.println(solution.isValidBST(root));
	}
	public static List<String> serialized(TreeNode t) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<String> result = new ArrayList<String>();

		queue.add(t);
		while(!queue.isEmpty()) {
			TreeNode newNode = queue.remove();
			if (newNode != null)
				result.add(Integer.toString(newNode.val));
			else {
				result.add("#");
				continue;
			}
			queue.add(newNode.left);
			queue.add(newNode.right);
		}
		return result;
	}
}
