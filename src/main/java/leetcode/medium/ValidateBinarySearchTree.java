package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2018/1/4.
 */
public class ValidateBinarySearchTree
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
		public boolean isValidBST(TreeNode root)
		{
			List<Integer> list = new ArrayList<>();
			inOrder(list, root);
			for (int i = 0; i < list.size() - 1; ++i)
			{
				if (list.get(i) >= list.get(i + 1))
				{
					return false;
				}
			}
			return true;
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
