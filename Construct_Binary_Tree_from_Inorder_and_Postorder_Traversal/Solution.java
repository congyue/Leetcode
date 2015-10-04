import java.util.*;
public class Solution {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null)
			return null;
		HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
		for(int i = 0; i < inorder.length; i++) {
			inorderMap.put(inorder[i], i);	//Look up table for inorder elements index
		}
		return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inorderMap);
	}

	private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd, HashMap<Integer, Integer> inorderMap) {
		if (inStart > inEnd || poStart > poEnd)
			return null;
		TreeNode root = new TreeNode(postorder[poEnd]);
		int index = inorderMap.get(root.val);
		root.left = helper(inorder, inStart, index - 1, postorder, poStart, poStart + index - inStart - 1, inorderMap);
		root.right = helper(inorder, index + 1, inEnd, postorder, poStart + index - inStart, poEnd - 1, inorderMap);
		return root;
	}
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; left = null; right = null; }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] inorder = {4, 2, 5, 1, 6, 8, 3, 7};
		int[] postorder = {4, 5, 2, 8, 6, 7, 3, 1};
		List<String> result = serialized(solution.buildTree(inorder, postorder));
		System.out.println(result);
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
