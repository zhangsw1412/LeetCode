package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2018/1/2.
 */
public class BinaryTreeInorderTraversal
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
		//递归版
		public List<Integer> inorderTraversal(TreeNode root)
		{
			List<Integer> list = new ArrayList<>();
			inOrder(list, root);
			return list;
		}

		private void inOrder(List<Integer> list, TreeNode node)
		{
			if (node == null)
			{
				return;
			}
			inOrder(list, node.left);
			list.add(node.val);
			inOrder(list, node.right);
		}
	}
}
