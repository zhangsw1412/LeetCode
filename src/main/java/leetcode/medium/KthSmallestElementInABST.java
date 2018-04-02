package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2018/4/2.
 */
public class KthSmallestElementInABST
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

	//中序遍历版
	public int kthSmallest(TreeNode root, int k)
	{
		List<Integer> list = new ArrayList<>();
		inOrder(root, list);
		return list.get(k - 1);
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
