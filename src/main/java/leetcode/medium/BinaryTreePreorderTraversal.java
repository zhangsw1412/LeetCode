package leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhangsw on 2018/3/8.
 */
public class BinaryTreePreorderTraversal
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
		//迭代版
		public List<Integer> preorderTraversal(TreeNode node)
		{
			List<Integer> list = new LinkedList<>();
			Stack<TreeNode> rights = new Stack<>();
			while (node != null)
			{
				list.add(node.val);
				if (node.right != null)
				{
					rights.push(node.right);
				}
				node = node.left;
				if (node == null && !rights.isEmpty())
				{
					node = rights.pop();
				}
			}
			return list;
		}
		//递归版
		/*
		public List<Integer> preorderTraversal(TreeNode root)
		{
			List<Integer> list = new LinkedList<>();
			preorder(root, list);
			return list;
		}

		private void preorder(TreeNode node, List<Integer> list)
		{
			if (node == null)
			{
				return;
			}
			list.add(node.val);
			preorder(node.left, list);
			preorder(node.right, list);
		}
		*/
	}
}
