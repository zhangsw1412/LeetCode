package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/31.
 */
public class PowerOfTwo
{
	class Solution
	{
		/*
		二的次方数改写为二进制时，都是一个1后面跟着若干个0的样子如8的二进制就写为1000
		所以只要计算其中1的个数就可以了
		 */
		public boolean isPowerOfTwo(int n)
		{
			int count = 0;
			while (n > 0)
			{
				if ((n & 1) == 1)
				{
					++count;
				}
				n >>>= 1;
			}
			return count == 1;
		}
	}
}
