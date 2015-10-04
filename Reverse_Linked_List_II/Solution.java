//  1 -> 2 -> 3 -> 4 -> 5 -> NULL
// pre   m         n   next
//
// In each iteration, insert node n between pre and pre.next

public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null)
			return null;

		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode pre = fakeHead;
		int count = 1;
		while (pre.next != null && count < m) {  //Break the loop when find the node, or reach the end node
			pre = pre.next;
			count++;
		}
		if (count < m)  //Value m is invalid
			return null;
		ListNode mNode = pre.next;
		ListNode cur = mNode.next;
		while (cur != null && count < n) {
			ListNode next = cur.next;
			cur.next = pre.next;
			mNode.next = next;
			pre.next = cur;
			cur = next;
			count++;
		}
		return fakeHead.next;
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
		head.next.next.next.next = new ListNode(5);
		ListNode result = solution.reverseBetween(head, 2, 4);
		while(result.next != null) {
			System.out.print(result.val + " -> ");
			result = result.next;
		}
		System.out.println(result.val);
	}
}
