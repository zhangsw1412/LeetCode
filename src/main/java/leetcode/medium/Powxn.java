package leetcode.medium;

/**
 * Created by zhangsw on 2017/12/25.
 */
public class Powxn
{
	class Solution
	{
		public double pow(double x, int n)
		{
			if (n == 0)
			{
				return 1;
			}
			if (n < 0)
			{
				n = -n;
				x = 1 / x;
			}
			return (n % 2 == 0) ? pow(x * x, n / 2) : x * pow(x * x, n / 2);
		}
		//这个写法有点作弊...
		/*
		public double myPow(double x, int n)
		{
			return Math.pow(x, n);
		}
		*/
	}
}
