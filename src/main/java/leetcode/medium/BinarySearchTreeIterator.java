package leetcode.medium;

import java.util.Stack;

/**
 * Created by zhangsw on 2018/3/14.
 */
public class BinarySearchTreeIterator
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

	class BSTIterator
	{
		Stack<TreeNode> stack;

		public BSTIterator(TreeNode root)
		{
			stack = new Stack<>();
			while (root != null)
			{
				stack.push(root);
				root = root.left;
			}
		}

		public boolean hasNext()
		{
			return !stack.isEmpty();
		}

		public int next()
		{
			TreeNode temp = stack.pop();
			int val = temp.val;
			temp = temp.right;
			while (temp != null)
			{
				stack.push(temp.right);
				temp = temp.left;
			}
			return val;
		}
	}
}
