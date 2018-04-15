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

	/*
	上面的代码可以进行优化一下，在找完左子树的共同父节点时如果结果存在，且不是p或q，
	那么不用再找右子树了，直接返回这个结果即可，同理，对找完右子树的结果做同样处理
	 */
	/*
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
	{
		if (root == null || root == p || root == q)
		{
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		if (left != null && left != p && left != q)
		{
			return left;
		}
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (right != null && right != p && right != q)
		{
			return right;
		}
		if (left != null && right != null)
		{
			return root;
		}
		return left == null ? right : left;
	}
	*/
}
