package leetcode.easy;

import java.util.Arrays;

/**
 * Created by zhangsw on 2017/10/26.
 */
public class CountPrimes
{
	class Solution
	{
		//Eratosthenes筛选法
		public int countPrimes(int n)
		{
			if (n <= 1)
			{
				return 0;
			}
			boolean[] a = new boolean[n - 1];
			Arrays.fill(a, true);
			a[0] = false;
			int threshold = (int) Math.sqrt(n), result = 0;
			for (int i = 2; i <= threshold; ++i)
			{
				if (a[i - 1])
				{
					for (int j = i * i; j < n; j += i)
					{
						a[j - 1] = false;
					}
				}
			}
			for (int i = 0; i < n - 1; ++i)
			{
				if (a[i])
				{
					++result;
				}
			}
			return result;
		}
	}
}
