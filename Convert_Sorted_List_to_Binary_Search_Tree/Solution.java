import java.util.*;
public class Solution {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		ListNode cur = head;
		int count = 0;
		while (cur.next != null) {  //Get the length of the list
			cur = cur.next;
			count++;
		}
		List<ListNode> list = new ArrayList<ListNode>();
		list.add(head);  //Create a container of ListNode to "pass by reference"
		return sortedListToBST(list, 0, count);
	}
	private TreeNode sortedListToBST(List<ListNode> list, int l, int r) {
		if (l > r)
			return null;
		int mid = (l + r) / 2;
		TreeNode left = sortedListToBST(list, l, mid - 1);
		TreeNode root = new TreeNode(list.get(0).val);
		list.set(0, list.get(0).next);
		TreeNode right = sortedListToBST(list, mid + 1, r);
		root.left = left;
		root.right = right;
		return root;
	}
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; left = null; right = null; }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		List<String> result = serialized(solution.sortedListToBST(head));
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
