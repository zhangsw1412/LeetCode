package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/25.
 */
public class PerfectNumber
{
	class Solution
	{
		public boolean checkPerfectNumber(int n)
		{
			if (n == 1)
			{
				return false;
			}
			int sum = 1;
			for (int i = 2, limit = (int) Math.sqrt(n); i <= limit; ++i)
			{
				if ((n % i) == 0)
				{
					if (i != (n / i))
					{
						sum += n / i;
					}
					sum += i;
				}
			}
			return sum == n;
		}
	}
}
