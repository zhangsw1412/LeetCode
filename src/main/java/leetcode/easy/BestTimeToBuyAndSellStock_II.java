package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/15.
 */
public class BestTimeToBuyAndSellStock_II
{
	class Solution
	{
		public int maxProfit(int[] a)
		{
			int profit = 0;
			for (int i = 1, len = a.length; i < len; ++i)
			{
				profit += (a[i] - a[i - 1]) > 0 ? (a[i] - a[i - 1]) : 0;
			}
			return profit;
		}
	}
}
