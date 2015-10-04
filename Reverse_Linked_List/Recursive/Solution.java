public class Solution {
	public ListNode reverseList(ListNode head) {
		return helper(head, null);
	}
	private ListNode helper(ListNode head, ListNode newHead) {
		if (head == null)
			return newHead;
		ListNode next = head.next;
		head.next = newHead;
		return helper(next, head);
	}
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode result = solution.reverseList(head);
		while(result.next != null) {
			System.out.print(result.val + " -> ");
			result = result.next;
		}
		System.out.println(result.val);
	}
}
