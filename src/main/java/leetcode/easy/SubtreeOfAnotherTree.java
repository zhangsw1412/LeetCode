package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/29.
 */
public class SubtreeOfAnotherTree
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
		public boolean isSubtree(TreeNode s, TreeNode t)
		{
			if (s == null || t == null)
			{
				return false;
			}
			return sameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
		}

		private boolean sameTree(TreeNode s, TreeNode t)
		{
			if (s == null && t == null)
			{
				return true;
			}
			if (s == null || t == null)
			{
				return false;
			}
			return s.val == t.val && sameTree(s.left, t.left) && sameTree(s.right, t.right);
		}
	}
}
