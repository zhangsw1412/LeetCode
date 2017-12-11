package leetcode.medium;

/**
 * Created by zhangsw on 2017/12/11.
 */
public class AddTwoNumbers
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
		public ListNode addTwoNumbers(ListNode l1, ListNode l2)
		{
			if (l1 == null)
			{
				return l2 == null ? null : l2;
			}
			ListNode p1 = l1, p2 = l2, result = new ListNode(0), temp = result;
			int carry = 0;
			while (p1 != null || p2 != null)
			{
				temp.next = new ListNode((p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val) + carry);
				temp = temp.next;
				if (temp.val >= 10)
				{
					carry = 1;
					temp.val %= 10;
				}
				else
				{
					carry = 0;
				}
				p1 = p1 == null ? p1 : p1.next;
				p2 = p2 == null ? p2 : p2.next;
			}
			if (carry == 1)
			{
				temp.next = new ListNode(1);
			}
			return result.next;
		}
	}
}
