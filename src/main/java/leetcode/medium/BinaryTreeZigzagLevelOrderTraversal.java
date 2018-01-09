package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhangsw on 2018/1/9.
 */
public class BinaryTreeZigzagLevelOrderTraversal
{
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
		//简洁版
		public List<List<Integer>> zigzagLevelOrder(TreeNode root)
		{
			List<List<Integer>> res = new ArrayList<>();
			if (root == null)
			{
				return res;
			}
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			boolean zigzag = false;
			while (!queue.isEmpty())
			{
				List<Integer> level = new ArrayList<>();
				int cnt = queue.size();
				for (int i = 0; i < cnt; i++)
				{
					TreeNode node = queue.poll();
					if (zigzag)
					{
						level.add(0, node.val);
					}
					else
					{
						level.add(node.val);
					}
					if (node.left != null)
					{
						queue.add(node.left);
					}
					if (node.right != null)
					{
						queue.add(node.right);
					}
				}
				res.add(level);
				zigzag = !zigzag;
			}
			return res;
		}

		/*
		public List<List<Integer>> zigzagLevelOrder(TreeNode root)
		{
			List<List<Integer>> list = new ArrayList<>();
			if (root == null)
			{
				return list;
			}
			LinkedList<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			boolean direction = true;
			while (!queue.isEmpty())
			{
				int length = queue.size();
				TreeNode node;
				for (int i = 0; i < length; i++)
				{
					node = queue.get(i);
					if (node.left != null)
					{
						queue.offer(node.left);
					}
					if (node.right != null)
					{
						queue.offer(node.right);
					}
				}
				List<Integer> temp = new ArrayList<>();
				for (int i = direction ? 0 : length - 1; direction ? i < length : i >= 0; i = direction ? i + 1 : i - 1)
				{
					temp.add(direction ? queue.remove(0).val : queue.remove(i).val);
				}
				list.add(temp);
				direction = !direction;
			}
			return list;
		}
		*/
	}
}
