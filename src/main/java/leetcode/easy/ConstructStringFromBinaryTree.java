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
		//简洁版
		public String tree2str(TreeNode t)
		{
			if (t == null)
			{
				return "";
			}

			String result = t.val + "";

			String left = tree2str(t.left);
			String right = tree2str(t.right);

			if (left == "" && right == "")
			{
				return result;
			}
			if (left == "")
			{
				return result + "()" + "(" + right + ")";
			}
			if (right == "")
			{
				return result + "(" + left + ")";
			}
			return result + "(" + left + ")" + "(" + right + ")";
		}

		//一行版
		/*
		public String tree2str(TreeNode t)
		{
			return t == null ? "" : t.val + (t.left != null ? "(" + tree2str(
					t.left) + ")" : t.right != null ? "()" : "") + (t.right != null ? "(" + tree2str(
					t.right) + ")" : "");
		}
		*/

		//自己的版本
		/*
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
		*/
	}
}
