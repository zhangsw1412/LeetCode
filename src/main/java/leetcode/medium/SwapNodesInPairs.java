package leetcode.medium;

/**
 * Created by zhangsw on 2017/12/14.
 */
public class SwapNodesInPairs
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
		public ListNode swapPairs(ListNode head)
		{
			ListNode fake = new ListNode(0), left, right, l, r;
			fake.next = head;
			left = fake;
			while (left != null)
			{
				l = left.next == null ? null : left.next;
				r = l == null ? l : l.next;
				right = r == null ? r : r.next;
				if (l == null || r == null)
				{
					break;
				}
				left.next = r;
				r.next = l;
				l.next = right;
				left = left.next.next;
			}
			return fake.next;
		}

		//递归版
		/*
		public ListNode swapPairs(ListNode head)
		{
			if ((head == null) || (head.next == null))
			{
				return head;
			}
			ListNode n = head.next;
			head.next = swapPairs(head.next.next);
			n.next = head;
			return n;
		}
		*/
	}
}
