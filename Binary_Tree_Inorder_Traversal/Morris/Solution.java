import java.util.*;
public class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		TreeNode cur = root;
		TreeNode pre = null;
		while (cur != null) {  //cur will only be null when traversal complete
			if (cur.left == null) {  //If no left child, directly add cur to result and explore right branch
				result.add(cur.val);
				cur = cur.right;
			}
			else {
				pre = cur.left;  //Start finding in-order predecessor of root
				while (pre.right != null && pre.right != cur)
					pre = pre.right;

				if (pre.right == null) {  //Return path not exist (First time access cur)
					pre.right = cur;  //Create return path
					cur = cur.left;  //Start to explore left branch
				}
				else {  //Return path pre -> cur exist (Second time access cur, just come back from pre)
					result.add(cur.val);  //Add cur to result
					pre.right = null;  //Erase the return path
					cur = cur.right;  //Start to explore right branch
				}
			}
		}
		return result;

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
		System.out.println(solution.inorderTraversal(root));
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
