import java.util.*;
public class Solution {
	public int sumNumbers(TreeNode root) {
		return sumNumbers(root, 0);
	}
	private int sumNumbers(TreeNode root, int sum) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return sum * 10 + root.val;
		return sumNumbers(root.left, sum * 10 + root.val) + sumNumbers(root.right, sum * 10 + root.val);
	}
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; left = null; right = null; }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(solution.sumNumbers(root));
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
