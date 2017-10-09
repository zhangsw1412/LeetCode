package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/9.
 */
public class RemoveDuplicatesFromSortedList
{
	/*
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
		public ListNode deleteDuplicates(ListNode head)
		{
			if (head != null)
			{
				ListNode pre = head, current = pre.next;
				while (current != null)
				{
					if (pre.val != current.val)

					{
						pre.next = current;
						pre = current;
					}
					current = current.next;
				}
				pre.next = current;
			}
			return head;
		}
	}
}
