package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2017/12/4.
 */
public class TwoSum_IV
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
		public boolean findTarget(TreeNode root, int k)
		{
			ArrayList<Integer> list = new ArrayList<>();
			inOrder(root, list);
			int left = 0, right = list.size() - 1;
			while (left < right)
			{
				if (list.get(left) + list.get(right) == k)
				{
					return true;
				}
				else if (list.get(left) + list.get(right) < k)
				{
					++left;
				}
				else
				{
					--right;
				}
			}
			return false;
		}

		private void inOrder(TreeNode node, List<Integer> list)
		{
			if (node == null)
			{
				return;
			}
			inOrder(node.left, list);
			list.add(node.val);
			inOrder(node.right, list);
		}
	}
}
