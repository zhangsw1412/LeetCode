package leetcode.easy;

/**
 * Created by zhangsw on 2017/12/2.
 */
public class MergeTwoBinaryTrees
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
		public TreeNode mergeTrees(TreeNode n1, TreeNode n2)
		{
			if (n1 == null)
			{
				return n2;
			}
			if (n2 == null)
			{
				return n1;
			}
			n1.val += n2.val;
			n1.left = mergeTrees(n1.left, n2.left);
			n1.right = mergeTrees(n1.right, n2.right);
			return n1;
		}
	}
}
