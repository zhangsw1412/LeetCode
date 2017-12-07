package leetcode.easy;

/**
 * Created by zhangsw on 2017/12/5.
 */
public class TrimABinarySearchTree
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
		public TreeNode trimBST(TreeNode root, int l, int r)
		{
			if (root == null)
			{
				return root;
			}
			if (root.val >= l && root.val <= r)
			{
				root.left = trimBST(root.left, l, r);
				root.right = trimBST(root.right, l, r);
				return root;
			}
			if (root.val < l)
			{
				return trimBST(root.right, l, r);
			}
			if (root.val > r)
			{
				return trimBST(root.left, l, r);
			}
			return null;
		}
	}
}

