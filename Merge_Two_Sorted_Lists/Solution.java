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
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode headNode = new ListNode(0), lastNode = headNode;

		while(l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				lastNode.next = l1;
				l1 = l1.next;
			}
			else {
				lastNode.next = l2;
				l2 = l2.next;
			}
			lastNode = lastNode.next;
		}

		while(l1 != null) {
			lastNode.next = l1;
			l1 = l1.next;
			lastNode = lastNode.next;
		}

		while(l2 != null) {
			lastNode.next = l2;
			l2 = l2.next;
			lastNode = lastNode.next;
		}
		return headNode.next;
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
		n3.next = n4;

		ListNode node = solution.mergeTwoLists(n1, n3);
		solution.printList(node);
	}
}
