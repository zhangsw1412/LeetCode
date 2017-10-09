package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/9.
 */
public class SameTree
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
		//自己的版本
		public boolean isSameTree(TreeNode p, TreeNode q)
		{
			if (p == null && q == null)
			{
				return true;
			}
			if (p == null || q == null)
			{
				return false;
			}
			if (p.val != q.val)
			{
				return false;
			}
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
	}
}
