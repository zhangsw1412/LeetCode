package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/9.
 */
public class ValidPerfectSquare
{
	class Solution
	{
		//利用完全平方数都是连续奇数的和这一性质来验证
		public boolean isPerfectSquare(int n)
		{
			for(int i=1;n>0;i+=2)
			{
				n -= i;
			}
			return n == 0;
		}
		/*
		public boolean isPerfectSquare(int n)
		{
			if (n == 1)
			{
				return true;
			}
			long x = n / 2, t = x * x;
			while (t > n)
			{
				x = x / 2;
				t = x * x;
			}
			for (int i = (int) x; i <= x * 2; ++i)
			{
				if (i * i == n)
				{
					return true;
				}
			}
			return false;
		}
		*/
	}
}
