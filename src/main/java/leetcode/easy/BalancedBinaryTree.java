package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/11.
 */
public class BalancedBinaryTree
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
		//递归方法
		public boolean isBalanced(TreeNode root)
		{
			return balanced(root);
		}

		private int depth(TreeNode node)
		{
			return (node == null) ? 0 : Math.max(depth(node.left), depth(node.right)) + 1;
		}

		private boolean balanced(TreeNode node)
		{
			if (node == null)
			{
				return true;
			}
			int left = depth(node.left);
			int right = depth(node.right);
			return Math.abs(left - right) <= 1 && balanced(node.left) && balanced(node.right);
		}

		//一种复杂度为O(n)的方法，采用深度优先遍历，如果不平衡就返回一个标识，否则返回树高
		/*
		private static final int UNBALANCED = -99;

		public boolean isBalanced(TreeNode root)
		{
			if (root == null)
			{
				return true;
			}
			return getHeight(root) != UNBALANCED;
		}

		private int getHeight(TreeNode root)
		{
			if (root == null)
			{
				return -1;
			}
			int l = getHeight(root.left);
			int r = getHeight(root.right);
			if (l == UNBALANCED || r == UNBALANCED || Math.abs(l - r) > 1)
			{
				return UNBALANCED;
			}
			return 1 + Math.max(l, r);
		}
		*/
	}
}
