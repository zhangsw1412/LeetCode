package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/15.
 */
public class BestTimeToBuyAndSellStock
{
	class Solution
	{
		public int maxProfit(int[] a)
		{
			if (a == null || a.length == 0)
			{
				return 0;
			}
			int min = a[0], profile = 0;
			for (int i = 1, len = a.length; i < len; ++i)
			{
				if (a[i] < min)
				{
					min = a[i];
				}
				else
				{
					if (profile < (a[i] - min))
					{
						profile = a[i] - min;
					}
				}
			}
			return profile;
		}
	}
}
