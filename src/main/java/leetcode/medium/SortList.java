package leetcode.medium;

/**
 * Created by zhangsw on 2018/3/9.
 */
public class SortList
{
	/**
	 * Definition for singly-linked list.
	 */
	class ListNode
	{
		int val;
		ListNode next;

		ListNode(int x)
		{
			val = x;
			next = null;
		}
	}

	class Solution
	{
		//二路归并
		public ListNode sortList(ListNode head)
		{
			if (head == null || head.next == null)
			{
				return head;
			}
			ListNode fast = head, slow = head, post;
			while (fast.next != null && fast.next.next != null)
			{
				slow = slow.next;
				fast = fast.next.next;
			}
			post = slow.next;
			slow.next = null;
			return merge(sortList(head), sortList(post));
		}

		private ListNode merge(ListNode n1, ListNode n2)
		{
			if (n1 == null)
			{
				return n2;
			}
			if (n2 == null)
			{
				return n1;
			}
			if (n1.val <= n2.val)
			{
				n1.next = merge(n1.next, n2);
				return n1;
			}
			else
			{
				n2.next = merge(n1, n2.next);
				return n2;
			}
		}
	}
}
