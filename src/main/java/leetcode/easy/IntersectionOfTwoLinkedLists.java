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
	}
}
