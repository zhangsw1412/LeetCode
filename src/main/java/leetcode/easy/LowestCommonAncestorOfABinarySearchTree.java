package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/2.
 */
public class LowestCommonAncestorOfABinarySearchTree
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
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
		{
			TreeNode ancestor = root;
			while ((ancestor.val < p.val && ancestor.val < q.val) || (ancestor.val > p.val && ancestor.val > q.val))
			{
				ancestor = (ancestor.val < p.val) ? ancestor.right : ancestor.left;
			}
			return ancestor;
		}
	}
}
