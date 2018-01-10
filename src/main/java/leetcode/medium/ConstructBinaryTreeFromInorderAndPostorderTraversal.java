package leetcode.medium;

/**
 * Created by zhangsw on 2018/1/10.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal
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
		public TreeNode buildTree(int[] inorder, int[] postorder)
		{
			return helper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
		}

		private TreeNode helper(int[] inorder, int[] postorder, int postStart, int inStart, int inEnd)
		{
			if (postStart < 0 || inStart > inEnd)
			{
				return null;
			}
			TreeNode root = new TreeNode(postorder[postStart]);
			int rootIndex = 0;
			for (int i = inStart; i <= inEnd; i++)
			{
				if (inorder[i] == root.val)
				{
					rootIndex = i;
					break;
				}
			}
			root.right = helper(inorder, postorder, postStart - 1, rootIndex + 1, inEnd);
			root.left = helper(inorder, postorder, postStart - inEnd + rootIndex - 1, inStart, rootIndex - 1);

			return root;
		}
	}
}
