package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/27.
 */
public class MinimumAbsoluteDifferenceInBST
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
		private TreeNode pre = null;
		int min = Integer.MAX_VALUE;

		public int getMinimumDifference(TreeNode root)
		{
			inOrder(root);
			return min;
		}

		//因为是BST，所以采用中序遍历的方法能够造成一个递增序列
		private void inOrder(TreeNode node)
		{
			if (node == null)
			{
				return;
			}
			inOrder(node.left);
			if (pre != null)
			{
				min = Math.min(min, node.val - pre.val);
			}
			pre = node;
			inOrder(node.right);
		}
	}
}
