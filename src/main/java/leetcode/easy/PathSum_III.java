package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/15.
 */
public class PathSum_III
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
		public int pathSum(TreeNode root, int sum)
		{
			if (root == null)
			{
				return 0;
			}
			return findPath(root, 0, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
		}

		private int findPath(TreeNode node, int pre, int sum)
		{
			if (node == null)
			{
				return 0;
			}
			int current = pre + node.val;
			return ((current == sum) ? 1 : 0) + findPath(node.left, current, sum) + findPath(node.right, current, sum);
		}
	}
}