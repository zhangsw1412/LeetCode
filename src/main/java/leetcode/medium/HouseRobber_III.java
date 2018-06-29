package leetcode.medium;

/**
 * Created by zhangsw on 2018/6/29.
 */
public class HouseRobber_III
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
        class Money
        {
            int use;
            int notUse;

            Money()
            {
                this.use = 0;
                this.notUse = 0;
            }
        }

        public int rob(TreeNode root)
        {
            Money rootMoney = helper(root);
            return Math.max(rootMoney.use, rootMoney.notUse);
        }

        private Money helper(TreeNode node)
        {
            if (node == null)
            {
                return new Money();
            }
            Money left = helper(node.left);
            Money right = helper(node.right);
            Money root = new Money();
            root.use = left.notUse + right.notUse + node.val;
            root.notUse = Math.max(left.notUse, left.use) + Math.max(right.notUse, right.use);
            return root;
        }
    }
}
