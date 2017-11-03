package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2017/11/3.
 */
public class BinaryTreePaths
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
		public List<String> binaryTreePaths(TreeNode root)
		{
			List<String> paths = new ArrayList<>();
			findPath(root, "", paths);
			return paths;
		}

		private void findPath(TreeNode node, String path, List<String> paths)
		{
			if (node != null)
			{
				path += "->" + node.val;
				if (node.left == null && node.right == null)
				{
					paths.add(path.substring(2));
				}
				findPath(node.left, path, paths);
				findPath(node.right, path, paths);
			}
		}
	}
}
