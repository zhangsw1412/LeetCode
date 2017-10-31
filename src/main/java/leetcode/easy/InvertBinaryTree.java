package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/31.
 */
public class InvertBinaryTree
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
		public TreeNode invertTree(TreeNode root)
		{
			if (root == null)
			{
				return root;
			}
			TreeNode newLeft = invertTree(root.right);
			root.right = invertTree(root.left);
			root.left = newLeft;
			return root;
		}
	}
}
