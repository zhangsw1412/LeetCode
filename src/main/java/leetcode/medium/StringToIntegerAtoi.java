package leetcode.medium;

/**
 * Created by zhangsw on 2017/11/6.
 */
public class StringToIntegerAtoi
{
	class Solution
	{
		public int myAtoi(String s)
		{
			//处理空的情况
			if (s == null || s.length() == 0)
			{
				return 0;
			}

			s = s.trim();
			int position = 0, digit, positive = 1;
			double result = 0;

			//处理加减号
			if (s.charAt(position) == '+' || s.charAt(position) == '-')
			{
				positive = s.charAt(position++) == '+' ? 1 : -1;
			}

			for (int len = s.length(); position < len; ++position)
			{
				digit = s.charAt(position) - '0';
				if (digit < 0 || digit > 9)
				{
					break;
				}
				result = result * 10 + digit;
				if (result * positive >= Integer.MAX_VALUE)
				{
					return Integer.MAX_VALUE;
				}
				if (result * positive <= Integer.MIN_VALUE)
				{
					return Integer.MIN_VALUE;
				}
			}
			return (int) result * positive;
		}
	}
}
