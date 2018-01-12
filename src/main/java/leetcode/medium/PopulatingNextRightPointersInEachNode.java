package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangsw on 2018/1/12.
 */
public class PopulatingNextRightPointersInEachNode
{
	/**
	 * Definition for a binary tree with next pointer.
	 */
	class TreeLinkNode
	{
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x)
		{
			val = x;
		}
	}

	class Solution
	{
		public void connect(TreeLinkNode root)
		{
			if (root == null)
			{
				return;
			}
			Queue<TreeLinkNode> queue = new LinkedList<>();
			queue.offer(root);
			while (!queue.isEmpty())
			{
				int length = queue.size();
				for (int i = 0; i < length; i++)
				{
					if (queue.peek().left != null)
					{
						queue.offer(queue.peek().left);
					}
					if (queue.peek().right != null)
					{
						queue.offer(queue.peek().right);
					}
					queue.poll().next = i == length - 1 ? null : queue.peek();
				}
			}
		}

		//递归版
		/*
		public void connect(TreeLinkNode root)
		{
			if (root == null)
			{
				return;
			}
			if (root.left != null)
			{
				root.left.next = root.right;
				if (root.next != null)
				{
					root.right.next = root.next.left;
				}
			}
			connect(root.left);
			connect(root.right);
		}
		*/
	}
}
