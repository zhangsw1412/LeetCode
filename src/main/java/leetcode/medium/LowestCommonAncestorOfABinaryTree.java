package leetcode.medium;

/**
 * Created by zhangsw on 2018/4/2.
 */
public class LowestCommonAncestorOfABinaryTree
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

	//下面这种解法的基础是两个节点都在树中
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
	{
		if (root == null || root == p || root == q)
		{
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null)
		{
			return root;
		}
		return left == null ? right : left;
	}
}
