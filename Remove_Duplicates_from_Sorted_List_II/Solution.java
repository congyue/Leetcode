public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;

		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode pre = fakeHead;

		//pre:		last valid element in the result
		//pre.next:	points to potential next node
		//cur:		find the index where cur.next.val != cur.val
		//So when pre.next == cur, cur would be a valid node
		//When pre.next != cur, means cur is duplicated and invalid, update pre.next to cur.next
		for (ListNode cur = head; cur != null; cur = cur.next) {
			if (cur.next == null || cur.val != cur.next.val) {  //Find right index for cur
				if (pre.next == cur)  //Valid node, update pre position
					pre = pre.next;
				else				  //Invalid node, update pre.next to new node
					pre.next = cur.next;
			}
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
