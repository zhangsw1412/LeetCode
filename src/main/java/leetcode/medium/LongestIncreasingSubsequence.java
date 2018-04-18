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

		//二分查找版，时间复杂度O(nlogn)，没看懂
		/*
		public int lengthOfLIS(int[] nums)
		{
			int[] dp = new int[nums.length];
			int len = 0;

			for (int x : nums)
			{
				int i = Arrays.binarySearch(dp, 0, len, x);
				if (i < 0)
				{
					i = -(i + 1);
				}
				dp[i] = x;
				if (i == len)
				{
					len++;
				}
			}
			return len;
		}
		*/
	}
}
