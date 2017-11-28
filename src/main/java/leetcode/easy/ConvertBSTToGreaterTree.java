package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/28.
 */
public class ConvertBSTToGreaterTree
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
		private int sum = 0;

		public TreeNode convertBST(TreeNode root)
		{
			inOrder(root);
			return root;
		}

		private void inOrder(TreeNode node)
		{
			if (node == null)
			{
				return;
			}
			inOrder(node.right);
			int origin = node.val;
			node.val += sum;
			sum += origin;
			inOrder(node.left);
		}
	}
}
