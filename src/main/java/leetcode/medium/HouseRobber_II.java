package leetcode.medium;

/**
 * Created by zhangsw on 2018/3/26.
 */
public class HouseRobber_II
{
	class Solution
	{
		/*
		如果抢了第一家，就不能抢最后一家。
		所以我们可以分别计算抢了从第二家到最后一家与抢从第一家到倒数第二家的最大值，取两个值中更大的那个就是结果
		 */
		public int rob(int[] a)
		{
			if (a.length <= 1)
			{
				return a.length == 0 ? 0 : a[0];
			}
			int[] dp = new int[a.length];
			dp[0] = a[0];
			for (int i = 1; i < a.length - 1; ++i)
			{
				dp[i] = Math.max(dp[i - 1], (i == 1 ? 0 : dp[i - 2]) + a[i]);
			}
			int res = dp[a.length - 2];
			dp[1] = a[1];
			for (int i = 2; i < a.length; ++i)
			{
				dp[i] = Math.max(dp[i - 1], (i == 2 ? 0 : dp[i - 2]) + a[i]);
			}
			return Math.max(res, dp[a.length - 1]);
		}
	}
}
