package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/11.
 */
public class MinimumDepthOfBinaryTree
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
		public int minDepth(TreeNode root)
		{
			if (root == null)
			{
				return 0;
			}
			int left = minDepth(root.left);
			int right = minDepth(root.right);
			return ((left == 0) || (right == 0)) ? Math.max(left, right) + 1 : Math.min(left, right) + 1;
		}
	}
}
