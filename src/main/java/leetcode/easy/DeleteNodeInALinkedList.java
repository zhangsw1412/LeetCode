package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/2.
 */
public class DeleteNodeInALinkedList
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
		/*
		正常的删除节点需要知道被删节点的前驱节点和后继节点
		这个题目找不到前驱节点，所以只能把后面的节点覆盖到前面
		 */
		public void deleteNode(ListNode node)
		{
			node.val = node.next.val;
			node.next = node.next.next;
		}
	}
}
