package leetcode.medium;

/**
 * Created by zhangsw on 2018/1/20.
 */
public class SumRootToLeafNumbers
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
		private int sum;

		public int sumNumbers(TreeNode root)
		{
			sum = 0;
			helper(root, 0);
			return sum;
		}

		private void helper(TreeNode node, int current)
		{
			if (node == null)
			{
				return;
			}
			current += node.val;
			if (node.left == null && node.right == null)
			{
				sum += current;
			}
			helper(node.left, current * 10);
			helper(node.right, current * 10);
		}
	}
}
