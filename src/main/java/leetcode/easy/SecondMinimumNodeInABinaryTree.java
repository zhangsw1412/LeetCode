package leetcode.easy;

/**
 * Created by zhangsw on 2017/12/7.
 */
public class SecondMinimumNodeInABinaryTree
{
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
		public int findSecondMinimumValue(TreeNode root)
		{
			int[] result = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
			helper(root, result);
			return result[1] == Integer.MAX_VALUE ? -1 : result[1];
		}

		private void helper(TreeNode node, int[] res)
		{
			if (node == null)
			{
				return;
			}
			if (node.val < res[0])
			{
				res[1] = res[0];
				res[0] = node.val;
			}
			else if (node.val > res[0] && node.val < res[1])
			{
				res[1] = node.val;
			}
			helper(node.left, res);
			helper(node.right, res);
		}
	}
}
