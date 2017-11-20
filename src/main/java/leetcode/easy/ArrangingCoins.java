package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/20.
 */
public class ArrangingCoins
{
	class Solution
	{
		public int arrangeCoins(int n)
		{
			int i = 0;
			while (i <= n)
			{
				n -= i++;
			}
			return i - 1;
		}

		/*
		等差数列求和公式sum = (x + 1) * x / 2
		解这个方程算出x
		 */
		/*
		public class Solution
		{
			public int arrangeCoins(int n)
			{
				return (int) ((-1 + Math.sqrt(1 + 8 * (long) n)) / 2);
			}
		}
		*/
	}
}
