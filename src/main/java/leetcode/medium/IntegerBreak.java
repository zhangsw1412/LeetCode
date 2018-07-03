package leetcode.medium;

/**
 * Created by zhangsw on 2018/7/3.
 */
public class IntegerBreak
{
    class Solution
    {
        //动态规划方法
        public int integerBreak(int n)
        {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3; i <= n; i++)
            {
                for (int j = 1; j < i; j++)
                {
                    dp[i] = Math.max(dp[j] * (i - j), Math.max(dp[i], j * (i - j)));
                }
            }
            return dp[n];
        }
    }
}
