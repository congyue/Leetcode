import java.util.*;
public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		TreeNode cur = root;
		TreeNode pre = null;
		while(cur != null) {
			if (cur.left == null) {  //When no left child available, add cur to result
				result.add(cur.val);
				cur = cur.right;  //cur.right would point to in-order successor or null(when complete)
			}
			else {
				pre = cur.left;
				while (pre.right != null && pre.right != cur)
					pre = pre.right;  //Get in-order predecessor of cur

				if (pre.right == null) { //Return path not exist (First time access Cur)
					result.add(cur.val);  //Add Cur to result
					pre.right = cur;  //Create return path: pre.right -> Cur
					cur = cur.left;  //Start explore left branch
				}
				else {  //Return path pre.right -> cur detected (Second time access Cur, just come back from Pre)
					pre.right = null;  //Erase the return path
					cur = cur.right;
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
