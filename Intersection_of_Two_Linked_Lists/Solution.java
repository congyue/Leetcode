//listA: a1, a2, c1, c2, c3
//listB: b1, b2, b3, c1, c2, c3

//listA + listB: a1, a2, c1, c2, c3, b1, b2, b3, c1, c2, c3
//listB + listA: b1, b2, b3, c1, c2, c3, a1, a2, c1, c2, c3
//                                               -> Common node is aligned!

public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode p1 = headA, p2 = headB;
		while(p1 != p2) {  //Only break the loop if common node is found
			p1 = p1.next;
			p2 = p2.next;
			if (p1 == p2 && p1 == null) //No common nodes when both pointers reach null
				return p1;

			if (p1 == null)  //Attach headB after listA
				p1 = headB;
			if (p2 == null)  //Attach headA after listB
				p2 = headA;
		}
		return p1;
	}
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(6);
		head1.next.next.next = new ListNode(3);
		head1.next.next.next.next = new ListNode(4);

		ListNode head2 = new ListNode(5);
		head2.next = new ListNode(7);
		head2.next.next = head1.next.next.next;

		ListNode result = solution.getIntersectionNode(head1, head2);
		System.out.println(result.val);
	}
}
