package leetcode.medium;

/**
 * Created by zhangsw on 2018/6/25.
 */
public class VerifyPreorderSerializationOfABinaryTree
{
    class Solution
    {
        public boolean isValidSerialization(String preorder)
        {
            int counter = 1;
            for (String s : preorder.split(","))
            {
                if (--counter < 0)
                {
                    return false;
                }
                if (!s.equals("#"))
                {
                    counter += 2;
                }
            }
            return counter == 0;
        }
    }
}
