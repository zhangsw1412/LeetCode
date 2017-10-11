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
	}
}
