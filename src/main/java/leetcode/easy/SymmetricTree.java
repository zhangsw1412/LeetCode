package leetcode.easy;

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
			return (left != null) && (right != null) && (left.val == right.val) && symmetric(left.left, right.right) && symmetric(
					left.right, right.left);
		}
	}
}
