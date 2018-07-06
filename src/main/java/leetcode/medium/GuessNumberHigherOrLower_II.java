package leetcode.medium;

/**
 * Created by zhangsw on 2018/7/6.
 */
public class GuessNumberHigherOrLower_II
{
    class Solution
    {
        //动态规划方程：matrix[s][e]=m+Math.max(matrix[s][m-1],matrix[m+1][e])
        public int getMoneyAmount(int n)
        {
            int[][] matrix = new int[n + 1][n + 1];
            return pay(matrix, 1, n);
        }

        public int pay(int[][] matrix, int s, int e)
        {
            if (s >= e)
            {
                return 0;
            }
            if (matrix[s][e] != 0)
            {
                return matrix[s][e];
            }
            int ans = Integer.MAX_VALUE;
            for (int m = s; m <= e; m++)
            {
                int test = m + Math.max(pay(matrix, s, m - 1), pay(matrix, m + 1, e));
                if (test < ans)
                {
                    ans = test;
                }
            }
            matrix[s][e] = ans;
            return ans;
        }
    }
}
