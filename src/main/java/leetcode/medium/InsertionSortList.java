package leetcode.medium;

/**
 * Created by zhangsw on 2018/3/9.
 */
public class InsertionSortList
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
		public ListNode insertionSortList(ListNode head)
		{
			if (head == null)
			{
				return null;
			}
			ListNode dummy = new ListNode(0);
			ListNode pre, current = head;
			while (current != null)
			{
				ListNode post = current.next;
				pre = dummy;
				while (pre.next != null && pre.next.val <= current.val)
				{
					pre = pre.next;
				}
				current.next = pre.next;
				pre.next = current;
				current = post;
			}
			return dummy.next;
		}
	}
}
