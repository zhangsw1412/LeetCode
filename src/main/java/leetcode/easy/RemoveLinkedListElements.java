package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/26.
 */
public class RemoveLinkedListElements
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
		//简化版
		public ListNode removeElements(ListNode head, int val)
		{
			ListNode fakeHead = new ListNode(-1);
			fakeHead.next = head;
			ListNode curr = head, prev = fakeHead;
			while (curr != null)
			{
				if (curr.val == val)
				{
					prev.next = curr.next;
				}
				else
				{
					prev = prev.next;
				}
				curr = curr.next;
			}
			return fakeHead.next;
		}
		//自己的版本
		/*
		public ListNode removeElements(ListNode head, int val)
		{
			ListNode pre = head, current;
			while (pre != null && pre.val == val)
			{
				pre = pre.next;
			}
			head = pre;
			if (head == null)
			{
				return head;
			}
			current = pre.next;
			while (current != null)
			{
				if (current.val == val)
				{
					pre.next = current.next;
					current = pre.next;
				}
				else
				{
					pre = current;
					current = pre.next;
				}
			}
			return head;
		}
		*/
	}
}
