package leetcode.medium;

/**
 * Created by zhangsw on 2017/12/14.
 */
public class RemoveNthNodeFromEndOfList
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
		public ListNode removeNthFromEnd(ListNode head, int n)
		{
			ListNode fake = new ListNode(0);
			fake.next = head;
			ListNode left = fake, right = fake;
			while (right != null && n > 0)
			{
				right = right.next;
				--n;
			}
			while (right.next != null)
			{
				left = left.next;
				right = right.next;
			}
			left.next = left.next.next;
			return fake.next;
		}
	}
}
