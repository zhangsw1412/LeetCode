package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/27.
 */
public class ReverseLinkedList
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
		//迭代方式
		public ListNode reverseList(ListNode head)
		{
			if (head == null || head.next == null)
			{
				return head;
			}
			ListNode newHead = reverseList(head.next);
			head.next.next = head;
			head.next = null;
			return newHead;
		}
		/*
		public ListNode reverseList(ListNode head)
		{
			if (head == null || head.next == null)
			{
				return head;
			}
			ListNode fake = new ListNode(0), temp;
			fake.next = head;
			while (head.next != null)
			{
				temp = head.next;
				head.next = temp.next;
				temp.next = fake.next;
				fake.next = temp;
			}
			return fake.next;
		}
		*/
	}
}
