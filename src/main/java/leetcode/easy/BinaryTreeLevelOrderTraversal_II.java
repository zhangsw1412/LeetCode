package leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangsw on 2017/10/10.
 */
public class BinaryTreeLevelOrderTraversal_II
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
		public List<List<Integer>> levelOrderBottom(TreeNode root)
		{
			List<List<Integer>> list = new ArrayList<>();
			fillList(root, 1, list);
			return list;
		}

		private void fillList(TreeNode node, int depth, List<List<Integer>> list)
		{
			if (node == null)
			{
				return;
			}
			if (depth > list.size())
			{
				list.add(0, new LinkedList<>());
			}
			list.get(list.size() - depth).add(node.val);
			fillList(node.left, depth + 1, list);
			fillList(node.right, depth + 1, list);
		}
	}
}
