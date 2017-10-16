package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/16.
 */
public class LinkedListCycle
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
		}
	}

	class Solution
	{
		public boolean hasCycle(ListNode head)
		{
			ListNode slow = head, fast = head;
			while (fast != null && fast.next != null)
			{
				fast = fast.next.next;
				slow = slow.next;
				if (slow == fast)
				{
					return true;
				}
			}
			return false;
		}
	}
}
