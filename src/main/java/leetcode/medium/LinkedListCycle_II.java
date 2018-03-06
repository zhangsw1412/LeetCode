package leetcode.medium;

/**
 * Created by zhangsw on 2018/3/6.
 */
public class LinkedListCycle_II
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
			val=x;
			next = null;
		}
	}

	class Solution
	{
		/*
		如果链表中存在环，那么fp和sp一定会相遇，当两个指针相遇的时候，我们设相遇点为c，此时fp和sp都指向了c，接下来令fp继续指向c结点，
		sp指向链表头结点head，此时最大的不同是fp的步数变成为每次走一步，令fp和sp同时走，每次一步，那么它们再次相遇的时候即为环的入口结点
		 */
		public ListNode detectCycle(ListNode head)
		{
			if (head == null)
			{
				return null;
			}
			ListNode fast = head, slow = head;
			while (fast != null && fast.next != null)
			{
				fast = fast.next.next;
				slow = slow.next;
				if (fast == slow)
				{
					break;
				}
			}
			if (fast == null || fast.next == null)
			{
				return null;//没有环
			}
			slow = head;
			while (fast != slow)
			{
				fast = fast.next;
				slow = slow.next;
			}
			return slow;
		}
	}
}
