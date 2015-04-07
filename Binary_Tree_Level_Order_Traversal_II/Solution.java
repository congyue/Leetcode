import java.util.*;
public class Solution {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (root == null)
			return result;

		List<Integer> elem = new LinkedList<Integer>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int nodeAdded = 0, nodeLeft = 1;
		while(!queue.isEmpty()) {
			TreeNode nextNode = queue.remove();	//Get nextNode
			elem.add(nextNode.val);				//Add to this layer's result
			nodeLeft--;

			if (nextNode.left != null) {			//Add children nodes to queue
				queue.add(nextNode.left);
				nodeAdded++;
			}

			if (nextNode.right != null) {
				queue.add(nextNode.right);
				nodeAdded++;
			}

			if (nodeLeft == 0) {				//Nodes of this layer are ready to add to result
				result.add(0,elem);
				elem = new LinkedList<Integer>(); //Reset variables
				nodeLeft = nodeAdded;
				nodeAdded = 0;
			}
		}
		return result;
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(9);
		root1.right = new TreeNode(20);
		root1.right.left = new TreeNode(19);
		root1.right.right = new TreeNode(7);

		System.out.println(solution.levelOrderBottom(root1));
	}
}
