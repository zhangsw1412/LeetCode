package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/11.
 */
public class ConvertSortedArrayToBinarySearchTree
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
		//递归方式构造平衡二叉搜索树
		public TreeNode sortedArrayToBST(int[] num)
		{
			if (num == null)
			{
				return null;
			}
			return helper(num, 0, num.length - 1);
		}

		private TreeNode helper(int[] num, int left, int right)
		{
			if (left > right)
			{
				return null;
			}
			int mid = (left + right) / 2;
			TreeNode node = new TreeNode(num[mid]);
			node.left = helper(num, left, mid - 1);
			node.right = helper(num, mid + 1, right);
			return node;
		}
	}
}
