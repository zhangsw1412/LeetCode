package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2017/12/3.
 */
public class AverageOfLevelsInBinaryTree
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
		//自己的版本
		public List<Double> averageOfLevels(TreeNode root)
		{
			double[] sum = new double[9999];
			double[] count = new double[9999];
			helper(root, 0, sum, count);
			List<Double> list = new ArrayList<>();
			for (int i = 0; i < sum.length; i++)
			{
				if (count[i] != 0)
				{
					list.add(sum[i] / count[i]);
				}
			}
			return list;
		}

		private void helper(TreeNode node, int level, double[] sum, double[] count)
		{
			if (node == null)
			{
				return;
			}
			sum[level] += node.val;
			++count[level];
			helper(node.left, level + 1, sum, count);
			helper(node.right, level + 1, sum, count);
		}
	}
}
