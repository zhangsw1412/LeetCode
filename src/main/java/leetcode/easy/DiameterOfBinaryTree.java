package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/28.
 */
public class DiameterOfBinaryTree
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
		public int diameterOfBinaryTree(TreeNode root)
		{
			if (root == null)
			{
				return 0;
			}
			return Math.max(height(root.left) + height(root.right),
			                Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
		}

		private int height(TreeNode node)
		{
			if (node == null)
			{
				return 0;
			}
			return 1 + Math.max(height(node.left), height(node.right));
		}
	}
}
