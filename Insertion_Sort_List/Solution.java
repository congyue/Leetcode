/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummyHead = new ListNode(0);	//New head to store sorted list
		ListNode cur = head;		//The node to be inserted
		ListNode pre = dummyHead;	//Insert node between pre and pre.next
		ListNode next = null;		//The next node will be inserted
		while(cur != null) {
			next = cur.next; //Mark the position next to cur
			while (pre.next != null && pre.next.val < cur.val)	//Find the right place to add
				pre = pre.next;

			cur.next = pre.next; //Insert cur between pre and next
			pre.next = cur;
			pre = dummyHead; //Reset pre to dummyHead
			cur = next;	//Reset cur to next
		}
		return dummyHead.next;
	}

	private void printList(ListNode node) {
		while(node != null) {
			System.out.println(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}

	private static class ListNode {
		private int val;
		private ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode n1 = new ListNode(5);
		ListNode n2 = new ListNode(8);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(7);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		ListNode node = solution.insertionSortList(n1);
		solution.printList(node);
	}
}
