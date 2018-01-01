package leetcode.medium;

/**
 * Created by zhangsw on 2018/1/1.
 */
public class ReverseLinkedList_II
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
		public ListNode reverseBetween(ListNode head, int m, int n)
		{
			if (m == n)
			{
				return head;
			}
			ListNode fake = new ListNode(0), pre = fake, start;
			fake.next = head;
			for (int i = 1; i < m; i++)
			{
				pre = pre.next;
			}
			start = pre.next;
			for (int i = 0; i < n - m; i++)
			{
				ListNode temp = start.next;
				start.next = temp.next;
				temp.next = pre.next;
				pre.next = temp;
			}
			return fake.next;
		}
	}
}
