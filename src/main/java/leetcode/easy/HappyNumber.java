package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/26.
 */
public class HappyNumber
{
	class Solution
	{
		/*
		常规的解法是将每次算出的结果放入一个set中，有重复就结束
		这里用一个偷懒的办法，如果结果中有4，那么一定会循环
		 */
		public boolean isHappy(int n)
		{
			int temp = 0;
			while (n != 1 && n != 4)
			{
				while (n != 0)
				{
					temp += Math.pow(n % 10, 2);
					n /= 10;
				}
				n = temp;
				temp = 0;
			}
			return n == 1;
		}
	}
}
