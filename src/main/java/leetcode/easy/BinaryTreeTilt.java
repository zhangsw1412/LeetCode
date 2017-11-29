package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/29.
 */
public class BinaryTreeTilt
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
		public int findTilt(TreeNode root)
		{
			sumNode(root);
			calTilts(root);
			return sumNode(root);
		}

		private int sumNode(TreeNode node)
		{
			if (node == null)
			{
				return 0;
			}
			node.val += sumNode(node.left) + sumNode(node.right);
			return node.val;
		}

		private void calTilts(TreeNode node)
		{
			if (node == null)
			{
				return;
			}
			node.val = Math.abs((node.left == null ? 0 : node.left.val) - (node.right == null ? 0 : node.right.val));
			calTilts(node.left);
			calTilts(node.right);
		}

		//后序遍历解法
		/*
		int result = 0;

		public int findTilt(TreeNode root)
		{
			postOrder(root);
			return result;
		}

		private int postOrder(TreeNode root)
		{
			if (root == null)
			{
				return 0;
			}

			int left = postOrder(root.left);
			int right = postOrder(root.right);

			result += Math.abs(left - right);

			return left + right + root.val;
		}
		*/
	}
}
