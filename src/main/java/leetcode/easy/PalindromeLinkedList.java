package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/2.
 */
public class PalindromeLinkedList
{
	class Solution
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

		/*
		先找到链表的中间点，然后把后半部分翻转，跟前半部分比较
		 */
		public boolean isPalindrome(ListNode head)
		{
			if (head == null || head.next == null)
			{
				return true;
			}
			ListNode slow = head, fast = head, tail, temp;
			while (fast.next != null && fast.next.next != null)
			{
				slow = slow.next;
				fast = fast.next.next;
			}
			tail = slow.next;
			while (tail != null && tail.next != null)
			{
				temp = tail.next;
				tail.next = temp.next;
				temp.next = slow.next;
				slow.next = temp;
			}
			temp = slow.next;
			while (temp != null)
			{
				if (head.val != temp.val)
				{
					return false;
				}
				head = head.next;
				temp = temp.next;
			}
			return true;
		}
	}
}
