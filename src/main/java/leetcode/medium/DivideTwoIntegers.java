package leetcode.medium;

/**
 * Created by zhangsw on 2017/12/17.
 */
public class DivideTwoIntegers
{
	class Solution
	{
		public int divide(int dividend, int divisor)
		{
			long a = Math.abs((long)dividend), b = Math.abs((long)divisor), result = 0;
			if (a < b)
			{
				return 0;
			}
			while (a >= b)
			{
				long c = b, counter = 1;
				while (a >= (c << 1))
				{
					c <<= 1;
					counter <<= 1;
				}
				result += counter;
				a -= c;
			}
			if ((dividend < 0) ^ (divisor < 0))
			{
				result = -result;
			}
			return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
		}
	}
}
