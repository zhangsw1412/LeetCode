package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhangsw on 2018/1/8.
 */
public class BinaryTreeLevelOrderTraversal
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
		public List<List<Integer>> levelOrder(TreeNode root)
		{
			List<List<Integer>> list = new ArrayList<>();
			if (root == null)
			{
				return list;
			}
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			while (!queue.isEmpty())
			{
				int length = queue.size();
				List<Integer> temp = new ArrayList<>();
				TreeNode node;
				for (int i = 0; i < length; i++)
				{
					node = queue.poll();
					temp.add(node.val);
					if (node.left != null)
					{
						queue.offer(node.left);
					}
					if (node.right != null)
					{
						queue.offer(node.right);
					}
				}
				list.add(temp);
			}
			return list;
		}
	}
}
