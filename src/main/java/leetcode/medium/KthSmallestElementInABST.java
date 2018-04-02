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

	/*
	由于BST的性质，我们可以快速定位出第k小的元素是在左子树还是右子树，
	我们首先计算出左子树的结点个数总和cnt，如果k小于等于左子树结点总和cnt，
	说明第k小的元素在左子树中，直接对左子结点调用递归即可。
	如果k大于cnt+1，说明目标值在右子树中，对右子结点调用递归函数，
	注意此时的k应为k-cnt-1，应为已经减少了cnt+1个结点。
	如果k正好等于cnt+1，说明当前结点即为所求，返回当前结点值即可
	 */
	/*
	public int kthSmallest(TreeNode root, int k)
	{
		int count = countNodes(root.left);
		if (k <= count)
		{
			return kthSmallest(root.left, k);
		}
		else if (k > count + 1)
		{
			return kthSmallest(root.right, k - 1 - count); // 1 is counted as current node
		}

		return root.val;
	}

	public int countNodes(TreeNode n)
	{
		if (n == null)
		{
			return 0;
		}

		return 1 + countNodes(n.left) + countNodes(n.right);
	}
	*/
}
