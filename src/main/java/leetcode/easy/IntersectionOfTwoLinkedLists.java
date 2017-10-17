package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/17.
 */
public class IntersectionOfTwoLinkedLists
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
		/*
		这个解法特别机智，用两个指针分别遍历两个链表，当到达末尾时，跳到另一个链表的头断续遍历
		两个指针走过的路相同，一定会相等，要么是在交点，要么是都走到了最后一个节点
		 */
		public ListNode getIntersectionNode(ListNode headA, ListNode headB)
		{
			if (headA == null || headB == null)
			{
				return null;
			}
			ListNode a = headA, b = headB;
			while (a != b)
			{
				a = (a == null) ? headB : a.next;
				b = (b == null) ? headA : b.next;
			}
			return a;
		}

		/*
		先计算两个链表的长度，把长的那个往后移，让起点后面剩下的节点数量相同
		然后开始遍历，直到相等
		 */
		/*
		public ListNode getIntersectionNode(ListNode headA, ListNode headB)
		{
			if (headA == null || headB == null)
			{
				return null;
			}
			int len_a = 1, len_b = 1, difference;
			ListNode a = headA, b = headB;
			while (a.next != null)
			{
				a = a.next;
				++len_a;
			}
			while (b.next != null)
			{
				b = b.next;
				++len_b;
			}
			difference = Math.abs(len_a - len_b);
			a = headA;
			b = headB;
			if (len_a < len_b)
			{
				while (difference-- > 0)
				{
					b = b.next;
				}
			}
			else
			{
				while (difference-- > 0)
				{
					a = a.next;
				}
			}
			while (a != b)
			{
				a = a.next;
				b = b.next;
			}
			return a;
		}
		*/
	}
}
