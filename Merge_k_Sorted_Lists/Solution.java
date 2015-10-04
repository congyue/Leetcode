import java.util.*;
public class Solution {
	public ListNode mergeKLists(List<ListNode> lists) {
		if(lists == null || lists.size() == 0)
			return null;
		//Create a natural order heap
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
				@Override
				public int compare(ListNode n1, ListNode n2) {
					return n1.val - n2.val;
				}
				});
		
		//Get first node of each list and add to heap
		for (ListNode n : lists)
			if (n != null)
				heap.offer(n);
		ListNode dummyHead = new ListNode(0);
		ListNode cur = dummyHead;
		//Get smallest node in the heap, add to result, then push back node.next to heap for further comparison
		while(heap.size() != 0) {
			cur.next = heap.poll();
			cur = cur.next;
			if (cur.next != null)
				heap.offer(cur.next);
		}
		return dummyHead.next;
	}
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		List<ListNode> lists = new LinkedList<ListNode>();
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(6);
		list1.next.next = new ListNode(10);

		ListNode list2 = new ListNode(3);
		list2.next = new ListNode(8);
		list2.next.next = new ListNode(12);

		lists.add(list1);
		lists.add(list2);
		
		ListNode result = solution.mergeKLists(lists);
		while(result != null) {
			System.out.print(result.val + ", ");
			result = result.next;
		}
		System.out.println();
	}
}
