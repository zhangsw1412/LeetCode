package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2018/3/19.
 */
public class BinaryTreeRightSideView
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
		public List<Integer> rightSideView(TreeNode root)
		{
			List<Integer> list = new ArrayList<>();
			inOrder(root, 0, list);
			return list;
		}

		private void inOrder(TreeNode node, int height, List<Integer> list)
		{

			if (node != null)
			{
				if (list.size() == height)
				{
					list.add(node.val);
				}
				inOrder(node.right, height + 1, list);
				inOrder(node.left, height + 1, list);
			}
		}
	}
}
