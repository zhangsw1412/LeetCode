package leetcode.medium;

/**
 * Created by zhangsw on 2018/3/28.
 */
public class CountCompleteTreeNodes
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
		/*
		如果从某节点一直向左的高度 = 一直向右的高度, 那么以该节点为root的子树一定是complete binary tree.
		而 complete binary tree的节点数,可以用公式算出 2^h - 1.
		如果高度不相等, 则递归调用 return countNode(left) + countNode(right) + 1.
		复杂度为O(h^2)
		 */
		public int countNodes(TreeNode root)
		{
			if (root == null)
			{
				return 0;
			}
			int hleft = 0, hright = 0;
			TreeNode left = root, right = root;
			while (left != null)
			{
				++hleft;
				left = left.left;
			}
			while (right != null)
			{
				++hright;
				right = right.right;
			}
			if (hleft == hright)
			{
				return (1 << hleft) - 1;
			}
			return countNodes(root.left) + countNodes(root.right) + 1;
		}

		//简洁版
		/*
		public int countNodes(TreeNode root)
		{
			if (root == null)
			{
				return 0;
			}
			TreeNode left = root, right = root;
			int height = 0;
			while (right != null)
			{
				left = left.left;
				right = right.right;
				height++;
			}
			if (left == null)
			{
				return (1 << height) - 1;
			}
			return 1 + countNodes(root.left) + countNodes(root.right);
		}
		*/
	}
}
