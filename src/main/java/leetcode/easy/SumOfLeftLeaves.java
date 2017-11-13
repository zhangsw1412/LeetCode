package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/13.
 */
public class SumOfLeftLeaves
{
	/**
	 * Definition for a binary tree node.
	 */
	class TreeNode
	{
		int val;
		TreeNode left, right;

		public TreeNode(int x)
		{
			val = x;
		}
	}

	class Solution
	{
		public int sumOfLeftLeaves(TreeNode root)
		{
			if (root == null)
			{
				return 0;
			}
			return countLeftLeaves(root.left, true) + countLeftLeaves(root.right, false);
		}

		private int countLeftLeaves(TreeNode node, boolean left)
		{
			if (node == null)
			{
				return 0;
			}
			if (node.left == null && node.right == null && left)
			{
				return node.val;
			}
			return countLeftLeaves(node.left, true) + countLeftLeaves(node.right, false);
		}
	}
}
