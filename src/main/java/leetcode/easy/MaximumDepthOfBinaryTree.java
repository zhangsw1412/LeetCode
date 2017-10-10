package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/10.
 */
public class MaximumDepthOfBinaryTree
{
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
		public int maxDepth(TreeNode root)
		{
			if (root == null)
			{
				return 0;
			}
			int left = maxDepth(root.left);
			int right = maxDepth(root.right);
			return left > right ? left + 1 : right + 1;
			//一行版
			//return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
		}
	}
}
