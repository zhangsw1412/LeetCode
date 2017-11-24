package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2017/11/24.
 */
public class FindModeInBinarySearchTree
{
	/**
	 * Definition for a binary tree node.
	 */
	class TreeNode
	{
		int val;
		TreeNode left, right;

		TreeNode(int x)
		{
			val = x;
		}
	}

	class Solution
	{
		private List<Integer> list = new ArrayList<>();
		private int max = 0, count = 1;
		private TreeNode pre = null;

		/*
		BST中序遍历之后就是一个非减序列，寻找这个序列里出现次数最多的数字就行了
		 */
		public int[] findMode(TreeNode root)
		{
			inOrder(root);
			int[] res = new int[list.size()];
			int i = 0;
			for (Integer t : list)
			{
				res[i++] = t;
			}
			return res;
		}

		private void inOrder(TreeNode node)
		{
			if (node == null)
			{
				return;
			}
			inOrder(node.left);
			if (pre != null)
			{
				if (pre.val == node.val)
				{
					count = count + 1;
				}
				else
				{
					count = 1;
				}
			}
			if (count >= max)
			{
				if (count > max)
				{
					list.clear();
					max = count;
				}
				list.add(node.val);
			}
			pre = node;
			inOrder(node.right);
		}
	}
}
