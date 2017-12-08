package leetcode.easy;

/**
 * Created by zhangsw on 2017/12/8.
 */
public class LongestUnivaluePath
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
		int re = 0;

		public int longestUnivaluePath(TreeNode root)
		{
			help(root, 0);
			return re;
		}

		public int help(TreeNode root, int n)
		{
			if (root == null)
			{
				return 0;
			}
			int left = help(root.left, root.val);
			int right = help(root.right, root.val);
			re = Math.max(re, left + right);
			return root.val == n ? Math.max(left, right) + 1 : 0;
		}
	}
}