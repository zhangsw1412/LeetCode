package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/16.
 */
public class LinkedListCycle
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
		/**
		 * 用两个节点互相追，一个快节点，一个慢节点，快节点步长为2，慢节点步长为1
		 * @param head 头节点
		 * @return 是否有环
		 */
		public boolean hasCycle(ListNode head)
		{
			ListNode slow = head, fast = head;
			while (fast != null && fast.next != null)
			{
				fast = fast.next.next;
				slow = slow.next;
				if (slow == fast)
				{
					return true;
				}
			}
			return false;
		}
	}
}
