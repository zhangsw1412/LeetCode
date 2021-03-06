package leetcode.medium;

/**
 * Created by zhangsw on 2018/4/19.
 */
public class BestTimeToBuyAndSellStockWithCooldown
{
	class Solution
	{
		/*
		考虑用动态规划法解决问题，因为当前日期买卖股票的行为会受到之前日期买卖股票行为影响。
		对一天的状态有：buy买入，sell卖出，cooldown冷却。
		但是对于这一天是否持股只有两种状态：持股状态（buy），没有持股状态（sell，cooldown）。
		对于当天持股状态时，至当天的为止的最大利润有两种可能：1、今天没有买入，跟昨天持股状态一样；2、今天买入，昨天是冷却期，利润是前天卖出股票时候得到的利润减去今天股票的价钱。 二者取最大值。
		对于当天未持股状态，至当天为止的最大利润有两种可能：1、今天没有卖出，跟昨天未持股状态一样；2、昨天持有股票，今天卖出了，利润是昨天持有股票时候的利润加上今天股票的价钱。 二者取最大值。
		直至最后一天的状态应该是卖出状态。最终利润为sell[n-1];
		状态转移方程：
		sell[i] = max(sell[i-1], buy[i-1] + price[i]);
		buy[i] = max(buy[i-1], sell[i-2] - price[i]);
		 */
		public int maxProfit(int[] prices)
		{
			int n = prices.length;
			if (n == 0)
			{
				return 0;
			}
			int[] sell = new int[n];
			int[] buy = new int[n];
			sell[0] = 0;
			buy[0] = -prices[0];
			for (int i = 1; i < n; i++)
			{
				sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
				if (i >= 2)
				{
					buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
				}
				else
				{
					buy[i] = Math.max(buy[i - 1], -prices[i]);
				}
			}
			return sell[n - 1];
		}
	}
}
