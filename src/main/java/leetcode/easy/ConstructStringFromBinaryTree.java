package leetcode.easy;

/**
 * Created by zhangsw on 2017/12/2.
 */
public class ConstructStringFromBinaryTree
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
		public String tree2str(TreeNode root)
		{
			StringBuilder stringBuilder = new StringBuilder();
			helper(root, stringBuilder);
			return stringBuilder.toString();
		}

		private void helper(TreeNode node, StringBuilder stringBuilder)
		{
			if (node == null)
			{
				return;
			}
			stringBuilder.append(node.val);
			if (node.left != null || node.right != null)
			{
				stringBuilder.append("(");
				helper(node.left, stringBuilder);
				stringBuilder.append(")");
				if (node.right != null)
				{
					stringBuilder.append("(");
					helper(node.right, stringBuilder);
					stringBuilder.append(")");
				}
			}
		}
	}
}
