package leetcode.medium;

/**
 * Created by zhangsw on 2017/12/29.
 */
public class RemoveDuplicatesFromSortedList_II
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
		//简洁版
		public ListNode deleteDuplicates(ListNode head)
		{
			if (head == null)
			{
				return null;
			}
			ListNode FakeHead = new ListNode(0);
			FakeHead.next = head;
			ListNode pre = FakeHead;
			ListNode cur = head;
			while (cur != null)
			{
				while (cur.next != null && cur.val == cur.next.val)
				{
					cur = cur.next;
				}
				if (pre.next == cur)
				{
					pre = pre.next;
				}
				else
				{
					pre.next = cur.next;
				}
				cur = cur.next;
			}
			return FakeHead.next;
		}

		/*
		public ListNode deleteDuplicates(ListNode head)
		{
			if (head == null)
			{
				return head;
			}
			ListNode fake = new ListNode(-1), start, end;
			fake.next = head;
			start = fake;
			int val, counter;
			while (start != null)
			{
				end = start.next;
				val = end == null ? 0 : end.val;
				counter = 0;
				while (end != null && end.val == val)
				{
					++counter;
					end = end.next;
				}
				if (counter > 1)
				{
					start.next = end;
				}
				else
				{
					start = start.next;
				}
			}
			return fake.next;
		}
		*/
	}
}
