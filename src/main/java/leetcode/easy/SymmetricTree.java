package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangsw on 2017/10/10.
 */
public class SymmetricTree
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
		//迭代版
		public boolean isSymmetric(TreeNode root)
		{
			Queue<TreeNode> q = new LinkedList<>();
			if (root == null)
			{
				return true;
			}
			q.add(root.left);
			q.add(root.right);
			while (q.size() > 1)
			{
				TreeNode left = q.poll(), right = q.poll();
				if (left == null && right == null)
				{
					continue;
				}
				if (left == null ^ right == null)
				{
					return false;
				}
				if (left.val != right.val)
				{
					return false;
				}
				q.add(left.left);
				q.add(right.right);
				q.add(left.right);
				q.add(right.left);
			}
			return true;
		}
		//递归版
		/*
		public boolean isSymmetric(TreeNode root)
		{
			if (root == null)
			{
				return true;
			}
			return symmetric(root.left, root.right);
		}

		private boolean symmetric(TreeNode left, TreeNode right)
		{
			if (left == null && right == null)
			{
				return true;
			}
			return (left != null) && (right != null) && (left.val == right.val) && symmetric(left.left, right.right)
			&& symmetric(
					left.right, right.left);
		}
		*/
	}
}
