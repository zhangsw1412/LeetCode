package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/3.
 */
public class UglyNumber
{
	class Solution
	{
		/*
		想要判断质因数里是不是只有2，3，5只要一直除下去就好了
		 */
		public boolean isUgly(int n)
		{
			if (n <= 0)
			{
				return false;
			}
			while ((n % 2) == 0)
			{
				n /= 2;
			}
			while ((n % 3) == 0)
			{
				n /= 3;
			}
			while ((n % 5) == 0)
			{
				n /= 5;
			}
			return n == 1;
		}
	}
}
