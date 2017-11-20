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
	}
}
