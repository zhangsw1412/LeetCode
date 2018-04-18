package leetcode.medium;

import java.util.Arrays;

/**
 * Created by zhangsw on 2018/4/18.
 */
public class LongestIncreasingSubsequence
{
	class Solution
	{
		public int lengthOfLIS(int[] n)
		{
			if (n == null || n.length == 0)
			{
				return 0;
			}
			int[] dp = new int[n.length];
			Arrays.fill(dp, 1);
			int max = 0;
			for (int i = 0; i < n.length; i++)
			{
				for (int j = 0; j < i; j++)
				{
					if (n[j] < n[i])
					{
						dp[i] = Math.max(dp[j] + 1, dp[i]);
					}
				}
				max = Math.max(max, dp[i]);
			}
			return max;
		}
	}
}
