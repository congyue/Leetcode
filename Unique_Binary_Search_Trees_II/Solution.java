import java.util.*;
public class Solution {
	public List<TreeNode> generateTrees(int n) {
		return generateTrees(1, n);
	}
	private List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> result = new LinkedList<TreeNode>();
		if(start > end) {
			result.add(null);
			return result;
		}

		for (int root = start; root <= end; root++) {
			List<TreeNode> leftTrees = generateTrees(start, root - 1);
			List<TreeNode> rightTrees = generateTrees(root + 1, end);
			
			for (TreeNode leftNode : leftTrees) {
				for (TreeNode rightNode : rightTrees) {
					TreeNode rootNode = new TreeNode(root);
					rootNode.left = leftNode;
					rootNode.right = rightNode;
					result.add(rootNode);
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
		int n = 3;
		for (TreeNode t : solution.generateTrees(n))
			System.out.println(serialized(t));
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
