package leetcode.easy;

/**
 * Created by zhangsw on 2017/12/1.
 */
public class CanPlaceFlowers
{
	class Solution
	{
		public boolean canPlaceFlowers(int[] a, int b)
		{
			for (int i = 0; i < a.length; i++)
			{
				while (i < a.length && a[i] == 1)
				{
					++i;
				}
				if (((i - 1) < 0 || a[i - 1] == 0) && ((i + 1 >= a.length) || a[i + 1] == 0))
				{
					--b;
					a[i] = 1;
				}
			}
			return b <= 0;
		}
	}
}
