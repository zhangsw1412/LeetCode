package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2018/1/11.
 */
public class PathSum_II
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
		public List<List<Integer>> pathSum(TreeNode root, int sum)
		{
			List<List<Integer>> list = new ArrayList<>();
			backtrack(list, new ArrayList<>(), root, sum);
			return list;
		}

		private void backtrack(List<List<Integer>> list, List<Integer> temp, TreeNode node, int sum)
		{
			if (node == null)
			{
				return;
			}
			temp.add(node.val);
			if (node.left == null && node.right == null && sum == node.val)
			{
				list.add(new ArrayList<>(temp));
				temp.remove(temp.size() - 1);
				return;
			}
			backtrack(list, temp, node.left, sum - node.val);
			backtrack(list, temp, node.right, sum - node.val);
			temp.remove(temp.size() - 1);
		}
	}
}
