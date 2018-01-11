package leetcode.medium;

/**
 * Created by zhangsw on 2018/1/11.
 */
public class ConvertSortedListToBinarySearchTree
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

	/**
	 * Definition for a binary tree node.
	 */
	class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x)
		{
			val = x;
		}
	}

	class Solution
	{
		public TreeNode sortedListToBST(ListNode head)
		{
			if (head == null)
			{
				return null;
			}
			return toBST(head, null);
		}

		public TreeNode toBST(ListNode head, ListNode tail)
		{
			ListNode slow = head;
			ListNode fast = head;
			if (head == tail)
			{
				return null;
			}

			while (fast != tail && fast.next != tail)
			{
				fast = fast.next.next;
				slow = slow.next;
			}
			TreeNode thead = new TreeNode(slow.val);
			thead.left = toBST(head, slow);
			thead.right = toBST(slow.next, tail);
			return thead;
		}
	}
}
