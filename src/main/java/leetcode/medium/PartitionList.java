package leetcode.medium;

/**
 * Created by zhangsw on 2017/12/30.
 */
public class PartitionList
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
		public ListNode partition(ListNode head, int x)
		{
			if (head == null)
			{
				return null;
			}
			ListNode fake = new ListNode(0), fakeLess = new ListNode(0), cur, curLess;
			fake.next = head;
			cur = fake;
			curLess = fakeLess;
			while (cur.next != null)
			{
				if (cur.next.val < x)
				{
					curLess.next = cur.next;
					cur.next = cur.next.next;
					curLess = curLess.next;
				}
				else
				{
					cur = cur.next;
				}
			}
			curLess.next = fake.next;
			return fakeLess.next;
		}
	}
}
