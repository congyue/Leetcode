import java.util.*;
public class Solution {
	public void flatten(TreeNode root) {
		if (root == null)
			return;

		TreeNode left = root.left;
		TreeNode right = root.right;
		root.left = null;

		flatten(left);
		flatten(right);

		root.right = left;
		TreeNode cur = root;
		while(cur.right != null)
			cur = cur.right;
		cur.right = right;
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
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);
		solution.flatten(root);
		while(root != null) {
			System.out.print(root.val + ", ");
			root = root.right;
		}
		System.out.println();
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
