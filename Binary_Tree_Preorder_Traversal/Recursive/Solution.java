import java.util.*;
public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<Integer>();
		preorderTraversal(root, result);
		return result;
	}
	private void preorderTraversal(TreeNode root, List<Integer> result) {
		if (root == null)
			return;
		result.add(root.val);
		preorderTraversal(root.left, result);
		preorderTraversal(root.right, result);
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
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		System.out.println(solution.preorderTraversal(root));
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
