package leetcode.medium;

/**
 * Created by zhangsw on 2017/12/26.
 */
public class RotateList
{
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
		public ListNode rotateRight(ListNode head, int k)
		{
			if (head == null)
			{
				return head;
			}
			ListNode tail = head, fake = new ListNode(-1);
			int length = 1;
			while (tail.next != null)
			{
				++length;
				tail = tail.next;
			}
			k %= length;
			k = length - k;
			fake.next = head;
			while (k-- > 0)
			{
				tail.next = fake.next;
				fake.next = fake.next.next;
				tail = tail.next;
				tail.next = null;
			}
			return fake.next;
		}
	}
}
