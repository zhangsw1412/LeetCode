package leetcode.medium;

/**
 * Created by zhangsw on 2018/3/7.
 */
public class ReorderList
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
		//先使用快慢指针将链表从中间分割成两段，然后后半段翻转，之后合并插入到前半段链表即可
		public void reorderList(ListNode head)
		{
			if (head == null || head.next == null)
			{
				return;
			}
			ListNode fast = head, slow = head;
			while (fast.next != null && fast.next.next != null)
			{
				fast = fast.next.next;
				slow = slow.next;
			}
			ListNode secondHalf = slow.next;
			slow.next = null;

			//翻转后半部分
			ListNode post = secondHalf.next;
			secondHalf.next = null;
			while (post != null)
			{
				ListNode temp = post.next;
				post.next = secondHalf;
				secondHalf = post;
				post = temp;
			}

			//合并
			while (secondHalf != null)
			{
				ListNode temp = secondHalf.next;
				secondHalf.next = head.next;
				head.next = secondHalf;
				head = secondHalf.next;
				secondHalf = temp;
			}
		}
	}
}
