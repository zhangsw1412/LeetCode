package leetcode.medium;

/**
 * Created by zhangsw on 2018/1/12.
 */
public class FlattenBinaryTreeToLinkedList
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
		public void flatten(TreeNode root)
		{
			if (root == null)
			{
				return;
			}
			flatten(root.left);
			flatten(root.right);
			TreeNode right = root.right;
			root.right = root.left;
			root.left = null;
			while (root.right != null)
			{
				root = root.right;
			}
			root.right = right;
		}
	}
}
