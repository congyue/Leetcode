public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		ListNode pre = head;
		ListNode cur = head.next;
		while(cur != null) {
			if (pre.val == cur.val) {
				pre.next = cur.next;  //If cur is a dup, then delete cur (jump over)
			}
			else {
				pre = cur;  //If cur is different, then add to result
			}
			cur = cur.next;
		}
		return head;
	}
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		ListNode result = solution.deleteDuplicates(head);
		while(result.next != null) {
			System.out.print(result.val + " -> ");
			result = result.next;
		}
		System.out.println(result.val);
	}
}
