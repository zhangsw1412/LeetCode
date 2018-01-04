package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2018/1/3.
 */
public class UniqueBinarySearchTrees_II
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
		public List<TreeNode> generateTrees(int n)
		{
			return n < 1 ? new ArrayList<>() : genTreeList(1, n);
		}

		private List<TreeNode> genTreeList(int start, int end)
		{
			List<TreeNode> list = new ArrayList<>();
			if (start > end)
			{
				list.add(null);
			}
			for (int idx = start; idx <= end; idx++)
			{
				List<TreeNode> leftList = genTreeList(start, idx - 1);
				List<TreeNode> rightList = genTreeList(idx + 1, end);
				for (TreeNode left : leftList)
				{
					for (TreeNode right : rightList)
					{
						TreeNode root = new TreeNode(idx);
						root.left = left;
						root.right = right;
						list.add(root);
					}
				}
			}
			return list;
		}
	}
}
